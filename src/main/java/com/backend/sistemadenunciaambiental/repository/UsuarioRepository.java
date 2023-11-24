package com.backend.sistemadenunciaambiental.repository;

import com.backend.sistemadenunciaambiental.domain.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuario WHERE usuario.cpf = :cpf", nativeQuery = true)
    Optional<Usuario> buscarUsuarioPorCpf(@Param("cpf") String cpf);
}
