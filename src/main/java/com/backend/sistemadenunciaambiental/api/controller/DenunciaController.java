package com.backend.sistemadenunciaambiental.api.controller;

import com.backend.sistemadenunciaambiental.api.dto.inputDto.DenunciaInputDto;
import com.backend.sistemadenunciaambiental.api.dto.inputDto.DenunciaInputPutDto;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.DenunciaInputParecerDTO;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.DenunciaOutputDto;
import com.backend.sistemadenunciaambiental.domain.modelo.Denuncia;
import com.backend.sistemadenunciaambiental.domain.service.DenunciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/denuncia")
@CrossOrigin(origins = "http://localhost:4200/") //Cors Fix
public class DenunciaController {

    private final DenunciaService denunciaService;

    @GetMapping("/{denunciaId}")
    public ResponseEntity<DenunciaOutputDto> buscarDenunciaPorId(@PathVariable Long denunciaId) {
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

    @PatchMapping ("/parecer-tecnico/{denunciaId}")
    public ResponseEntity<Void> parecerDenuncia(@PathVariable Long denunciaId, @RequestBody DenunciaInputParecerDTO inputPutDTO) {
        denunciaService.parecerDenuncia(denunciaId, inputPutDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<Denuncia>> buscarDenuncias() {
        List<Denuncia> denuncias = denunciaService.buscarDenuncias();
        return ResponseEntity.ok(denuncias);
    }

    @GetMapping("/filtros")
    public ResponseEntity<?> getDenunciaComFiltro(
            @RequestParam(required = false) Integer categoriaPai ,
            @RequestParam(required = false) String protocolo,
            @RequestParam(required = false) String municipio,
            @RequestParam(required = false) LocalDate data,
            @RequestParam(required = false) LocalDate dataCadastro,
            @RequestParam(required = false) Integer status,
            @RequestParam(required = false) String token) {

        List<DenunciaOutputDto> outputDtoList = denunciaService.getDenunciaComFiltro(
                categoriaPai,
                protocolo,
                municipio,
                data,
                dataCadastro,
                status,
                token);
        if(outputDtoList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok().body(outputDtoList);
    }

}
