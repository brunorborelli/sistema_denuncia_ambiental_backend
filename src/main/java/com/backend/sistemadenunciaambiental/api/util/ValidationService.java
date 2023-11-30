package com.backend.sistemadenunciaambiental.api.util;

import com.backend.sistemadenunciaambiental.domain.enums.CategoriaFilhaDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.enums.CategoriaPaiDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.exception.NegocioException;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidationService {
    public boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new NegocioException("Formato de e-mail invalido");
        }
        return true;
    }

    public boolean isValidCPF(String cpf) {

        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) {
            primeiroDigito = 0;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) {
            segundoDigito = 0;
        }
        if(!(Character.getNumericValue(cpf.charAt(9)) == primeiroDigito &&
                Character.getNumericValue(cpf.charAt(10)) == segundoDigito)){
            throw new NegocioException("Insira um CPF válido");
        }
        return Character.getNumericValue(cpf.charAt(9)) == primeiroDigito &&
                Character.getNumericValue(cpf.charAt(10)) == segundoDigito;
    }

    public static boolean validarRelacionamentoCategoria(CategoriaPaiDenunciaEnum enumPai, CategoriaFilhaDenunciaEnum enumFilho) {
        switch (enumPai) {
            case FAUNA:
                return validarRelacionamentoFauna(enumFilho);
            case FLORA:
                return validarRelacionamentoFlora(enumFilho);
            case POLUICAO:
                return validarRelacionamentoPoluicao(enumFilho);
            case ODENAMENTO_URBANO_E_PATRIMONIO_CULTURAL:
                return validarRelacionamentoOdenamento(enumFilho);
            case ADMINISTRACAO_AMBIENTAL:
                return validarRelacionamentoAdm(enumFilho);

            default:
                return false;
        }
    }

    private static boolean validarRelacionamentoFauna(CategoriaFilhaDenunciaEnum enumFilho) {
        switch (enumFilho) {
            case FAUNA_1:
            case FAUNA_2:
            case FAUNA_3:
            case FAUNA_4:
            case FAUNA_5:
            case FAUNA_6:
                return true;
            default:
                return false;
        }
    }

    private static boolean validarRelacionamentoFlora(CategoriaFilhaDenunciaEnum enumFilho) {
        switch (enumFilho) {
            case FLORA_1:
            case FLORA_2:
            case FLORA_3:
            case FLORA_4:
            case FLORA_5:
                return true;
            default:
                return false;
        }
    }

    private static boolean validarRelacionamentoPoluicao(CategoriaFilhaDenunciaEnum enumFilho) {
        switch (enumFilho) {
            case POLUICAO_1:
            case POLUICAO_2:
            case POLUICAO_3:
            case POLUICAO_4:
            case POLUICAO_5:
            case POLUICAO_6:
                return true;
            default:
                return false;
        }
    }

    private static boolean validarRelacionamentoOdenamento(CategoriaFilhaDenunciaEnum enumFilho) {
        switch (enumFilho) {
            case ODENAMENTO_URBANO_E_PATRIMONIO_CULTURAL_1:
            case ODENAMENTO_URBANO_E_PATRIMONIO_CULTURAL_2:
            case ODENAMENTO_URBANO_E_PATRIMONIO_CULTURAL_3:
                return true;
            default:
                return false;
        }
    }

    private static boolean validarRelacionamentoAdm(CategoriaFilhaDenunciaEnum enumFilho) {
        switch (enumFilho) {
            case ADMINISTRACAO_AMBIENTAL_1:
            case ADMINISTRACAO_AMBIENTAL_2:
                return true;
            default:
                return false;
        }
    }

}
