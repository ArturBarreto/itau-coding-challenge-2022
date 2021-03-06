package br.com.itau.codingchallenge2022.service.impl;

import br.com.itau.codingchallenge2022.model.Commentary;
import br.com.itau.codingchallenge2022.model.MovieRating;
import br.com.itau.codingchallenge2022.model.User;
import br.com.itau.codingchallenge2022.repository.UserRepository;
import br.com.itau.codingchallenge2022.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço {@link UserService} referente as regras de negócio dos usuários.
 * @author ArturBarreto
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(User user){
        String pass = user.getPassword();
        // Criptografia da senha
        user.setPassword(passwordEncoder.encode(pass));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username){
        User user = userRepository.findByUsername(username);
        return user;
     }

     @Override
     public void updateRoles(User user) {

         if (user.getPoints() == 20) {
             if (!user.getRoles().contains("BASICO")) {
                 user.getRoles().add("BASICO");
             }
         } else if (user.getPoints() == 100) {
             if (!user.getRoles().contains("AVANCADO")){
                 user.getRoles().add("AVANCADO");
             }
         } else if (user.getPoints() == 1000) {
             if (!user.getRoles().contains("MODERADOR")) {
                 user.getRoles().add("MODERADOR");
             }
         }
     }

    @Override
    public void updatePointsByRating(MovieRating movieRating) {
        String username = movieRating.getUsername();

        User user = findByUsername(username);

        user.setPoints(user.getPoints() + 1);

        updateRoles(user);

        userRepository.save(user);
    }

    @Override
    public void updatePointsByCommentary(Commentary commentary) {
        String username = commentary.getUsername();

        User user = findByUsername(username);

        user.setPoints(user.getPoints() + 1);

        updateRoles(user);

        userRepository.save(user);
    }

    @Override
    public void makeUserModerator(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        User promotedUser = user.get();

        if (!promotedUser.getRoles().contains("BASICO")) {
            promotedUser.getRoles().add("BASICO");
        }
        if (!promotedUser.getRoles().contains("AVANCADO")){
            promotedUser.getRoles().add("AVANCADO");
        }
        if (!promotedUser.getRoles().contains("MODERADOR")) {
            promotedUser.getRoles().add("MODERADOR");
        }

        userRepository.save(promotedUser);
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }
}