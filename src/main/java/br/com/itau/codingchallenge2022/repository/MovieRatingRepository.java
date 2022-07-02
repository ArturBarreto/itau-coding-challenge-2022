package br.com.itau.codingchallenge2022.repository;

import br.com.itau.codingchallenge2022.model.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esse {@link Repository} provê todos os recursos de acesso aos dados
 * em uma banco de dados relacional das notas dos filmes dadas pelos usuários
 * no Spring Data JPA em uma interface simples e coesa (API REST).
 * @author ArturBarreto
 */
@Repository
public interface MovieRatingRepository extends JpaRepository<MovieRating, Long> {

}
