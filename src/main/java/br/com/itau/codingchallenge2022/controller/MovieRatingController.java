package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.model.MovieRating;
import br.com.itau.codingchallenge2022.service.impl.MovieRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieRatingController {

    @Autowired
    private MovieRatingService movieRatingService;

    @PostMapping("/rating")
    public void createMovieRating(@RequestBody MovieRating movieRating) {
        movieRatingService.createMovieRating(movieRating);
    }

    @GetMapping("/rating")
    public ResponseEntity<List<MovieRating>> findAll(){
        return new ResponseEntity<>(movieRatingService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/rating/movie/{imdbId}")
    public ResponseEntity <List<MovieRating>> findAllByImdbId(@PathVariable String imdbId){
        return new ResponseEntity<>(movieRatingService.findAllByImdbId(imdbId), HttpStatus.OK);
    }

    @GetMapping("/rating/user/{username}")
    public ResponseEntity <List<MovieRating>> findAllByUserId(@PathVariable String username){
        return new ResponseEntity<>(movieRatingService.findAllByUsername(username), HttpStatus.OK);
    }
}
