package br.com.itau.codingchallenge2022.service.impl;

import br.com.itau.codingchallenge2022.model.MovieOmdb;
import br.com.itau.codingchallenge2022.model.ResultSearch;
import br.com.itau.codingchallenge2022.repository.MovieOmdbRepository;
import br.com.itau.codingchallenge2022.service.IMovieOmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieOmdbService implements IMovieOmdbService {
    @Autowired
    private MovieOmdbRepository restRepository;

    @Override
    public List<MovieOmdb> search(String movieTitle) {
        ResultSearch resultSearch = this.restRepository.search(movieTitle);
        return resultSearch.getResultList();
    }
}
