package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.model.MovieOmdb;
import br.com.itau.codingchallenge2022.service.impl.MovieOmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieOmdbService movieService;

    @GetMapping("/movie/{movieTitle}")
    public List<MovieOmdb> search(@PathVariable String movieTitle) {
        return movieService.search(movieTitle);
    }

}