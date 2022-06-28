package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.model.User;
import br.com.itau.codingchallenge2022.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public void postUser(@RequestBody User user){
        service.createUser(user);
    }

}
