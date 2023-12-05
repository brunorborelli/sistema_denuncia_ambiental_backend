CREATE TABLE public.usuario (
id bigserial NOT NULL,
ativo bool NOT NULL,
cpf varchar(255) NOT NULL,
data_cadastro timestamp(6) NOT NULL,
descricao int2 NOT NULL,
email varchar(255) NOT NULL,
nome varchar(255) NOT NULL,
"password" varchar(255) NULL,
telefone varchar(255) NOT NULL,
"token" text NULL,
CONSTRAINT usuario_descricao_check CHECK (((descricao >= 0) AND (descricao <= 1))),
CONSTRAINT usuario_pkey PRIMARY KEY (id)
);


CREATE TABLE public.denuncia (
 id bigserial NOT NULL,
 bairro varchar(255) NOT NULL,
 categoria_filha int2 NOT NULL,
 categoria_pai int2 NOT NULL,
 cep varchar(255) NOT NULL,
 "data" date NOT NULL,
 data_alteracao date NULL,
 data_cadastro date NULL,
 denunciante varchar(255) NOT NULL,
 descricao varchar(500) NOT NULL,
 foto1 varchar(5000000) NOT NULL,
 foto2 varchar(5000000) NULL,
 foto3 varchar(5000000) NULL,
 latitude varchar(255) NULL,
 longitude varchar(255) NULL,
 municipio varchar(255) NOT NULL,
 parecer_tecnico varchar(1000) NULL,
 ponto_referencia varchar(255) NULL,
 protocolo varchar(255) NULL,
 provavel_autor varchar(255) NULL,
 rua varchar(255) NOT NULL,
 status int2 NULL,
 usuario_id int8 NULL,
 CONSTRAINT denuncia_categoria_filha_check CHECK (((categoria_filha >= 0) AND (categoria_filha <= 22))),
 CONSTRAINT denuncia_categoria_pai_check CHECK (((categoria_pai >= 0) AND (categoria_pai <= 4))),
 CONSTRAINT denuncia_pkey PRIMARY KEY (id),
 CONSTRAINT denuncia_status_check CHECK (((status >= 0) AND (status <= 2))),
 CONSTRAINT fktjlwue48v7ycj9cu55luadafn FOREIGN KEY (usuario_id) REFERENCES public.usuario(id)
);

