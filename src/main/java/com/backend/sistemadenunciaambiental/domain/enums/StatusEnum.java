package com.backend.sistemadenunciaambiental.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum StatusEnum {

    CRIADA (0, "Criada"),
    EM_ANDAMENTO(1, "Em andamento"),
    CONCLUIDA(2, "Concluida");

    private Integer id;
    private String descricao;


}
