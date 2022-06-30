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
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findByUsername("leitor1");
        if(user==null){
            user = new User();
            user.setName("Leitor 1");
            user.setUsername("leitor1");
            user.setPassword(passwordEncoder.encode("leitor123"));
            user.getRoles().add("LEITOR");
            user.setPoints(0);
            userRepository.save(user);
        }
        user = userRepository.findByUsername("basico1");
        if(user ==null){
            user = new User();
            user.setName("Básico 1");
            user.setUsername("basico1");
            user.setPassword(passwordEncoder.encode("basico123"));
            user.getRoles().add("LEITOR");
            user.getRoles().add("BASICO");
            user.setPoints(20);
            userRepository.save(user);
        }
        user = userRepository.findByUsername("avancado1");
        if(user ==null){
            user = new User();
            user.setName("Avançado 1");
            user.setUsername("avancado1");
            user.setPassword(passwordEncoder.encode("avancado123"));
            user.getRoles().add("LEITOR");
            user.getRoles().add("BASICO");
            user.getRoles().add("AVANCADO");
            user.setPoints(100);
            userRepository.save(user);
        }
        user = userRepository.findByUsername("moderador1");
        if(user ==null){
            user = new User();
            user.setName("Moderador 1");
            user.setUsername("moderador1");
            user.setPassword(passwordEncoder.encode("moderador123"));
            user.getRoles().add("LEITOR");
            user.getRoles().add("BASICO");
            user.getRoles().add("AVANCADO");
            user.getRoles().add("MODERADOR");
            user.setPoints(1000);
            userRepository.save(user);
        }
    }
}