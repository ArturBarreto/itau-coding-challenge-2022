package br.com.itau.codingchallenge2022.service;

import br.com.itau.codingchallenge2022.model.Commentary;

import java.util.List;

public interface ICommentaryService {
    public void createCommentary(Commentary commentary);
    public List<Commentary> findAll();
    public List<Commentary> findAllByImdbId(String imdbId);
    public List<Commentary> findAllByUsername(String username);
}
