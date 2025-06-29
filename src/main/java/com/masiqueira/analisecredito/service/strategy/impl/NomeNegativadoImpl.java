package com.masiqueira.analisecredito.service.strategy.impl;

import com.masiqueira.analisecredito.constante.MensagemConstante;
import com.masiqueira.analisecredito.domain.Proposta;
import com.masiqueira.analisecredito.exceptions.StrategyException;
import com.masiqueira.analisecredito.service.strategy.CalculoPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class NomeNegativadoImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {

        if (nomeNegativado()) {
            throw new StrategyException(String.format(MensagemConstante.CLIENTE_NEGATIVADO, proposta.getUsuario().getNome()));
        }

        return 100;
    }

    private boolean nomeNegativado() {
        return new Random().nextBoolean();
    }
}
