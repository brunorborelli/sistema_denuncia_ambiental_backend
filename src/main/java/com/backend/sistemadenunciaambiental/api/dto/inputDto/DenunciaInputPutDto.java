package com.backend.sistemadenunciaambiental.api.dto.inputDto;

import com.backend.sistemadenunciaambiental.domain.enums.CategoriaFilhaDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.enums.CategoriaPaiDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DenunciaInputPutDto {

    private CategoriaPaiDenunciaEnum categoriaPai;

    private CategoriaFilhaDenunciaEnum categoriaFilha;

    private StatusEnum status;
    //TODO remover status do put de denuncia no requisito r008 so pede categoria e subcategoria
}
