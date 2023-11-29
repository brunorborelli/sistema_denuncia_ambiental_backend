package com.backend.sistemadenunciaambiental.domain.modelo;

import com.backend.sistemadenunciaambiental.domain.enums.CategoriaFilhaDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.enums.CategoriaPaiDenunciaEnum;
import com.backend.sistemadenunciaambiental.domain.enums.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "denuncia")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "denunciante", nullable = false) //informado(usuario.getNome) ou anonimo(denuncia.setDenunciante("Anônimo")
    private String denunciante;

    @Column(name = "rua", nullable = false)
    private String rua;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "municipio", nullable = false)
    private String municipio;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "ponto_referencia")
    private String pontoReferencia;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "categoria_pai", nullable = false)
    private CategoriaPaiDenunciaEnum categoriaPai;

    @Column(name = "categoria_filha", nullable = false)
    private CategoriaFilhaDenunciaEnum categoriaFilha;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "provavel_autor")
    private String provavelAutor;

    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "foto1", nullable = false) //base64 do front
    private String foto1;

    @Column(name = "foto2") //base64 do front
    private String foto2;

    @Column(name = "foto3") //base64 do front
    private String foto3;

    @ManyToOne
    @JoinColumn(name = "usuario_id") //vinculo so é feito caso o denunciante não seja anonimo
    private Usuario usuario;


}
