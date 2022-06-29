package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.model.User;
import br.com.itau.codingchallenge2022.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void postUser(@RequestBody User user){
        user.getRoles().clear();                // Evitar que o usuário faça um post atribuindo roles ao perfil criado
        user.getRoles().add("LEITOR");
        userService.createUser(user);
    }

}