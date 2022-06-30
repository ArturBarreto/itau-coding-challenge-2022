package br.com.itau.codingchallenge2022.service;

import br.com.itau.codingchallenge2022.model.MovieRating;
import br.com.itau.codingchallenge2022.model.User;

import java.util.List;

public interface IUserService {
    public void createUser(User user);
    public User findByUsername(String username);
    public void updateRoles(User user);
    public void updatePoints(MovieRating movieRating);
    public List<User> findAll();
}
