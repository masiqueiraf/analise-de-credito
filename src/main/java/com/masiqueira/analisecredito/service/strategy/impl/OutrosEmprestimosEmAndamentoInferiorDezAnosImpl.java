package com.masiqueira.analisecredito.service.strategy.impl;

import com.masiqueira.analisecredito.domain.Proposta;
import com.masiqueira.analisecredito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OutrosEmprestimosEmAndamentoInferiorDezAnosImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return outroEmprestimoEmAndamento() ? 0 : 80;
    }

    private boolean outroEmprestimoEmAndamento() {
        return new Random().nextBoolean();
    }
}
