package br.com.itau.codingchallenge2022.repository;

import br.com.itau.codingchallenge2022.model.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esse {@link Repository} provê todos os recursos de acesso aos dados
 * em uma banco de dados relacional dos comentários com base no Spring
 * Data JPA em uma interface simples e coesa (API REST).
 * @author ArturBarreto
 */
@Repository
public interface CommentaryRepository extends JpaRepository<Commentary, Long> {

}
