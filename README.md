# Projeto spring boot e JPA/Hibernate

## Objetivo

Este é um projeto de estudo para back-end desenvolvido em Java com Spring Boot, utilizando Maven para gerenciamento de dependências, Postman para testes de API, banco de dados H2 para desenvolvimento e PostgreSQL para produção.
O sistema baseia-se em um usuário que possui uma lista de Pedidos, onde cada Pedido contém os Produtos, com suas informações e cada Pedido tem seu pagamento único.

## Tecnologias

![Logo Java](./src/assets/logo-java.svg) ![Logo Spring Boot](./src/assets/logo-spring-boot.svg) ![Logo Maven](./src/assets/logo-maven.svg) ![Logo Postman](./src/assets/logo-postman.svg) ![Logo PostgreSQL](./src/assets/logo-postgresql.svg) ![Logo H2](./src/assets/logo-h2.png)

## Arquitetura

O sistema foi desenvolvido seguindo a arquitetura MVC, com as seguintes camadas:

- **Entity**: Classes das entidades do sistemas (User, Pedido,Produto, Pagamento, etc.).
- **Controller**: Classes que recebem as requisições HTTP e interagem com as entidades do sistema para processar os dados.
- **Service**: Classes que contêm a lógica de negócios do sistema.
- **Repository**: Classes que fazem o acesso ao banco de dados.

### Modelo de domínio

```mermaid
classDiagram

    direction LR

    User "1" -- "*" Order
    Order "1"-- "0..1"Payment
    Order "*" -- "1..*" Product
    Product "*" -- "1..*" Category
    OrderItem .. Order
    OrderItem .. Product

    class User {
        - <<<pk>pk>> Integer id
        - String name
        - String email
        - String phone
        - String password
    }
    class Order {
        - <<<pk>pk>> Integer id
        - Instant moment
        - OrderStatus orderStatus
        + total() double
    }
    class OrderItem {
        - Integer quantity
        - Double price
        + subTotal() double
    }
    class Product {
        - <<<pk>pk>> Integer id
        - String name
        - String description
        - Double price
        - String imgUrl
    }
    class Payment {
        - <<<pk>pk>> Integer id
        - Instant moment
    }
    class Category {
        - <<<pk>pk>> Integer id
        - String name
    }
    class OrderStatus {
        <<enum>>
        - int WAITING_PAYMENT
        - int PAID
        - int SHIPPED
        - int DELIVERED
        - INT CANCELED
    }
```

### Instância de domínio

Essa instância de domínio foi carregada no perfil de testes no banco de dados H2.

```mermaid
classDiagram

    direction LR

    Category1 -- Product2
    Category2 -- Product1
    Category2 -- Product5
    Category3 -- Product2
    Category3 -- Product3
    Category3 -- Product4

    OrderItem1 -- Product1
    OrderItem2 -- Product3
    OrderItem3 -- Product3
    OrderItem4 -- Product5

    OrderItem1 -- Order1
    OrderItem2 -- Order1
    OrderItem3 -- Order2
    OrderItem4 -- Order3

    Order1 -- Payment1
    Order1 -- User1
    Order2 -- User2
    Order3 -- User1


    class Category1 {
        id = 1
        name = Eletronics
    }
    class Category2 {
        id = 1
        name = Books
    }
    class Category3 {
        id = 1
        name = Computers
    }
    class Product1 {
        id = 1
        name = The Lord of the Rings
        description = lorem
        price = 90.5
        imgUrl = ""
    }
    class Product2 {
        id = 1
        name = The Lord of the Rings
        description = lorem
        price = 90.5
        imgUrl = ""
    }
    class Product3 {
        id = 1
        name = The Lord of the Rings
        description = lorem
        price = 90.5
        imgUrl = ""
    }
    class Product4 {
        id = 1
        name = The Lord of the Rings
        description = lorem
        price = 90.5
        imgUrl = ""
    }
    class Product5 {
        id = 1
        name = The Lord of the Rings
        description = lorem
        price = 90.5
        imgUrl = ""
    }
    class OrderItem1 {
        quantity = 2
        price = 90.5
    }
    class OrderItem2 {
        quantity = 2
        price = 1250.0
    }
    class OrderItem3 {
        quantity = 2
        price = 1250.0
    }
    class OrderItem4 {
        quantity = 2
        price = 100.99
    }
    class Order1 {
        id = 1
        moment = 2025-01-20T19:53:07Z
        orderStatus = PAID
    }
    class Order2 {
        id = 1
        moment = 2025-01-21T15:23:17Z
        orderStatus = PAID
    }
    class Order3 {
        id = 1
        moment = 2025-02-02T11:20:06Z
        orderStatus = PAID
    }
    class Payment1 {
        id = 1
        moment = 2025-01-20T21:53:07Z
    }
    class User1 {
        id = 1
        name = Maria
        email = maria@email.com
        phone = 988007766
        password = 1234
    }
    class User2 {
        id = 2
        name = Alex
        email = alex@email.com
        phone = 988005544
        password = 1234
    }
```

## Execução do projeto

1. Clone o repositório:

    ```git
    git clone https://github.com/viniciussartini/springjpa.git
    ```

2. Abra no seu editor de preferência: IntelliJ IDEA, Eclipse, SpringTool Suite, VS Code

3. Configure o banco de dados

    - Para usar o H2 ou PostgreSQL, ative o profile `test` ou `dev`, respectivamente. Abra o arquivo [Application Properties](./src/main/resources/application.properties):

    ```java
    spring.profiles.active=test/dev
    ```

4. Para executar o projeto rode o arquivo [SpringjpaApplication.java](./src/main/java/br/com/example/springjpa/SpringjpaApplication.java)

## Teste da API

1. Abra o Postman.
2. Envie as requisições para os endpoints da API.
    **Endpoints da API**
    **Usuários:**
    `GET /users` Lista todos os usuários.
    `GET /users/{id}` Lista o usuário pelo id informado.
    `POST /users`: Cadastra um novo usuário.
    `PUT /users/{id}`: Atualiza as informações do usuário com id informado.
    `DELETE /users/{id}`: Deleta usuário através do id informado.
    **Produtos:**
    `GET /products` Lista todos os produtos.
    `GET /products/{id}` Lista o produto pelo id informado.
    **Categorias:**
    `GET /categories` Lista todas as categorias de produto.
    `GET /categories/{id}` Lista a categoria de produto pelo id informado.
    **Pedidos:**
    `GET /orders` Lista todos os pedidos.
    `GET /orders/{id}` Lista o pedido pelo id informado.

## Próximos Passos

1. Implementar os métodos `POST`, `PUT` e `DELETE` de produtos, categorias e pedidos.
