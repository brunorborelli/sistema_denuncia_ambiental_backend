package com.backend.sistemadenunciaambiental.domain.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum CategoriaPaiDenunciaEnum {

    FAUNA(0, "Fauna"),
    FLORA(1, "Flora"),
    POLUICAO(2, "Poluição"),
    ODENAMENTO_URBANO_E_PATRIMONIO_CULTURAL(3, "Odenamento Urbano e Patrimonio Cultural"),
    ADMINISTRACAO_AMBIENTAL(4, "Administracao Ambiental");


    private Integer id;
    private String descricao;


}
