package com.backend.sistemadenunciaambiental.repository;

import com.backend.sistemadenunciaambiental.domain.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuario u WHERE u.cpf = :cpf", nativeQuery = true)
    Optional<Usuario> buscarUsuarioPorCpf(@Param("cpf") String cpf);

    @Query(value = "SELECT * FROM usuario u WHERE u.token = :token", nativeQuery = true)
    Optional<Usuario> buscarUsuarioPorToken(@Param("token") String token);

    @Modifying
    @Query(value = "UPDATE usuario SET token = :token WHERE id = :id ", nativeQuery = true)
    void updateToken(@Param("token") String token, @Param("id") Long id);
}
