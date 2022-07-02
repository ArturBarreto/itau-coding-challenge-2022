package br.com.itau.codingchallenge2022.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esse {@link RestController} é responsável por dar as boas-
 * vindas aos usuários, dando informações iniciais de como usar
 * o sistema.
 * @author ArturBarreto
 */
@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Bem-vindo(a) ao Sistema de Críticas de Filmes!\n\n" +
                "Para ter acesso as funcionalidades do seu perfil, é necessário fazer login.\n" +
                "Para isso, acesse http://localhost:8080/login\n\n" +
                "É novo por aqui? Registre-se!\n" +
                "Para isso, acesse http://localhost:8080/register\n\n" +
                "Desenvolvido por:\n" +
                "Artur Gomes Barreto\n" +
                "https://github.com/ArturBarreto/itau-coding-challenge-2022";
    }
}