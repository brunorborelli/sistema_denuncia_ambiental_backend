package com.backend.sistemadenunciaambiental.domain.modelo;

import com.backend.sistemadenunciaambiental.domain.enums.DescricaoUsuarioEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "descricao", nullable = false)
    private DescricaoUsuarioEnum descricao;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Column(columnDefinition = "TEXT")
    private String token;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Denuncia> denuncias = new ArrayList<>();
}
