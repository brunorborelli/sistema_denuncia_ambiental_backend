package com.backend.sistemadenunciaambiental.api.controller;

import com.backend.sistemadenunciaambiental.api.dto.inputDto.UsuarioInputDTO;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.UsuarioOutputDTO;
import com.backend.sistemadenunciaambiental.api.util.ValidationService;
import com.backend.sistemadenunciaambiental.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class PessoaController {

    private final UsuarioService usuarioService;


    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioOutputDTO> buscarUsuarioPorId(@PathVariable Long usuarioId) {
        UsuarioOutputDTO outputDTO = usuarioService.buscarUsuarioPorId(usuarioId);
        return ResponseEntity.ok(outputDTO);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody UsuarioInputDTO inputDTO) {
        usuarioService.cadastrarUsuario(inputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/alterar/{usuarioId}")
    public ResponseEntity<Void> alterarUsuario(@PathVariable Long usuarioId, @RequestBody UsuarioInputDTO inputDTO) {
        usuarioService.alterarUsuario(usuarioId, inputDTO);
        return ResponseEntity.noContent().build();
    }


}
