package com.backend.sistemadenunciaambiental.api.controller;

import com.backend.sistemadenunciaambiental.api.dto.inputDto.UsuarioInputDto;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.UsuarioOutputDTO;
import com.backend.sistemadenunciaambiental.domain.modelo.Usuario;
import com.backend.sistemadenunciaambiental.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200/") //Cors Fix
public class PessoaController {

    private final UsuarioService usuarioService;


    @GetMapping("/{usuarioId}")
    public ResponseEntity<UsuarioOutputDTO> buscarUsuarioPorId(@PathVariable Long usuarioId) {
        UsuarioOutputDTO outputDTO = usuarioService.buscarUsuarioPorId(usuarioId);
        return ResponseEntity.ok(outputDTO);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody UsuarioInputDto inputDTO) {
        usuarioService.cadastrarUsuario(inputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/alterar/{usuarioId}")
    public ResponseEntity<Void> alterarUsuario(@PathVariable Long usuarioId, @RequestBody UsuarioInputDto inputDTO) {
        usuarioService.alterarUsuario(usuarioId, inputDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> buscarUsuario(){
        List<Usuario> usuarios = usuarioService.buscarUsuarios();
        return ResponseEntity.ok(usuarios);
    }


}
