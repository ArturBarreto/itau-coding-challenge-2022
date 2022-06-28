package br.com.itau.codingchallenge2022;

import br.com.itau.codingchallenge2022.model.ResultSearch;
import br.com.itau.codingchallenge2022.repository.MovieOmdbRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CodingChallenge2022ApplicationTests {

	@Autowired
	private MovieOmdbRepository restRepository;

	@Test
	void search() {
		ResultSearch resultSearch = this.restRepository.search("back to the future");
		assertTrue(resultSearch.getResponse());
		resultSearch.getResultList().forEach(System.out::println);
	}

}