package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.model.MovieOmdb;
import br.com.itau.codingchallenge2022.service.impl.MovieOmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Esse {@link RestController} é responsável por receber todas
 * as requisições do usuário em relação a funcionalidade de
 * listar filmes e trazes informações do OMDB.
 * @author ArturBarreto
 */
@RestController
public class MovieController {

    @Autowired
    private MovieOmdbService movieService;

    @GetMapping("/movie/{movieTitle}")
    public List<MovieOmdb> search(@PathVariable String movieTitle) {
        return movieService.search(movieTitle);
    }

}