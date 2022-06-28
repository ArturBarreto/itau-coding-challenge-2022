package br.com.itau.codingchallenge2022;

import br.com.itau.codingchallenge2022.dto.ResultSearch;
import br.com.itau.codingchallenge2022.repository.MovieMinimalRestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CodingChallenge2022ApplicationTests {

	@Autowired
	private MovieMinimalRestRepository restRepository;

	@Test
	void search() {
		ResultSearch resultSearch = this.restRepository.search("lord of the rings");
		assertTrue(resultSearch.getResponse());
		resultSearch.getResultList().forEach(System.out::println);
	}

}