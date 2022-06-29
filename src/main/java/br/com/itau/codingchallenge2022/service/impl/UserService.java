package br.com.itau.codingchallenge2022.service.impl;

import br.com.itau.codingchallenge2022.model.User;
import br.com.itau.codingchallenge2022.repository.UserRepository;
import br.com.itau.codingchallenge2022.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public void createUser(User user){
        String pass = user.getPassword();
        // Criptografia da senha
        user.setPassword(encoder.encode(pass));
        repository.save(user);
    }
}
