# 💳 Desafio Backend PicPay

Este projeto consiste no desenvolvimento de uma API RESTful para uma plataforma de pagamentos simplificada, onde usuários podem cadastrar carteiras, realizar transferências e receber notificações.

O objetivo foi aplicar boas práticas de desenvolvimento backend com Java + Spring Boot, modelagem de dados, comunicação com APIs externas e utilização de containers Docker.

Além disso, encarei este desafio também como uma forma de fortalecer meu aprendizado em Java e evoluir como desenvolvedor backend, praticando conceitos avançados e aplicando boas práticas de mercado.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **Hibernate Validator**
- **Spring Cloud OpenFeign**
- **PostgreSQL** rodando em **Docker**
- **Log4J / SLF4J** para logging
- **Problem Details (RFC 7807)** para tratamento de erros
- **CompletableFuture** para processamento assíncrono

## 📌 Funcionalidades

- ✔ Cadastro de usuários e carteiras (Wallets)
- ✔ Regras de negócio para validação de saldo e tipo de carteira
- ✔ Transferência de valores entre usuários
- ✔ Comunicação com serviço autorizador externo
- ✔ Notificação de recebimento de pagamento (assíncrono)
- ✔ Tratamento de exceções padronizado (Problem Details)
- ✔ Logging estruturado

## 📂 Estrutura do Projeto

```
src
 ├── main
 │   ├── java/tech.othavio.payments
 │   │   ├── entity        -> Entidades JPA (Wallet, WalletType, Transaction)
 │   │   ├── repository    -> Interfaces JPA Repositories
 │   │   ├── service       -> Regras de negócio e integrações externas
 │   │   ├── controller    -> Endpoints REST
 │   │   └── exception     -> Handlers e ProblemDetails
 │   └── resources
 │       ├── application.yml
 │       └── data.sql      -> Carga inicial (WalletType)
 └── test                  -> Testes unitários e de integração
```

## ⚡ Endpoints Principais

### Criar Wallet
```http
POST /wallets
```

### Realizar Transferência
```http
POST /transfer
```

**Exemplo de payload:**
```json
{
  "value": 100.0,
  "payer": 4,
  "payee": 15
}
```

## 🐳 Executando com Docker

1. Subir o postgreSQL via Docker:
```bash
docker-compose up -d
```

2. Rodar a aplicação:
```bash
./mvnw spring-boot:run
```
