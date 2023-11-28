package com.backend.sistemadenunciaambiental.api.dto.inputDto;

import com.backend.sistemadenunciaambiental.domain.enums.CategoriaFilhaDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.enums.CategoriaPaiDenunciaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DenunciaInputDto {

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

    private String foto1; //base64 do front

    private String foto2; //base64 do front

    private String foto3; //base64 do front

    private Long usuarioId;//vinculo so é feito caso o denunciante não seja anonimo
}
