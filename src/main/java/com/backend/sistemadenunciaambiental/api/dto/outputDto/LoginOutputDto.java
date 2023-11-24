package com.backend.sistemadenunciaambiental.api.dto.outputDto;

import com.backend.sistemadenunciaambiental.domain.enums.DescricaoUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginOutputDto {
    private boolean autorizado;
    private DescricaoUsuarioEnum descricao;
}
