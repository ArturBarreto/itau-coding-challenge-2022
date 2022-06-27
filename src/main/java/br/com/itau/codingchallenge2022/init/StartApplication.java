package br.com.itau.codingchallenge2022.init;

import br.com.itau.codingchallenge2022.model.User;
import br.com.itau.codingchallenge2022.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = repository.findByUsername("admin");
        if(user==null){
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword(encoder.encode("master123"));
            user.getRoles().add("MANAGERS");
            repository.save(user);
        }
        user = repository.findByUsername("user1");
        if(user ==null){
            user = new User();
            user.setName("USER 1");
            user.setUsername("user1");
            user.setPassword(encoder.encode("user123"));
            user.getRoles().add("USERS");
            repository.save(user);
        }
        user = repository.findByUsername("user2");
        if(user ==null){
            user = new User();
            user.setName("USER 2");
            user.setUsername("user2");
            user.setPassword(encoder.encode("user456"));
            user.getRoles().add("USERS");
            user.getRoles().add("MANAGERS");
            repository.save(user);
        }
    }
}