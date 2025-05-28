package com.beginsecure.messenger;

import com.beginsecure.messenger.domain.CatFact;
import com.beginsecure.messenger.domain.Jokes;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class MessengerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessengerAppApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return results -> {
			CatFact catFact = restTemplate.getForObject("https://catfact.ninja/fact", CatFact.class);
			Jokes joke = restTemplate.getForObject("https://official-joke-api.appspot.com/random_joke", Jokes.class);
			System.out.println(joke);
			System.out.println(catFact);
		};
	}

}
