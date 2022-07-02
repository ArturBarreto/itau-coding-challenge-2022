package br.com.itau.codingchallenge2022.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Essa classe {@link User} é responsável por representar um usuário.
 * Um usuário possui os seguintes campos:
 *      idUser: Identificador do usuário;
 *      name: Nome completo do usuário;
 *      username: Username do usuário (valor único);
 *      password: A senha do usuário;
 *      roles: Lista contendo todos os perfis do usuário;
 *      points: Número de pontos do usuário;
 * @author ArturBarreto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 20, nullable = false, unique = true)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_id")
    private List<String> roles = new ArrayList<>();

    private Integer points = 0;
}