package br.com.itau.codingchallenge2022.dto;

import lombok.Data;

/**
 * Essa classe {@link Login} é responsável por representar
 * uma sessão do sistema contento o token gerado.
 * @author ArturBarreto
 */
@Data
public class Session {
    private String login;
    private String token;
}
