package com.backend.sistemadenunciaambiental.api.dto.inputDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiltrosDenunciaDTO {

    private Integer categoriaPai;

    private String protocolo;

    private String municipio;

    private String data;

    private String dataCadastro;

    private Integer status;

}
