package com.backend.sistemadenunciaambiental.domain.service;

import com.backend.sistemadenunciaambiental.repository.DenunciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DenunciaService {

    private final DenunciaRepository denunciaRepository;

}
