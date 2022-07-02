package br.com.itau.codingchallenge2022.dto;

import lombok.Data;

/**
 * Essa classe {@link Login} é responsável por receber
 * os dados de username e password para a realização do Login na aplicação.
 * @author ArturBarreto
 */
@Data
public class Login {
    private String username;
    private String password;
}
