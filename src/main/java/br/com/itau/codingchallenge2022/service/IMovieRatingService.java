package br.com.itau.codingchallenge2022.service;

import br.com.itau.codingchallenge2022.model.MovieRating;

import java.util.List;

public interface IMovieRatingService {
    public void createMovieRating(MovieRating movieRating);
    public List<MovieRating> findAll();
    public List<MovieRating> findAllByImdbId(String imdbId);
    public List<MovieRating> findAllByUsername(String username);
}
