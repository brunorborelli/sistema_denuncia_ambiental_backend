package com.backend.sistemadenunciaambiental.domain.service;

import com.backend.sistemadenunciaambiental.api.dto.inputDto.LoginInputDto;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.LoginOutputDto;
import com.backend.sistemadenunciaambiental.api.util.CripitografiaUtil;
import com.backend.sistemadenunciaambiental.domain.exception.NegocioException;
import com.backend.sistemadenunciaambiental.domain.modelo.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioService usuarioService;

    public LoginOutputDto login(LoginInputDto loginInputDto){
        Usuario usuario= usuarioService.buscarUsuarioPorCpf(loginInputDto.getCpf());
        String passwordLogin = CripitografiaUtil.hashSHA512(loginInputDto.getPassword());
        if(!passwordLogin.matches(usuario.getPassword())){
            throw new NegocioException("CPF ou Senha incorretos. Esqueceu a senha? Tente recuperar a senha");
        }
        LoginOutputDto outputDto = new LoginOutputDto();
        outputDto.setAutorizado(true);
        outputDto.setDescricao(usuario.getDescricao());
        return outputDto;
    }

}
