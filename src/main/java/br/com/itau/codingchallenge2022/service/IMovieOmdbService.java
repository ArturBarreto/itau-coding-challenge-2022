package br.com.itau.codingchallenge2022.service;

import br.com.itau.codingchallenge2022.model.MovieOmdb;

import java.util.List;

public interface IMovieOmdbService {
    public List<MovieOmdb> search(String movieTitle);
}
