package com.backend.sistemadenunciaambiental.repository;

import com.backend.sistemadenunciaambiental.domain.enums.CategoriaPaiDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.enums.StatusEnum;
import com.backend.sistemadenunciaambiental.domain.modelo.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

    @Query(value = "select * from denuncia d " +
            "where (:categoriaPai  isnull or d.categoria_pai = :categoriaPai ) " +
            "and (:protocolo isnull or d.protocolo = :protocolo) " +
            "and (:municipio isnull or d.municipio = :municipio) " +
            "and (:data isnull or d.data = :data) " +
            "and (:dataCadastro isnull or d.data_cadastro = :dataCadastro) " +
            "and (:status isnull or d.status = :status) ", nativeQuery = true)
    List<Denuncia> buscarDenunciaComFiltro(@Param("categoriaPai") CategoriaPaiDenunciaEnum categoriaPai,
                                           @Param("protocolo") String protocolo,
                                           @Param("municipio") String municipio,
                                           @Param("data") LocalDate data,
                                           @Param("dataCadastro") LocalDate dataCadastro,
                                           @Param("status")StatusEnum status);

}
