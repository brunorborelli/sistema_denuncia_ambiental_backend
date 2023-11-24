package com.backend.sistemadenunciaambiental.api.dto.inputDto;

import com.backend.sistemadenunciaambiental.domain.enums.DescricaoUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioInputDTO {

    private String nome;
    private String cpf;
    private String email;
    private DescricaoUsuarioEnum descricao;
    private String telefone;
    private String password;
    private String confirmarPassword;
}
