package com.masiqueira.analisecredito.listener;

import com.masiqueira.analisecredito.domain.Proposta;
import com.masiqueira.analisecredito.service.AnaliseCreditoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropostaEmAnaliseListener {

    private final AnaliseCreditoService analiseCreditoService;

    public PropostaEmAnaliseListener(AnaliseCreditoService analiseCreditoService) {
        this.analiseCreditoService = analiseCreditoService;
    }

    @RabbitListener(queues = "${proposta-pendente.ms-analise-credito}")
    public void propostaEmAnalise(Proposta proposta) {
        analiseCreditoService.analisar(proposta);
    }
}
