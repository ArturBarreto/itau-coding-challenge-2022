package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.model.MovieOmdb;
import br.com.itau.codingchallenge2022.model.User;
import br.com.itau.codingchallenge2022.service.impl.MovieOmdbService;
import br.com.itau.codingchallenge2022.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping("/users")
    @PostMapping
    public void postUser(@RequestBody User user){
        service.createUser(user);
    }

    @GetMapping("/users")
    public String users() {
        return "Authorized user";
    }

    @GetMapping("/managers")
    public String managers() {
        return "Authorized manager";
    }

    @Autowired
    private MovieOmdbService movieService;

    @GetMapping("/users/movie/{movieTitle}")
    public List<MovieOmdb> search(@PathVariable String movieTitle) {
        return movieService.search(movieTitle);
    }
}