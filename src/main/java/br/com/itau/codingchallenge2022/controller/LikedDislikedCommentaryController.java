package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.model.LikedDislikedCommentary;
import br.com.itau.codingchallenge2022.service.impl.LikedDislikedCommentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Esse {@link RestController} é responsável por receber todas
 * as requisições do usuário em relação as funcionalidades de
 * gostar ou não gostar dos comentários.
 * @author ArturBarreto
 */
@RestController
public class LikedDislikedCommentaryController {

    @Autowired
    LikedDislikedCommentaryService likedDislikedCommentaryService;

    @PostMapping("/commentary/likedislike/{commentaryId}")
    public void createLikedDislikedCommentary(@RequestBody LikedDislikedCommentary likedDislikedCommentary, @PathVariable Long commentaryId) {
        likedDislikedCommentaryService.createLikedDislikedCommentary(likedDislikedCommentary, commentaryId);
    }

    @GetMapping("/commentary/likedislike")
    public ResponseEntity <List<LikedDislikedCommentary>> findAll() {
        return new ResponseEntity<>(likedDislikedCommentaryService.findAll(), HttpStatus.OK);
    }
}
