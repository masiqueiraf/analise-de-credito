package com.masiqueira.analisecredito.service.strategy;

import com.masiqueira.analisecredito.domain.Proposta;

public interface CalculoPonto {

    int calcular(Proposta proposta);
}
