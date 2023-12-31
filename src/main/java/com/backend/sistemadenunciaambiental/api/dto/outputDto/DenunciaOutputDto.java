package com.backend.sistemadenunciaambiental.api.dto.outputDto;

import com.backend.sistemadenunciaambiental.domain.enums.CategoriaFilhaDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.enums.CategoriaPaiDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DenunciaOutputDto {

    private String denunciante; //informado(usuario.getNome) ou anonimo(denuncia.setDenunciante("Anônimo")

    private String rua;

    private String bairro;

    private String municipio;

    private String cep;

    private String pontoReferencia;

    private String latitude;

    private String longitude;

    private String descricao;

    private CategoriaPaiDenunciaEnum categoriaPai;

    private CategoriaFilhaDenunciaEnum categoriaFilha;

    private LocalDate data;

    private String provavelAutor;

    private StatusEnum status;

    private String foto1; //base64 do front

    private String foto2; //base64 do front

    private String foto3; //base64 do front

    private Long usuarioId;//vinculo so é feito caso o denunciante não seja anonimo

    private String protocolo;

    private LocalDate dataAlteracao;

    private String parecerTecnico;

}
