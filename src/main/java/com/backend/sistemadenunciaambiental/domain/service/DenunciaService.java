package com.backend.sistemadenunciaambiental.domain.service;

import com.backend.sistemadenunciaambiental.api.dto.inputDto.DenunciaInputDto;
import com.backend.sistemadenunciaambiental.api.dto.inputDto.DenunciaInputPutDto;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.DenunciaInputParecerDTO;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.DenunciaOutputDto;
import com.backend.sistemadenunciaambiental.api.util.ValidationService;
import com.backend.sistemadenunciaambiental.domain.exception.NegocioException;
import com.backend.sistemadenunciaambiental.domain.modelo.Denuncia;
import com.backend.sistemadenunciaambiental.repository.DenunciaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DenunciaService {

    private final DenunciaRepository denunciaRepository;
    private final UsuarioService usuarioService;
    private final ModelMapper mapper;
    private final ValidationService validation;


    public void cadastrarDenuncia(DenunciaInputDto inputDto){
        Denuncia denuncia = mapper.map( inputDto, Denuncia.class);
        if(inputDto.getDescricao().length() > 500){
            throw new NegocioException("A descrição não pode ser maior que 500 caracteres");
        }
        if(inputDto.getDescricao().length() < 50){
            throw new NegocioException("A descrição não pode ser menor que 50 caracteres");
        }
        if(!validation.validarRelacionamentoCategoria(inputDto.getCategoriaPai(), inputDto.getCategoriaFilha())){
            throw new NegocioException("Associação entre Categoria e SubCategoria invalidas!");
        }
        if (inputDto.getUsuarioId() != null){
            denuncia.setUsuario(usuarioService.buscarPorId(inputDto.getUsuarioId()));
            denunciaRepository.save(denuncia);
        }else {
            denuncia.setUsuario(null);
            denunciaRepository.save(denuncia);
        }
        denuncia.setProtocolo(denuncia.getId() + "/" + LocalDate.now().getYear());
        denuncia.setDataCadastro(LocalDate.now());
        denunciaRepository.save(denuncia);
    }

    public Denuncia getById(Long denunciaId){
        Denuncia denuncia = denunciaRepository.findById(denunciaId)
                .orElseThrow(()-> new NegocioException("Denuncia não encontrada para o ID: " + denunciaId));
        return denuncia;
    }

    public List<Denuncia> buscarDenuncias(){
        List<Denuncia> denuncias = denunciaRepository.findAll();
        return denuncias;
    }

    public DenunciaOutputDto buscarDenunciaPorId(Long denunciaId){
        Denuncia denuncia = getById(denunciaId);
        DenunciaOutputDto outputDto = mapper.map(denuncia, DenunciaOutputDto.class);
        if (denuncia.getUsuario() != null){
            outputDto.setUsuarioId(denuncia.getUsuario().getId());
        }
        return outputDto;
    }

    public void alterarDenuncia(Long denunciaId, DenunciaInputPutDto inputPutDto){
        Denuncia denuncia = getById(denunciaId);
        if(!validation.validarRelacionamentoCategoria(inputPutDto.getCategoriaPai(), inputPutDto.getCategoriaFilha())){
            throw new NegocioException("Associação entre Categoria e SubCategoria invalidas!");
        }
        if(inputPutDto.getCategoriaPai() != null){
            denuncia.setCategoriaPai(inputPutDto.getCategoriaPai());
        }
        if(inputPutDto.getCategoriaFilha() != null){
            denuncia.setCategoriaFilha(inputPutDto.getCategoriaFilha());
        }
        if(inputPutDto.getStatus() != null){
            denuncia.setStatus(inputPutDto.getStatus());
        }
            denuncia.setDataAlteracao(LocalDate.now());

            denunciaRepository.save(denuncia);
    }


    public void parecerDenuncia(Long denunciaId, DenunciaInputParecerDTO inputPutDto){
        Denuncia denuncia = getById(denunciaId);
        denuncia.setDataAlteracao(LocalDate.now());
        denuncia.setParecerTecnico(inputPutDto.getParecerTecnico());
        denuncia.setStatus(inputPutDto.getStatus());
        denunciaRepository.save(denuncia);
    }

    public List<DenunciaOutputDto> getDenunciaComFiltro(Integer categoriaPai,
                                                        String protocolo,
                                                        String municipio,
                                                        LocalDate data,
                                                        LocalDate dataCadastro,
                                                        Integer status){
        //tratamento das Strings pois o Java passa elas como "" caso não sejam passadas e o banco espera receber NULL
        if(protocolo == ""){protocolo = null;}
        if(municipio == ""){municipio = null;}

        List<Denuncia> denunciaFiltrada = denunciaRepository.buscarDenunciaComFiltro(categoriaPai, protocolo, municipio,
                                                                                     status);
        //filtro de data no codigo em vez do param
        if (data != null) {
            denunciaFiltrada = denunciaFiltrada.stream()
                    .filter(denuncia -> denuncia.getData().equals(data))
                    .collect(Collectors.toList());
        }
        if (dataCadastro != null) {
            denunciaFiltrada = denunciaFiltrada.stream()
                    .filter(denuncia -> denuncia.getDataCadastro().equals(data))
                    .collect(Collectors.toList());
        }
        //mapeamento da entidade pro DTO
        List<DenunciaOutputDto> outputDtoList = denunciaFiltrada
                .stream()
                .map(denuncia -> mapper.map(denuncia, DenunciaOutputDto.class))
                .collect(Collectors.toList());
        return  outputDtoList;
    }

//    public List<DenunciaOutputDto> getDenunciaComFiltro(CategoriaPaiDenunciaEnum categoriaPai,
//                                                        String protocolo,
//                                                        String municipio,
//                                                        LocalDate data,
//                                                        LocalDate dataCadastro,
//                                                        StatusEnum status){
//        List<Denuncia> denunciaFiltrada = denunciaRepository.buscarDenunciaComFiltro(categoriaPai, protocolo, municipio,
//                                                                                    data,dataCadastro,status);
//        List<DenunciaOutputDto> outputDtoList = List.of(mapper.map(denunciaFiltrada, DenunciaOutputDto.class));
//        return  outputDtoList;
//    }
}
