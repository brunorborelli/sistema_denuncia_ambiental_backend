package com.backend.sistemadenunciaambiental.api.controller;

import com.backend.sistemadenunciaambiental.api.dto.inputDto.LoginInputDto;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.LoginOutputDto;
import com.backend.sistemadenunciaambiental.domain.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginOutputDto> login(@RequestBody LoginInputDto loginInputDto) {
            LoginOutputDto loginOutputDto = authService.login(loginInputDto);
            return ResponseEntity.ok().body(loginOutputDto);

    }
}