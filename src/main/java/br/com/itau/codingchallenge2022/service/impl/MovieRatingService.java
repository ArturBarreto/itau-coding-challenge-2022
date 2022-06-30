package br.com.itau.codingchallenge2022.service.impl;

import br.com.itau.codingchallenge2022.model.Commentary;
import br.com.itau.codingchallenge2022.model.MovieRating;
import br.com.itau.codingchallenge2022.repository.MovieRatingRepository;
import br.com.itau.codingchallenge2022.service.IMovieRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieRatingService implements IMovieRatingService {

    @Autowired
    MovieRatingRepository movieRatingRepository;

    public void createMovieRating(MovieRating movieRating) {
        movieRatingRepository.save(movieRating);
    }

    public List<MovieRating> findAll() {
        return movieRatingRepository.findAll();
    }

    public List<MovieRating> findAllByImdbId(String imdbId) {
        MovieRating movieRating = new MovieRating();
        movieRating.setIdImdb(imdbId);
        Example<MovieRating> example = Example.of(movieRating);
        List<MovieRating> results = movieRatingRepository.findAll(example);
        return results;
    }

    public List<MovieRating> findAllByUsername(String username) {
        MovieRating movieRating = new MovieRating();
        movieRating.setUsername(username);
        Example<MovieRating> example = Example.of(movieRating);
        List<MovieRating> results = movieRatingRepository.findAll(example);
        return results;
    }
}
