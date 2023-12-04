package com.backend.sistemadenunciaambiental.api.controller;

import com.backend.sistemadenunciaambiental.api.dto.inputDto.LoginInputDto;
import com.backend.sistemadenunciaambiental.domain.modelo.Usuario;
import com.backend.sistemadenunciaambiental.domain.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/") // Cors Fix
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginInputDto loginInputDto) {
        String token = authService.login(loginInputDto);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/getUsuarioLogado")
    public ResponseEntity<Usuario> getUsuarioLogado(@RequestHeader(name = "Authorization") String token) {
        Usuario usuario = authService.getUsuarioLogado(token);
        return ResponseEntity.ok().body(usuario);
    }
}