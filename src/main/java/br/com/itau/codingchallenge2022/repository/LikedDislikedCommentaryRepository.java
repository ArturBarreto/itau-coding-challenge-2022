package br.com.itau.codingchallenge2022.repository;

import br.com.itau.codingchallenge2022.model.LikedDislikedCommentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esse {@link Repository} provê todos os recursos de acesso aos dados
 * em uma banco de dados relacional dos comentários marcados como "gostei"
 * ou "não gostei" com base no Spring Data JPA em uma interface simples e
 * coesa (API REST).
 * @author ArturBarreto
 */
@Repository
public interface LikedDislikedCommentaryRepository extends JpaRepository<LikedDislikedCommentary, Long> {

}
