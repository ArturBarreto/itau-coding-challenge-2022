# Itaú Coding Challenge 2022
Bootcamp Itaú {Devs} 2022 by [Let's Code](https://letscode.com.br/processos-seletivos/itau-bootcamp-dev)
## Autor
- Artur Gomes Barreto
	+ [LinkedIn](https://www.linkedin.com/in/arturgomesbarreto/)
	+ [GitHub](https://github.com/ArturBarreto/itau-coding-challenge-2022)
	+ [E-mail](artur.gomes.barreto@gmail.com)
	+ [(85) 99846-4464](https://api.whatsapp.com/send?phone=5585998464464)
## Sistema de críticas de filmes
**Objetivo Geral**: Usistema que tenha a finalidade de receber e armazenar comentários e notas de filmes.  
### Estrutura do Projeto  
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

### Tecnologias / Dependências Utilizadas
As tecnologias/dependências utilizadas neste projeto estão descritas abaixo. Para mais informações, consultar o arquivo *pom.xml*.
| Nome                      | Descrição                          |
|---------------------------|------------------------------------|
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
