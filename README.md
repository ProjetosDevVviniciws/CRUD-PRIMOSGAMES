## Projeto PrimosLocadora - Documentação Oficial

**Introdução**

O projeto PrimosLocadora, consiste em um programa simples e objetivo.Utilizando Java e MySQL.Com o intuíto de gerenciar a parte dos clientes, games e preços.

**Funcionalidades**

* **Cadastro de Clientes:** Permite adicionar Clientes com informações como nome, e-mail e CPF.
* **Gerenciamento de Games:** Facilita na hora de alugar e até mesmo na hora da exclusão do game, de acordo com sua categoria.
* **Gerenciamento de Preços:** Permite a definição e atualização dos preços de locação por categoria dos games.
* **Interface Intuitiva:** Prioriza uma usabilidade totalmente obejtiva e fácil.

**Tecnologias Utilizadas**

* **Visual Studio Code:** Como editor de código.
* **MySQL:** Para gerenciamento do banco de dados.
* **Maven:** Como ferramenta de automação de build e gerenciamento de dependências.

**Diferenciais do Projeto**

* **Abordagem Orientada a Objetos:** A adoção do paradigma OOP possibilita um código mais organizado, reutilizável e fácil de manter, além de promover a extensibilidade do sistema.
* **Foco na Usabilidade:** A interface simples e objetiva, na qual facilitam a navegação e o acesso às funcionalidades do sistema.
* **Versatilidade:** A plataforma permite adicionar e o gerenciar diversos games, de acordo com sua categoria e preço.Assim satisfazendo os clientes.
* **Potencial de Expansão:** Com atualizações futuras é possível a implementação de novas funcionalidades, como bancos de dados e interfaces gráficas.

**Estrutura do Banco de Dados**

### Criação do Banco de Dados e Tabelas

-- Criação do Banco de Dados
create database locadoragames;
use locadoragames;

-- Criação da parte dos Clientes
create table Clientes (
id int auto_increment primary key,
nome varchar(155) not null,
email varchar(30) not null,
cpf varchar(14) not null
);

-- Criação da parte dos Precos
create table Precos (
id int auto_increment primary key,
categoria enum ('Terror', 'FPS', 'Multijogador', 'Esportes', 'Transportes', 'Sobrevivencia') not null unique,
preco_por_dia decimal(10, 2) not null
);

-- Criação da parte dos Games
create table Games (
id int auto_increment primary key,
nome varchar(155) not null,
categoria enum ('Terror', 'FPS', 'Multijogador', 'Esportes', 'Transportes', 'Sobrevivencia') not null unique,
ano_de_lancamento int not null,
disponivel tinyint(1) not null,
url_game varchar(255),
preco_por_dia decimal(10, 2) not null
);

-- Inserir dados dos Preços
insert into Precos (categoria, preco_por_dia) values
('Terror', 5.60),
('FPS', 15.60),
('Multijogador', 8.60),
('Esportes', 16.00),
('Transportes', 12.40),
('Sobrevivencia', 7.60);

-- Inserir dados dos Games
insert into Games (nome, categoria, ano_de_lancamento, disponivel, url_game, preco_por_dia) values
('Phasmophobia', 'Terror', '2020', '1', 'url1', '5.60'),
('Counter-Strike 2', 'FPS', '2012', '1', 'url2', '15.60'),
('Fall Guys', 'Multijogador', '2020', '1', 'url3', '8.60'),
('Golf With Your Friends', 'Esportes', '2012', '1', 'url4', '16.00'),
('Euro Truck Simulator 2', 'Transportes', '2012', '1', 'url5', '12.40'),
('The Forest', 'Sobrevivencia', '2018', '1', 'url6', '7.60');

-- Inserir dados dos Clientes 
insert into Clientes(nome, email, cpf) values
('Vinicius Pinto Gonçalves', 'vinciuspinto@gmail.com', '54379087600'),
('Luigi Henry', 'luigihenry@gmail.com', '24586329056'),
('Gabriel Santos', 'gabrielsantos@gmail.com', '10226975301'),
('Alice Carneiro', 'alicecarneiro@gmail.com', '64289080677'),
('Yago Mendes', 'yagomendes@gmail.com', '56179526000'),
('Carlos Sumare', 'carlossumare@gmail.com', '76587864055'),
('Rafael Proença', 'rafaelproenca@gmail.com', '12348080899'),
('Humberto Freitas', 'humbertofreitas@gmail.com', '77564906899'),
('Gabriel Messias', 'gabrielmessias@gmail.com', '35784684560');

