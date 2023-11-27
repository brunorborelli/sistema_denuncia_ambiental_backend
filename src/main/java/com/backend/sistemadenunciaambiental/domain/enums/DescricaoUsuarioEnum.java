package com.backend.sistemadenunciaambiental.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum DescricaoUsuarioEnum {

    DENUNCIANTE(0, "Denunciante"),
    ANALISTA(1, "Analista");

    private Integer id;
    private String descricao;

}
