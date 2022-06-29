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
        User user = repository.findByUsername("leitor1");
        if(user==null){
            user = new User();
            user.setName("Leitor 1");
            user.setUsername("leitor1");
            user.setPassword(encoder.encode("leitor123"));
            user.getRoles().add("LEITOR");
            repository.save(user);
        }
        user = repository.findByUsername("basico1");
        if(user ==null){
            user = new User();
            user.setName("Básico 1");
            user.setUsername("basico1");
            user.setPassword(encoder.encode("basico123"));
            user.getRoles().add("LEITOR");
            user.getRoles().add("BASICO");
            repository.save(user);
        }
        user = repository.findByUsername("avancado1");
        if(user ==null){
            user = new User();
            user.setName("Avançado 1");
            user.setUsername("avancado1");
            user.setPassword(encoder.encode("avancado123"));
            user.getRoles().add("LEITOR");
            user.getRoles().add("BASICO");
            user.getRoles().add("AVANCADO");
            repository.save(user);
        }
        user = repository.findByUsername("moderador1");
        if(user ==null){
            user = new User();
            user.setName("Moderador 1");
            user.setUsername("moderador1");
            user.setPassword(encoder.encode("moderador123"));
            user.getRoles().add("LEITOR");
            user.getRoles().add("BASICO");
            user.getRoles().add("AVANCADO");
            user.getRoles().add("MODERADOR");
            repository.save(user);
        }
    }
}