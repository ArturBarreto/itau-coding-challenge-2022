package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.model.Commentary;
import br.com.itau.codingchallenge2022.service.impl.CommentaryService;
import br.com.itau.codingchallenge2022.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentaryController {

    @Autowired
    private CommentaryService commentaryService;

    @Autowired
    private UserService userService;

    @PostMapping("/commentary")
    public void createCommentary(@RequestBody Commentary commentary) {
        commentaryService.createCommentary(commentary);
        userService.updatePointsByCommentary(commentary);
    }

    @PostMapping("/commentary/responseto/{commentaryId}")
    public void createResponseTo(@RequestBody Commentary commentary, @PathVariable Long commentaryId) {
        commentaryService.createResponseTo(commentary, commentaryId);
        userService.updatePointsByCommentary(commentary);
    }

    @PostMapping("/commentary/quotingcommentary/{commentaryId}")
    public void createQuotingCommentary(@RequestBody Commentary commentary, @PathVariable Long commentaryId) {
        commentaryService.createQuotingCommentary(commentary, commentaryId);
        userService.updatePointsByCommentary(commentary);
    }

    @GetMapping("/commentary/")
    public ResponseEntity <List<Commentary>> findAll(){
        return new ResponseEntity<>(commentaryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/commentary/movie/{imdbId}")
    public ResponseEntity <List<Commentary>> findAllByImdbId(@PathVariable String imdbId){
        return new ResponseEntity<>(commentaryService.findAllByImdbId(imdbId), HttpStatus.OK);
    }

    @GetMapping("/commentary/user/{username}")
    public ResponseEntity <List<Commentary>> findAllByUserId(@PathVariable String username){
        return new ResponseEntity<>(commentaryService.findAllByUsername(username), HttpStatus.OK);
    }

    @DeleteMapping("/commentary/{commentaryId}")
    public ResponseEntity<Void> deleteCommentaryById(@PathVariable Long commentaryId) {
        commentaryService.deleteCommentaryById(commentaryId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/commentary/repeated/{commentaryId}")
    public ResponseEntity<Void> flagAsRepeated(@PathVariable Long commentaryId) {
        commentaryService.flagCommentaryAsRepeated(commentaryId);
        return ResponseEntity.ok().build();
    }

}
