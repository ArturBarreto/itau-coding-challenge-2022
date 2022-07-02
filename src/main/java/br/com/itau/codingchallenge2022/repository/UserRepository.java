package br.com.itau.codingchallenge2022.repository;

import br.com.itau.codingchallenge2022.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Esse {@link Repository} provê todos os recursos de acesso aos dados
 * em uma banco de dados relacional das informações dos usuários
 * no Spring Data JPA em uma interface simples e coesa (API REST).
 * @author ArturBarreto
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username= (:username)")
    public User findByUsername(@Param("username") String username);
}