package com.backend.sistemadenunciaambiental.repository;

import com.backend.sistemadenunciaambiental.domain.modelo.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    @Query(value = "select * from denuncia d " +
            "where (:categoriaPai  isnull or d.categoria_pai = :categoriaPai ) " +
            "and (:protocolo isnull or d.protocolo = :protocolo or d.protocolo = '') " +
            "and (:municipio isnull or d.municipio = :municipio or d.municipio = '') " +
            "and (:status isnull or d.status = :status) ", nativeQuery = true)
    List<Denuncia> buscarDenunciaComFiltro(@Param("categoriaPai") Integer categoriaPai,
                                           @Param("protocolo") String protocolo,
                                           @Param("municipio") String municipio,
                                           @Param("status")Integer status);

}
