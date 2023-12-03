package com.backend.sistemadenunciaambiental.domain.service;

import com.backend.sistemadenunciaambiental.api.dto.inputDto.LoginInputDto;
import com.backend.sistemadenunciaambiental.api.util.CripitografiaUtil;
import com.backend.sistemadenunciaambiental.domain.exception.NegocioException;
import com.backend.sistemadenunciaambiental.domain.modelo.Usuario;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioService usuarioService;

    public String login(LoginInputDto loginInputDto) {
        Usuario usuario = usuarioService.buscarUsuarioPorCpf(loginInputDto.getCpf());
        String passwordLogin = CripitografiaUtil.hashSHA512(loginInputDto.getPassword());
        if (!passwordLogin.matches(usuario.getPassword())) {
            throw new NegocioException("CPF ou Senha incorretos. Esqueceu a senha? Tente recuperar a senha");
        }

        String token = UUID.randomUUID().toString();

        usuarioService.updateToken(token, usuario);

        return token;
        // TODO retornar junto os dados do usuario
    }

    public Usuario getUsuarioLogado(String token) {

        if (token == null || token.isEmpty()) {
            throw new NegocioException("Token vazio");
        }

        Usuario usuario = usuarioService.buscarUsuarioPorToken(token);

        if (usuario == null) {
            throw new NegocioException("Token invalido");
        }

        return usuario;
    }

}
