package br.com.itau.codingchallenge2022.service.impl;

import br.com.itau.codingchallenge2022.model.MovieOmdb;
import br.com.itau.codingchallenge2022.model.ResultSearch;
import br.com.itau.codingchallenge2022.repository.MovieOmdbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieOmdbService {
    @Autowired
    private MovieOmdbRepository restRepository;

    public List<MovieOmdb> search(String movieTitle) {
        ResultSearch resultSearch = this.restRepository.search(movieTitle);
        return resultSearch.getResultList();
    }
}
