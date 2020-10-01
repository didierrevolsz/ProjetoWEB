# ProjetoWEB
Projeto exercicio 


# ProjetoWEB
Projeto exercicio 

Projeto realizado no NetBeans IDE 12.0;
Ulizando o PostgreSQL como banco;
Dependência:
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>9.4-1200-jdbc41</version>
</dependency>


Data do primeiro Commit: 01/10/2020;
Projeto em construição;
Script inicial do banco:

CREATE TABLE transportadora_tb(
id_transportadora SERIAL PRIMARY KEY,
email_transportadora  VARCHAR(255)    UNIQUE NOT NULL,
nome_transportadora VARCHAR(255) NOT NULL, 
empresa_transportadora VARCHAR(255) NOT NULL,
telefone_transportadora VARCHAR(255) NOT NULL,
celular_transportadora VARCHAR(255) NOT NULL,
whatsapp_transportadora VARCHAR(255) NOT NULL,
modal_transportadora VARCHAR(255) NOT NULL,
cep VARCHAR(255) NOT NULL,
uf varchar(255) NOT NULL, 
cidade VARCHAR(255) NOT NULL, 
bairro VARCHAR(255) NOT NULL,
rua VARCHAR(255) NOT NULL,
numero VARCHAR(255),
logo_transportadora BYTEA 
);
