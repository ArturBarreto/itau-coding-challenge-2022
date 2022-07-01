package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.model.Commentary;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikedDislikedCommentary {

    @PostMapping("/commentary/responseto/{commentaryId}")
    public void createResponseTo(@RequestBody Commentary commentary, @PathVariable Long commentaryId) {
        commentaryService.createResponseTo(commentary, commentaryId);
        userService.updatePointsByCommentary(commentary);
    }
}
