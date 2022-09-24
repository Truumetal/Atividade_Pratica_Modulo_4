



CREATE TABLE Empresa (
CNPJ INTEGER PRIMARY KEY,
Nome_Empresarial VARCHAR(10),
Contato VARCHAR(10),
Endereco VARCHAR(10),
Funcionario VARCHAR(10),
ID_Funcionario VARCHAR(10)
);

CREATE TABLE Cliente_Pessoa_Fisica_Pessoa_Juridica (
Contato VARCHAR(10),
Nome_Cliente VARCHAR(10),
Endereco VARCHAR(10),
ID_Cliente VARCHAR(10) PRIMARY KEY,
CPF INTEGER,
CNPJ INTEGER
);

CREATE TABLE Vendedor (
ID_Funcionario VARCHAR(10) PRIMARY KEY,
Nome VARCHAR(10),
Matricula VARCHAR(10)
);

CREATE TABLE Produto (
ID_Produto VARCHAR(10) PRIMARY KEY,
Destino VARCHAR(10),
Promocao VARCHAR(10)
);

CREATE TABLE Faz (
ID_Pedido VARCHAR(10),
ID_Cliente VARCHAR(10),
FOREIGN KEY(ID_Cliente) REFERENCES Cliente_Pessoa_Fisica_Pessoa_Juridica (ID_Cliente)
);

CREATE TABLE Emite (
ID_Pedido VARCHAR(10),
ID_Funcionario VARCHAR(10),
FOREIGN KEY(ID_Funcionario) REFERENCES Vendedor (ID_Funcionario)
);

CREATE TABLE Contem (
ID_Produto VARCHAR(10),
ID_Pedido VARCHAR(10),
FOREIGN KEY(ID_Produto) REFERENCES Produto (ID_Produto)
);

CREATE TABLE Pedido (
ID_Pedido VARCHAR(10) PRIMARY KEY,
Numero_Pedido VARCHAR(10)
);

create table usuario(

id int auto_increment,
nome varchar(50),
email varchar(50),
senha varchar(4),
primary key (id)
);


ALTER TABLE Empresa ADD FOREIGN KEY(ID_Funcionario) REFERENCES Vendedor (ID_Funcionario);
ALTER TABLE Faz ADD FOREIGN KEY(ID_Pedido) REFERENCES Pedido (ID_Pedido);
ALTER TABLE Emite ADD FOREIGN KEY(ID_Pedido) REFERENCES Pedido (ID_Pedido);
ALTER TABLE Contem ADD FOREIGN KEY(ID_Pedido) REFERENCES Pedido (ID_Pedido);


select*from empresa;




