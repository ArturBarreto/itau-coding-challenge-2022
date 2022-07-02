package br.com.itau.codingchallenge2022.service;

import br.com.itau.codingchallenge2022.model.Commentary;
import br.com.itau.codingchallenge2022.security.JWTCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface {@link ICommentaryService} do serviço CommentaryService.
 * @author ArturBarreto
 */
public interface ICommentaryService {
    public void createCommentary(Commentary commentary);
    public void createResponseTo(Commentary commentary, Long commentaryId);
    public void createQuotingCommentary(Commentary commentary, Long commentaryId);
    public List<Commentary> findAll();
    public List<Commentary> findAllByImdbId(String imdbId);
    public List<Commentary> findAllByUsername(String username);
    public void deleteCommentaryById(Long commentaryId);
    public void flagCommentaryAsRepeated(Long commentaryId);
}
