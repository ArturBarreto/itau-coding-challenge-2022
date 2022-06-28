package br.com.itau.codingchallenge2022.model;

import br.com.itau.codingchallenge2022.model.MovieOmdb;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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

    public ResultSearch() {
    }

    public ResultSearch(List<MovieOmdb> resultList, Integer total, Boolean response) {
        this.resultList = resultList;
        this.total = total;
        this.response = response;
    }

    public List<MovieOmdb> getResultList() {
        return resultList;
    }

    public void setResultList(List<MovieOmdb> resultList) {
        this.resultList = resultList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getResponse() {
        return response;
    }

    public void setResponse(Boolean response) {
        this.response = response;
    }
}