package com.backend.sistemadenunciaambiental.repository;

import com.backend.sistemadenunciaambiental.domain.modelo.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long> {

}
