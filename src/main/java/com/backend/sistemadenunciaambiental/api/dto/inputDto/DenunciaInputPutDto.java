package com.backend.sistemadenunciaambiental.api.dto.inputDto;

import com.backend.sistemadenunciaambiental.domain.enums.CategoriaFilhaDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.enums.CategoriaPaiDenunciaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DenunciaInputPutDto {

    private CategoriaPaiDenunciaEnum categoriaPai;

    private CategoriaFilhaDenunciaEnum categoriaFilha;

}
