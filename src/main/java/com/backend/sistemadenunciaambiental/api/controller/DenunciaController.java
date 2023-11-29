package com.backend.sistemadenunciaambiental.api.controller;

import com.backend.sistemadenunciaambiental.api.dto.inputDto.DenunciaInputDto;
import com.backend.sistemadenunciaambiental.api.dto.inputDto.DenunciaInputPutDto;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.DenunciaOutputDto;
import com.backend.sistemadenunciaambiental.domain.modelo.Denuncia;
import com.backend.sistemadenunciaambiental.domain.service.DenunciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/denuncia")
public class DenunciaController {

    private final DenunciaService denunciaService;

    @GetMapping("/{denunciaId}")
    public ResponseEntity<DenunciaOutputDto> buscarUsuarioPorId(@PathVariable Long denunciaId) {
        DenunciaOutputDto outputDTO = denunciaService.buscarDenunciaPorId(denunciaId);
        return ResponseEntity.ok(outputDTO);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrarDenuncia(@RequestBody DenunciaInputDto inputDTO) {
        denunciaService.cadastrarDenuncia(inputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/alterar/{denunciaId}")
    public ResponseEntity<Void> alterarDenuncia(@PathVariable Long denunciaId, @RequestBody DenunciaInputPutDto inputPutDTO) {
        denunciaService.alterarDenuncia(denunciaId, inputPutDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Denuncia>> buscarUsuarioPorId() {
        List<Denuncia> denuncias = denunciaService.buscarDenuncias();
        return ResponseEntity.ok(denuncias);
    }

}
