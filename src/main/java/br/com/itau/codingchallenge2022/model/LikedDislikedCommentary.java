package br.com.itau.codingchallenge2022.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tab_liked_disliked_commentary")
public class LikedDislikedCommentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liked_disliked_commentary")
    private Long id;

    @Column(length = 20, nullable = false, name = "user_name")
    private String username;

    private Long commentaryId;

    private String status = null;

}
