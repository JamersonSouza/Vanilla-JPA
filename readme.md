# Introdução
Este é um projeto simples demonstrando o uso básico do Java Persistence API (JPA) com o Hibernate EntityManager e o banco de dados H2. O projeto consiste em mapeamento de entidades simples para produtos e lojas, além da implementação de operações básicas de persistência usando EntityManager e EntityManagerFactory.

# Detalhes do Projeto
Configuração: O arquivo persistence.xml é utilizado para configurar a unidade de persistência, definindo o provedor JPA (Hibernate) e as propriedades de conexão com o banco de dados H2.

Entidades: Foram implementadas duas entidades simples: Produto e Loja, com os respectivos atributos e relacionamentos.

Persistência: A persistência é realizada através do uso de EntityManager e EntityManagerFactory. Foram implementados métodos básicos de CRUD para as entidades Produto e Loja.

Consultas JPQL: Implementação de consultas JPQL para buscar todos os produtos, busca por preço do produto, pelo nome da loja, por nome de um determinado produto.

DAOs: Foram criados os DAOs (ProdutoDAO) para encapsular as operações de acesso ao banco de dados e interação com as entidades.

# Configuração
Para rodar este projeto, é necessário ter o Java JDK instalado versão 17. As dependências do Hibernate e do H2 são gerenciadas pelo Maven.

## Clone o repositório:
> https://github.com/JamersonSouza/Vanilla-JPA.git

## Navegue até o diretório do projeto:
> cd Vanilla-JPA

## Compile o projeto:
> mvn clean install

## Execute a aplicação
> acesse a classe CadastroProdutos.java no package tech.jamersondev.loja.tests. Clique com o botão direito, opção Run As "Java Application".
