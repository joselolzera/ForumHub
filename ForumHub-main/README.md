# ForumHub - Challenge ONE (Back End)

## Descrição
API REST desenvolvida com Spring Boot para gerenciamento de tópicos, incluindo autenticação de usuários com JWT.

## Tecnologias
- Java 17
- Spring Boot (Security, JPA)
- MySQL
- Lombok

## Funcionalidades
- Registro e autenticação de usuários.
- CRUD de tópicos.
- Validação de dados.
- Autenticação JWT.

## Como Executar
1. Clone o repositório:
   ```
   git clone https://github.com/thalyaalves98/ForumHub.git
   cd ForumHub
Configure o banco de dados no arquivo src/main/resources/application.properties.

## Endpoints
- POST /login: Autenticação de usuários e geração de token JWT.
- POST /topicos: Criação de novos tópicos.
- GET /topicos: Listagem de tópicos.
- GET /topicos/{id}: Detalhes de um tópico específico.
- PUT /topicos/{id}: Atualização de um tópico existente.
- DELETE /topicos/{id}: Exclusão de um tópico.
