package br.com.itau.codingchallenge2022.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Essa classe {@link ResultSearch} é responsável por representar uma lista de filmes
 * que é retornado pelo OMDB através de sua API consumida pelo OpenFeign.
 * Essa classe possui os seguintes campos:
 *      resultList: Lista de filmes retornados pelo API do OMDB;
 *      total: Total de filmes retornados;
 *      response: Booleano que indica se houve resposta.
 * @author ArturBarreto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultSearch {

    @JsonProperty("Search")
    private List<MovieOmdb> resultList;
    private Integer total;
    private Boolean response;

    @JsonProperty("Response")
    public void setResponse(String response) {
        this.response = Boolean.valueOf(response);
    }

    @JsonProperty("totalResults")
    public void setTotal(String total) {
        this.total = Integer.parseInt(total);
    }

}