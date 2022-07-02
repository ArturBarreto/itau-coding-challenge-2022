package br.com.itau.codingchallenge2022.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;

import lombok.*;

/**
 * Essa classe {@link MovieOmdb} é responsável por representar um filme, da lista de filmes,
 * que é retornado pelo OMDB através de sua API consumida pelo OpenFeign.
 * Essa classe possui os seguintes campos:
 *      idImdb: Identificador do filme ao qual o comentário se refere;
 *      title: O título do filme;
 *      year: O ano de lançamento do filme.
 * @author ArturBarreto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MovieOmdb {

    @JsonProperty("imdbID")
    private String imdbId;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Year")
    private Integer year;
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
}