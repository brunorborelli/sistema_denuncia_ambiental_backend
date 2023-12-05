package com.backend.sistemadenunciaambiental.domain.service;

import com.backend.sistemadenunciaambiental.api.dto.inputDto.UsuarioInputDto;
import com.backend.sistemadenunciaambiental.api.dto.outputDto.UsuarioOutputDTO;
import com.backend.sistemadenunciaambiental.api.util.CripitografiaUtil;
import com.backend.sistemadenunciaambiental.api.util.FormaterService;
import com.backend.sistemadenunciaambiental.api.util.ValidationService;
import com.backend.sistemadenunciaambiental.domain.exception.NegocioException;
import com.backend.sistemadenunciaambiental.domain.exception.ObjectNotFoundException;
import com.backend.sistemadenunciaambiental.domain.modelo.Usuario;
import com.backend.sistemadenunciaambiental.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final ValidationService validationService;

    private final FormaterService formaterService;

    public Usuario buscarPorId(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado para o ID " + usuarioId));
        return usuario;
    }

    public UsuarioOutputDTO buscarUsuarioPorId(Long usuarioId) {
        Usuario usuario = buscarPorId(usuarioId);
        UsuarioOutputDTO outputDTO = new UsuarioOutputDTO();
        outputDTO.setId(usuario.getId());
        outputDTO.setNome(usuario.getNome());
        outputDTO.setCpf(usuario.getCpf());
        outputDTO.setEmail(usuario.getEmail());
        outputDTO.setDescricao(usuario.getDescricao());
        outputDTO.setTelefone(usuario.getTelefone());
        outputDTO.setDataCadastro(usuario.getDataCadastro());
        outputDTO.setAtivo(usuario.getAtivo());
        return outputDTO;
    }

    public List<Usuario> buscarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        return usuarioRepository.buscarUsuarioPorCpf(cpf)
                .orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado para o CPF " + cpf));
    }

    public List<Usuario> buscarUsuarioPorCpfLista(String cpf){
        List<Usuario> usuarioList = usuarioRepository.buscarUsuarioPorCpfList(cpf);
        return usuarioList;
    }

    public Usuario buscarUsuarioPorToken(String token) {
        return usuarioRepository.buscarUsuarioPorToken(token)
                .orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado para o token " + token));
    }

    // TODO VALIDAÇÃO EMAIL NÃO PODE EXISTIR DOIS EMAILS
    public void cadastrarUsuario(UsuarioInputDto inputDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(inputDTO.getNome());
        validationService.isValidCPF(inputDTO.getCpf());
        String cpf = formaterService.formatarCPF(inputDTO.getCpf());
        cpfJaCadastrado(cpf); //TODO ALTERAR VALIDACAO PARA BOOLEAN
        usuario.setCpf(cpf);
        validationService.isValidEmail(inputDTO.getEmail());
        usuario.setEmail(inputDTO.getEmail());
        usuario.setDescricao(inputDTO.getDescricao());
        usuario.setTelefone(inputDTO.getTelefone());
        String password = CripitografiaUtil.hashSHA512(inputDTO.getPassword());
        String confirmarPassword = CripitografiaUtil.hashSHA512(inputDTO.getConfirmarPassword());
        if (confirmarPassword.equals(password)) {
            usuario.setPassword(password);
            usuarioRepository.save(usuario);
        } else {
            throw new NegocioException("Confirmar senha diferente de Senha");
        }
    }

    public void alterarUsuario(Long usuarioId, UsuarioInputDto inputDTO) {
        Usuario usuario = buscarPorId(usuarioId);
        usuario.setNome(inputDTO.getNome());
        validationService.isValidCPF(inputDTO.getCpf());
        usuario.setCpf(inputDTO.getCpf());
        validationService.isValidEmail(inputDTO.getEmail());
        usuario.setEmail(inputDTO.getEmail());
        usuario.setDescricao(inputDTO.getDescricao());
        usuario.setTelefone(inputDTO.getTelefone());
        String password = CripitografiaUtil.hashSHA512(inputDTO.getPassword());
        String confirmarPassword = CripitografiaUtil.hashSHA512(inputDTO.getConfirmarPassword());
        if (confirmarPassword.equals(password)) {
            usuario.setPassword(password);
            usuarioRepository.save(usuario);
        } else {
            throw new NegocioException("Confirmar senha diferente de Senha");
        }
    }

    private void cpfJaCadastrado(String cpf){
        List<Usuario> usuarioList = buscarUsuarioPorCpfLista(cpf);
        if(!usuarioList.isEmpty()){
            throw new NegocioException("CPF ja cadastrado!");
        }
    }

    @Transactional
    public void updateToken(String token, Usuario usuario) {
        usuarioRepository.updateToken(token, usuario.getId());
    }

}
