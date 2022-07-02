package br.com.itau.codingchallenge2022.model;

import lombok.Data;
import javax.persistence.*;

/**
 * Essa classe {@link MovieRating} é responsável por representar uma nota dada a um filme.
 * Uma nota possui os seguintes campos:
 *      idMovieRating: Identificador da nota;
 *      idImdb: Identificador do filme ao qual o comentário se refere;
 *      username: Username do usuário que fez o comentário;
 *      movieRating: A nota em si;
 * @author ArturBarreto
 */
@Data
@Entity
@Table(name = "tab_movie_rating")
public class MovieRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie_rating")
    private Long idMovieRating;

    @Column(length = 10, nullable = false, name = "id_imdb")
    private String idImdb;

    @Column(length = 20, nullable = false, name = "user_name")
    private String username;

    @Column(name = "movie_rating")
    private Long movieRating;

}
