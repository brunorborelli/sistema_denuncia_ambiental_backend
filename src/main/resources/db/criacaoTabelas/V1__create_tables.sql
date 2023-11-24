CREATE TABLE IF NOT EXISTS public.usuario
(
    id bigint NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),
    ativo boolean NOT NULL,
    cpf character varying(255) COLLATE pg_catalog."default" NOT NULL,
    data_cadastro timestamp(6) without time zone NOT NULL,
    descricao smallint NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default",
    telefone character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_descricao_check CHECK (descricao >= 0 AND descricao <= 1)
)