package com.backend.sistemadenunciaambiental.api.util;

import org.springframework.stereotype.Service;

@Service
public class FormaterService {

    public String formatarCPF(String cpf) {

        cpf = cpf.replaceAll("[^0-9]", "");
        return cpf;
    }

}
