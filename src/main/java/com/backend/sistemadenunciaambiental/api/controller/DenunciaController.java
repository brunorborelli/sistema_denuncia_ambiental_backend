package com.backend.sistemadenunciaambiental.api.controller;

import com.backend.sistemadenunciaambiental.api.dto.inputDto.DenunciaInputDto;
import com.backend.sistemadenunciaambiental.api.dto.inputDto.DenunciaInputPutDto;
import com.backend.sistemadenunciaambiental.api.dto.inputDto.FiltrosDenunciaDTO;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.DenunciaInputParecerDTO;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.DenunciaOutputDto;
import com.backend.sistemadenunciaambiental.domain.enums.CategoriaPaiDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.enums.StatusEnum;
import com.backend.sistemadenunciaambiental.domain.modelo.Denuncia;
import com.backend.sistemadenunciaambiental.domain.service.DenunciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/filtros")
//    public ResponseEntity<List<DenunciaOutputDto>> getDenunciaComFiltro(
//            @RequestParam CategoriaPaiDenunciaEnum categoriaPai ,
//            @RequestParam String protocolo,
//            @RequestParam String municipio,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataCadastro,
//            @RequestParam StatusEnum status) {
//
//        List<DenunciaOutputDto> outputDtoList = denunciaService.getDenunciaComFiltro(
//                categoriaPai,
//                protocolo,
//                municipio,
//                data,
//                dataCadastro,
//                status);
//
//        return ResponseEntity.ok().body(outputDtoList);
//    }

//    @GetMapping("/filtros")
//    public ResponseEntity<List<DenunciaOutputDto>> getDenunciaComFiltro(@RequestBody FiltrosDenunciaDTO filtrosDenunciaDTO) {
//        List<DenunciaOutputDto> outputDtoList = denunciaService.getDenunciaComFiltro(filtrosDenunciaDTO);
//        return ResponseEntity.ok().body(outputDtoList);
//    }
}
