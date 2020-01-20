CREATE TABLE usuario
(
    id uuid NOT NULL,
    id_auth bit varying(100) NOT NULL,
    email bit varying(50) NOT NULL,
    nome bit varying(100) NOT NULL,
    ativo boolean NOT NULL,
    dt_cadastro date NOT NULL,
    CONSTRAINT id_usuario PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE usuario
    OWNER to postgres;