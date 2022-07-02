package br.com.itau.codingchallenge2022.service;

import br.com.itau.codingchallenge2022.model.MovieOmdb;

import java.util.List;
/**
 * Interface {@link IMovieOmdbService} do serviço CommentaryService.
 * @author ArturBarreto
 */
public interface IMovieOmdbService {
    public List<MovieOmdb> search(String movieTitle);
}
