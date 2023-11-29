package com.backend.sistemadenunciaambiental.domain.service;

import com.backend.sistemadenunciaambiental.api.dto.inputDto.DenunciaInputDto;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.DenunciaOutputDto;
import com.backend.sistemadenunciaambiental.domain.exception.NegocioException;
import com.backend.sistemadenunciaambiental.domain.modelo.Denuncia;
import com.backend.sistemadenunciaambiental.domain.modelo.Usuario;
import com.backend.sistemadenunciaambiental.repository.DenunciaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DenunciaService {

    private final DenunciaRepository denunciaRepository;
    private final UsuarioService usuarioService;
    private final ModelMapper mapper;

    public void cadastrarDenuncia(DenunciaInputDto inputDto){
        Denuncia denuncia = mapper.map( inputDto, Denuncia.class);
        if (inputDto.getUsuarioId() != null){
            denuncia.setUsuario(usuarioService.buscarPorId(inputDto.getUsuarioId()));
            denunciaRepository.save(denuncia);
        }else {
            denuncia.setUsuario(null);
            denunciaRepository.save(denuncia);
        }
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

    public DenunciaOutputDto alterarDenuncia(Long denunciaId, DenunciaInputDto inputDto){  //TODO NÃO FUNCIONA AINDA
        Denuncia denuncia = getById(denunciaId);
        denuncia.setDenunciante(inputDto.getDenunciante());
        denuncia.setRua(inputDto.getRua());
        denuncia.setBairro(inputDto.getBairro());
        denuncia.setMunicipio(inputDto.getMunicipio());
        denuncia.setCep(inputDto.getCep());
        denuncia.setPontoReferencia(inputDto.getPontoReferencia());
        denuncia.setLatitude(inputDto.getLatitude());
        denuncia.setLongitude(inputDto.getLongitude());
        denuncia.setDescricao(inputDto.getDescricao());
        denuncia.setCategoriaPai(inputDto.getCategoriaPai());
        denuncia.setCategoriaFilha(inputDto.getCategoriaFilha());
        denuncia.setData(inputDto.getData());
        denuncia.setProvavelAutor(inputDto.getProvavelAutor());
        denuncia.setFoto1(inputDto.getFoto1());
        denuncia.setFoto2(inputDto.getFoto2());
        denuncia.setFoto3(inputDto.getFoto3());
        if(inputDto.getUsuarioId() != null ){
            Usuario usuario = usuarioService.buscarPorId(inputDto.getUsuarioId());
            denuncia.setUsuario(usuario);
        }
        denunciaRepository.save(denuncia);
        return mapper.map(denuncia, DenunciaOutputDto.class);
    }

}
