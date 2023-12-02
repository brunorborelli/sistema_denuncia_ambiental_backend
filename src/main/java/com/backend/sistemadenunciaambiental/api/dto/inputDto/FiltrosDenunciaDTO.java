package com.backend.sistemadenunciaambiental.api.dto.inputDto;

import com.backend.sistemadenunciaambiental.domain.enums.CategoriaPaiDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiltrosDenunciaDTO {

    private String municipio;

    private LocalDate data;

    private LocalDate dataCadastro;

    private String protocolo;

    private StatusEnum status;

    private CategoriaPaiDenunciaEnum categoriaPai;

}
