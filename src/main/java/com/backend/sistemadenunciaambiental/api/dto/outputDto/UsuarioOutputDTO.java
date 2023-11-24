package com.backend.sistemadenunciaambiental.api.dto.outputDto;

import com.backend.sistemadenunciaambiental.domain.enums.DescricaoUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioOutputDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private DescricaoUsuarioEnum descricao;
    private String telefone;
    private LocalDateTime dataCadastro;
    private Boolean ativo;
}
