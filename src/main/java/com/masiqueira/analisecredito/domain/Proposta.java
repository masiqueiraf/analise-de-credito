package com.masiqueira.analisecredito.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Proposta {
    private Long id;
    private Double valorSolicitado;
    private int prazoPagamento;
    private Boolean aprovada;
    private boolean integrada;
    private String observacao;
    @Getter
    private Usuario usuario;

    public void setAprovada(Boolean aprovada) {
        this.aprovada = aprovada;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
