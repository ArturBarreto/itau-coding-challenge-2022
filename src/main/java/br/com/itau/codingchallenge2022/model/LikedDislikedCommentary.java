package br.com.itau.codingchallenge2022.model;

import lombok.Data;
import javax.persistence.*;

/**
 * Essa classe {@link LikedDislikedCommentary} é responsável por representar o
 * status dos comentários que os usuários marcaram como "gostei" ou "não gostei".
 * Essa entidade possui os seguintes campos:
 *      id: Identificador do status ;
 *      username: Username do usuário que marcou determinado comentário como
 *                "gostei" ou "não gostei";
 *      commentaryId: O identificador do comentário marcado como "gostei" ou "não gostei";
 *      status: Valor que representa se o usuário marcou o comentári. Pode ser "liked" ou "disliked".
 * @author ArturBarreto
 */
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
