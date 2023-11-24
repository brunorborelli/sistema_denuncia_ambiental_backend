package com.backend.sistemadenunciaambiental.api.dto.inputDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInputDto {
    private String cpf;
    private String password;
}
