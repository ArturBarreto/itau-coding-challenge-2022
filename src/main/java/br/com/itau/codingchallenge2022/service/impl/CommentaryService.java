package br.com.itau.codingchallenge2022.service.impl;

import br.com.itau.codingchallenge2022.model.Commentary;
import br.com.itau.codingchallenge2022.model.User;
import br.com.itau.codingchallenge2022.repository.CommentaryRepository;
import br.com.itau.codingchallenge2022.service.ICommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaryService implements ICommentaryService {
    @Autowired
    private CommentaryRepository commentaryRepository;
    @Override
    public void createCommentary(Commentary commentary){
        commentaryRepository.save(commentary);
    }
}
