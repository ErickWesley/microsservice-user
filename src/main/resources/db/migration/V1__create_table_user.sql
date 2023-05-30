CREATE TABLE usuario (
    id serial PRIMARY KEY,
    nome varchar(50),
    sobrenome varchar(100),
    cpf varchar(15),
    email varchar(100),
    senha varchar(100),
    data_de_nascimento date,
    genero char(1),
    telefone varchar(20),
    foto_de_perfil varchar(255),
    endereco varchar(255)
);
