package com.masiqueira.analisecredito.service;

import com.masiqueira.analisecredito.domain.Proposta;
import com.masiqueira.analisecredito.exceptions.StrategyException;
import com.masiqueira.analisecredito.service.strategy.CalculoPonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AnaliseCreditoService {

    @Autowired
    private final List<CalculoPonto> calculoPontoList;
    @Autowired
    private NotificacaoRabbitService notificacaoRabbitService;
    @Value("${rabbitmq.propostaconcluida.exchange}")
    private String exchangePropostaConcluida;

    public AnaliseCreditoService(List<CalculoPonto> calculoPontoList) {
        this.calculoPontoList = calculoPontoList;
    }

    public void analisar(Proposta proposta) {

        try {
            int pontos = calculoPontoList.stream().mapToInt(impl -> impl.calcular(proposta)).sum();
            proposta.setAprovada(pontos > 350);
        } catch (StrategyException ex) {
            proposta.setAprovada(false);
            proposta.setObservacao(ex.getMessage());
        }

        notificacaoRabbitService.notificar(exchangePropostaConcluida, proposta);
    }
}
