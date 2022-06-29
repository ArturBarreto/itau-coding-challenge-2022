package br.com.itau.codingchallenge2022.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tab_commentary")
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commentary")
    private Integer id;

    @Column(length = 10, nullable = false, name = "id_imdb")
    private String imdbId;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 250, nullable = false)
    private String commentary;

}
