package br.com.itau.codingchallenge2022.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tab_movie_rating")
public class MovieRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie_rating")
    private Integer idMovieRating;

    @Column(length = 10, nullable = false, name = "id_imdb")
    private String idImdb;

    @Column(length = 20, nullable = false, name = "user_name")
    private String username;

    @Column(name = "movie_rating")
    private Long movieRating;

}
