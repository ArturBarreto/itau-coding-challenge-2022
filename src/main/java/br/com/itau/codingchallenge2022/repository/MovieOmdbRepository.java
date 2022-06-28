package br.com.itau.codingchallenge2022.repository;

import br.com.itau.codingchallenge2022.model.ResultSearch;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "movieMinimalRest", url = "${omdbapi.url}")
@Repository
public interface MovieOmdbRepository {
    @GetMapping
    ResultSearch search(@RequestParam("s") String movieTitle);
}