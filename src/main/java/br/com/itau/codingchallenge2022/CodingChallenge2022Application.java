package br.com.itau.codingchallenge2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CodingChallenge2022Application {

	public static void main(String[] args) {
		SpringApplication.run(CodingChallenge2022Application.class, args);
	}

}
