package br.com.itau.codingchallenge2022.repository;

import br.com.itau.codingchallenge2022.model.Commentary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaryRepository extends JpaRepository<Commentary, Long> {
}
