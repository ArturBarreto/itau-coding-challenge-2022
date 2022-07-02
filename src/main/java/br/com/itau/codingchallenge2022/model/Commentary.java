package br.com.itau.codingchallenge2022.model;

import br.com.itau.codingchallenge2022.init.StartApplication;
import lombok.Data;

import javax.persistence.*;

/**
 * Essa classe {@link Commentary} é responsável por representar um comentário.
 * Um comentário possui os seguintes campos:
 *      id: Identificador do comentário;
 *      idImdb: Identificador do filme ao qual o comentário se refere;
 *      username: Username do usuário que fez o comentário;
 *      commentary: O comentário em si;
 *      flagedAsRepeated: flag que indica se o comentário foi marcado como repetido por um moderador;
 *      isResponseToCommenteryId: Se um comentário for uma resposta a outro comentário,
 *                                esse campo terá um identificador deste comentário respondido;
 *      isQuotingToCommenteryId: Se um comentário citar um outro comentário, o id deste citado
 *                               será salvo nesse campo;
 * @author ArturBarreto
 */
@Data
@Entity
@Table(name = "tab_commentary")
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commentary")
    private Long id;

    @Column(length = 10, nullable = false, name = "id_imdb")
    private String idImdb;

    @Column(length = 20, nullable = false, name = "user_name")
    private String username;

    @Column(length = 250, nullable = false)
    private String commentary;

    private boolean flagedAsRepeated = false;

    private Long isResponseToCommenteryId = null;

    private Long isQuotingToCommenteryId = null;

}
