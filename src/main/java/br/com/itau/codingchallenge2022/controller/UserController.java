package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.model.User;
import br.com.itau.codingchallenge2022.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void postUser(@RequestBody User user){
        user.getRoles().clear();                // Evitar que o usuário faça um POST atribuindo roles ao perfil criado
        user.getRoles().add("LEITOR");          // Novos usuário iniciam com o perfil Leitor
        userService.createUser(user);
    }

    @GetMapping("admin/users")
    public ResponseEntity<List<User>> findAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("admin/makeusermoderator/{userId}")
    public ResponseEntity<Void> makeUserModerator(@PathVariable Long userId) {
        userService.makeUserModerator(userId);
        return ResponseEntity.ok().build();
    }
}