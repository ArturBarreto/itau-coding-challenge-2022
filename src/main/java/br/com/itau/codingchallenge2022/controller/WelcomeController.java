package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.dto.ResultSearch;
import br.com.itau.codingchallenge2022.model.MovieOmdb;
import br.com.itau.codingchallenge2022.repository.MovieOmdbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }

    @GetMapping("/users")
    public String users() {
        return "Authorized user";
    }

    @Autowired
    private MovieOmdbRepository restRepository;

    @GetMapping("/users/movie/{movieTitle}")
    List<MovieOmdb> search(@PathVariable String movieTitle) {
        ResultSearch resultSearch = this.restRepository.search(movieTitle);
        return resultSearch.getResultList();
    }

    @GetMapping("/managers")
    public String managers() {
        return "Authorized manager";
    }
}