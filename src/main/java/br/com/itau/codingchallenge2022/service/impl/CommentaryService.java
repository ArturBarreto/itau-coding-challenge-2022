package br.com.itau.codingchallenge2022.service.impl;

import br.com.itau.codingchallenge2022.model.Commentary;
import br.com.itau.codingchallenge2022.repository.CommentaryRepository;
import br.com.itau.codingchallenge2022.service.ICommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * Serviço {@link CommentaryService} referente as regras de negócio de comentários.
 * @author ArturBarreto
 */
@Service
public class CommentaryService implements ICommentaryService {
    @Autowired
    private CommentaryRepository commentaryRepository;

    @Override
    public void createCommentary(Commentary commentary){
        commentaryRepository.save(commentary);
    }

    @Override
    public void createResponseTo(Commentary commentary, Long commentaryId){
        commentary.setIsResponseToCommenteryId(commentaryId);
        commentaryRepository.save(commentary);
    }

    @Override
    public void createQuotingCommentary(Commentary commentary, Long commentaryId){
        commentary.setIsQuotingToCommenteryId(commentaryId);
        commentaryRepository.save(commentary);
    }

    @Override
    public List<Commentary> findAll(){
        return commentaryRepository.findAll();
    }

    @Override
    public List<Commentary> findAllByImdbId(String imdbId) {
        Commentary commentary = new Commentary();
        commentary.setIdImdb(imdbId);
        Example<Commentary> example = Example.of(commentary);
        List<Commentary> results = commentaryRepository.findAll(example);
        return results;
    }

    @Override
    public List<Commentary> findAllByUsername(String username) {
        Commentary commentary = new Commentary();
        commentary.setUsername(username);
        Example<Commentary> example = Example.of(commentary);
        List<Commentary> results = commentaryRepository.findAll(example);
        return results;
    }

    @Override
    public void deleteCommentaryById(Long commentaryId) {
        commentaryRepository.deleteById(commentaryId);
    }

    @Override
    public void flagCommentaryAsRepeated(Long commentaryId) {
        Optional<Commentary> commentary = commentaryRepository.findById(commentaryId);
        Commentary flagedCommentary = commentary.get();
        flagedCommentary.setFlagedAsRepeated(true);
        commentaryRepository.save(flagedCommentary);
    }
}
