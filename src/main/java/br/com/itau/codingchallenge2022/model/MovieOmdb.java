package br.com.itau.codingchallenge2022.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class MovieOmdb {

    @JsonProperty("imdbID")
    private String imdbId;
    @JsonProperty("Title")
    private String title;
    private Integer year;

    @JsonProperty("Year")
    public void setYear(String year) {
        this.year = convertYear(year);
    }

    private int convertYear(final String year) {
        if (year.matches("\\d+")) {
            return Integer.parseInt(year);
        }
        return Arrays.stream(year.split("\\D"))
                .map(Integer::parseInt)
                .findFirst()
                .orElseThrow();
    }

    public MovieOmdb(String imdbId, String title, Integer year) {
        this.imdbId = imdbId;
        this.title = title;
        this.year = year;
    }

    public MovieOmdb() {
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}