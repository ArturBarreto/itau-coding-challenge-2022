package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.model.Commentary;
import br.com.itau.codingchallenge2022.service.impl.CommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentaryController {

    @Autowired
    private CommentaryService commentaryService;

    @PostMapping("/commentary")
    public void createCommentary(@RequestBody Commentary commentary) {
        commentaryService.createCommentary(commentary);
    }

}
