package br.com.itau.codingchallenge2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Objetivo Geral: Um sistema que tenha a finalidade de receber
 * e armazenar comentários e notas de filmes.
 *
 * Objetivos Específicos: Nessa API, um usuário pode se cadastrar,
 * receber e armazenar comentários, registrar reações e notas de um filme.
 * Essa API deve autenticar os usuários e realizar a autorização de login.
 * Além disso, oara que um usuário cadastrado possa realizar as operações
 * no seu sistema, ele deve se autenticar.
 *
 * @author ArturBarreto
 */
@EnableFeignClients
@SpringBootApplication
public class CodingChallenge2022Application {

	public static void main(String[] args) {
		SpringApplication.run(CodingChallenge2022Application.class, args);
	}

}
