# Itaú Coding Challenge 2022
Bootcamp Itaú {Devs} 2022 by [Let's Code](https://letscode.com.br/processos-seletivos/itau-bootcamp-dev)
## Autor
- Artur Gomes Barreto
	+ [LinkedIn](https://www.linkedin.com/in/arturgomesbarreto/)
	+ [GitHub](https://github.com/ArturBarreto/itau-coding-challenge-2022)
	+ [E-mail](artur.gomes.barreto@gmail.com)
	+ [(85) 99846-4464](https://api.whatsapp.com/send?phone=5585998464464)
## Sistema de críticas de filmes
**Objetivo Geral**: Um sistema que tenha a finalidade de receber e armazenar comentários e notas de filmes.  
## Estrutura do Projeto  
Em consonância aos princípios do SOLID, adotou-se um padrão de projeto MVC com o objetivo de melhorar a conexão entre as camadas de dados, lógica de negócio e interação com usuário. Além disso, essa abordagem facilita o entendimento e manutenção do código.

Os principais arquivos do projeto estão distribuídos na seguinte hierarquia de pacotes, cada uma representando uma camada da aplicação.

| Nome       | Descrição |
|------------|-----------	|
| controller | Responsáveis por receber todas as requisições do usuário e contém os recursos https expostos na API                     |
| dto        | Tráfego de dados da aplicação                                                                                           |
| init       | Possui o *StartApplication* que popula o banco de dados com valores iniciais para facilitar os testes                   |
| model      | Possui as entidades do projeto                                                                                          |
| repository | Recursos de acesso aos dados em uma banco de dados relacional  com base no Spring Data JPA                              |
| security   | Possui a implementação do *JSON Web Tokken* (JWT) e configuração de permissão de acesso as funcionalidades da aplicação |
| service    | Regras de negócio e comunicação com a base de dados via *repositorys*                                                   |

## Tecnologias / Dependências Utilizadas
As tecnologias/dependências utilizadas neste projeto estão descritas abaixo. Para mais informações, consultar o arquivo *pom.xml*.
| Nome                      | Descrição                          |
|---------------------------|------------------------------------|
| Postman                   | API Client utilizada               | 
| Java 8                    | Linguagem base                     | 
| Maven                     | Gestão de dependências             |
| Spring Boot Data JPA      | Gerenciamento com o banco de Dados |
| Spring Boot Security      | Autenticação e controle de acessos | 
| Spring Boot Security Test | Testes de segurança                |
| Spring Boot Web           | Fornece todas as dependências e configurações automáticas necessária para desenvolver aplicações Web|
| Spring Boot Test          | Testes automatizados               |
| JSON Web Tokken           | Suporte a criação de Tokens, conforme requisitos do projeto |
| OpenFeign                 | Cliente REST declarativo para integrar duas APIs. Utilizado para consumir o API do OMDB  |
| PostgreSQL                | Sistema gerenciador de banco de dados objeto relacional |
| Lombok                    | Visa a diminuição de código boilerplate e maior produtividade |
| Jackson Core              | Streaming API. Utilizado para consumir o API do OMDB |

## Configuração do banco de dados (PostgreSQL)
É necessário que o PostgresSQL esteja instalado no sistema e um banco de dados criado. Com essas premissas satisfeitas, deve-ve atualizar o arquivo **application.properties** com as informações do nome do banco de dados criado, bem como o usuáio e senha do Postgre. O trecho de código que deve ser alterado pode ser visto abaixo:
```
# Postgres
database.name = moviecritics
spring.datasource.username=postgres
spring.datasource.password=root
```

## Funcionalidades
Nessa seção, apresentaremos as funcionalidades implementadas no sistema.
## Gerais
### **1.Tela de boas vindas e instruções iniciais**
```
GET: http://localhost:8080
```
*Aparecerá a seguinte resposta do sistema*
```
Bem-vindo(a) ao Sistema de Críticas de Filmes!

Para ter acesso as funcionalidades do seu perfil, é necessário fazer login.
Para isso, acesse http://localhost:8080/login

É novo por aqui? Registre-se!
Para isso, acesse http://localhost:8080/register

Desenvolvido por:
Artur Gomes Barreto
https://github.com/ArturBarreto/itau-coding-challenge-2022
```
```
Autorizados: Todos
```
### **2.Instruções para realizar registro**
```
GET: http://localhost:8080/register
```
*Aparecerá a seguinte resposta do sistema*
```
Para registrar-se, forneça um JSON com a seguinte estrutura:
{
    "name": "SEU NOME",
    "username": "SEU_USER_NAME",
    "password": "SUA_SENHA"
}
```
```
Autorizados: Todos
```
### **3.Realizar registro**
```
POST: http://localhost:8080/register
```
*Para se registrar, forneça um JSON com a seguinte estrutura:*
```
{
    "name": "SEU NOME",
    "username": "SEU_USER_NAME",
    "password": "SUA_SENHA"
}
```
```
Autorizados: Todos
```
### **4.Instruções para Login**
```
GET: http://localhost:8080/login
```
*Aparecerá a seguinte resposta do sistema:*
```
Para fazer login, forneça um JSON com a seguinte estrutura:
{
    "username": "SEU_USER_NAME",
    "password": "SUA_SENHA"
}
```
```
Autorizados: Todos
```
### **5.Executar o Login**
```
POST: http://localhost:8080/login
```
*Para fazer login, forneça um JSON com a seguinte estrutura:*
```
{
    "username": "SEU_USER_NAME",
    "password": "SUA_SENHA"
}
```
*Caso você insira um login e senha válidos, receberá a seguinte resposta*
```
{
    "login": "leitor1",
    "token": "bearer eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE2NTY2OTQ1ODUsImV4cCI6MTY1NjY5ODE4NSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9MRUlUT1IiXX0.SvuCJFGft9nqhooe6Bu3N1HivFrWp0qunWeEsP8sare-VQrV-Pgehm0fqmRJPjh3EU5i_XRqrYDVXk2KTFYU1A"
}
```
*Esse token deve ser informado, sem aspas, nas demais requisições para validar suas autorizações de acesso para permitir, ou não, a execução das funcionalidades. Para isso, fornecer no Header da requisição uma Key chamada Authorization com esse Token gerado no login!*
```
Autorizados: Todos
```
## Informações de Filmes
### **6.Consultar as informações de um filme**
```
GET: http://localhost:8080/movie/NOME DO FILME EM INGLES AQUI
```
*A busca pelo filme na nossa API é feita consultando a OMDb API (https://www.omdbapi.com/)*.
*Os títulos dos filmes deve ser em inglês.*
```
Autorizados: Leitor, Básico, Avançado e Moderador
```
## Comentários
### **7.Pesquisar todos os comentários de todos os filmes**
```
GET: http://localhost:8080/commentary
```
*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Leitor, Básico, Avançado e Moderador
```
### **8.Pesquisar todas os comentários de um filme específico por imdbId**
```
GET: http://localhost:8080/commentary/movie/imdbId
```
*Troque imdbId pelo respectivo id do filme no IMDB. Por exemplo, o imdbId do "The Matrix" é tt0133093*
*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Leitor, Básico, Avançado e Moderador
```
### **9.Pesquisar todas os comentários postados por um usuário específico pelo seu username**
```
GET: http://localhost:8080/commentary/user/username
```
*Troque username pelo respectivo username do usuário. Por exemplo, o username do "Leitor 1" é leitor1*

*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Leitor, Básico, Avançado e Moderador
```
### **10.Postar um comentário de um filme**
```
POST: http://localhost:8080/commentary
```
*Para postar um comentário de um filme, forneça um JSON com a seguinte estrutura:*
```
{
    "idImdb": "tt0133093",
    "username": "basico1",
    "commentary": "Na primeira vez que assisti, não entendi nada!"
}
```
*No exemplo acima, o usuário Básico 1 está postando um comentário para o filme The Matrix*

*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Básico, Avançado e Moderador
```
### **11.Postar uma resposta a um comentário pelo commentaryId**
```
POST: http://localhost:8080/commentary/responseto/commentaryId
```
*Troque commentaryId pelo respectivo ID do comentário o qual se deseja responder.*
*Para postar uma resposta a um comentário, forneça um JSON com a seguinte estrutura:*
```
{
    "idImdb": "tt0133093",
    "username": "basico2",
    "commentary": "The Matrix é complicado mesmo. Filosofia pura."
}
```
*No exemplo acima, o usuário Básico 2 está respondendo a um comentário para o filme The Matrix*

*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Básico, Avançado e Moderador
```
### **12.Citar um comentário pelo commentaryId**
```
POST: http://localhost:8080/commentary/quotingcommentary/commentaryId
```
*Troque commentaryId pelo respectivo ID do comentário o qual se deseja citar.*

*Para citar um comentário, forneça um JSON com a seguinte estrutura:*
```
{
    "idImdb": "tt0133093",
    "username": "basico3",
    "commentary": "Como o Básico 2 disse, The Matrix é filosofia pura!"
}
```
*No exemplo acima, o usuário Básico 3 está citando um comentário feito pelo Básico 2 para o filme The Matrix. Considerando que esse é o comentário de ID 2, o path para esse exemplo é http://localhost:8080/commentary/quotingcommentary/2*

*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Avançado e Moderador
```
### **13.Marcar um comentário como "Gostei" ou "Não Gostei" pelo commentaryId**
```
POST: http://localhost:8080/commentary/likedislike/commentaryId
```
*Troque commentaryId pelo respectivo ID do comentário o qual se deseja gostar ou não gostar.*

*Para gostar de um comentário, forneça um JSON com a seguinte estrutura:*
```
{
    "username": "USER_NAME",
    "status": "like"
}
```
*Para não gostar de um comentário, forneça um JSON com a seguinte estrutura:*
```
{
    "username": "USER_NAME",
    "status": "dislike"
}
```
*Troque USER_NAME pelo username do usuário que está gostando ou não gostando de um comentário.*

*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Avançado e Moderador
```
### **14.Deletar um comentário pelo commentaryId**
```
DELETE: http://localhost:8080/commentary/commentaryId
```
*Troque commentaryId pelo respectivo ID do comentário o qual se deseja deletar.*
```
Autorizados: Moderador
```
### **15.Marcar um comentário como repetido pelo commentaryId**
```
POST: http://localhost:8080/commentary/repeated/commentaryId
```
*Troque commentaryId pelo respectivo ID do comentário o qual se deseja marcar como repetido.*
```
Autorizados: Moderador
```
### **16.Obter uma lista de todos os comentários gostei e não gostei de todos os usuários**
```
GET: http://localhost:8080/commentary/likedislike
```
*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Moderador
```
## Notas de Filmes
### **17.Pesquisar todos as notas postadas de todos os filmes**
```
GET: http://localhost:8080/rating
```
*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Leitor, Básico, Avançado e Moderador
```
### **18.Pesquisar todos as notas postadas de um filme pelo imdbId**
```
GET: http://localhost:8080/rating/movie/imdbId
```
*Troque imdbId pelo respectivo id do filme no IMDB. Por exemplo, o imdbId do "The Matrix" é tt0133093*

*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Leitor, Básico, Avançado e Moderador
```
### **19.Pesquisar todas as notas postadas por um usuário específico pelo seu username**
```
GET: http://localhost:8080/rating/user/username
```
*Troque username pelo respectivo username do usuário. Por exemplo, o username do "Leitor 1" é leitor1*

*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Leitor, Básico, Avançado e Moderador
```
### **20.Postar uma nota de um filme**
```
POST: http://localhost:8080/rating
```
*Para postar uma nota de um filme, forneça um JSON com a seguinte estrutura:*
```
{
    "idImdb": "tt0133093",
    "username": "leitor",
    "movieRating": 9
}
```
*No exemplo acima, o usuário Leitor 1 está postando uma nota 9 para o filme The Matrix*

*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Leitor, Básico, Avançado e Moderador
```
## Moderadores
### **21.Obter uma lista de todos os usuários cadastrados**
```
GET: http://localhost:8080/admin/users
```
*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Moderador
```
### **22.Transformar um usuário em um moderador**
```
POST: http://localhost:8080/admin/makeusermoderator/userId
```
*Troque userId pelo respectivo ID do usuário o qual se deseja transformar em moderador.*

*Lembre-se de fornecer no Header da requisição uma Key chamada Authorization com o Token gerado no login!*
```
Autorizados: Moderador
```