package com.beginsecure.messenger.controller;

import com.beginsecure.messenger.domain.CatFact;
import com.beginsecure.messenger.domain.Jokes;
import com.beginsecure.messenger.domain.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class MessageController {
    private final RestTemplate restTemplate;

    @Autowired
    public MessageController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hallo")
    public Message startMessage(@RequestParam(value="name", defaultValue = "Welt") String name) {
        return new Message("Hallo " + name + "!");
    }

    @GetMapping("/bisBald")
    public Message endMessage(@RequestParam(value="name", defaultValue = "Welt") String name) {
        return new Message("Bis bald " + name + "!");
    }

    @GetMapping("/catFact")
    public Message catMessage() {
        CatFact catFact = restTemplate.getForObject("https://catfact.ninja/fact", CatFact.class);
        return new Message(catFact.getFact());
    }

    @GetMapping("/joke")
    public Message jokeMessage() {
        Jokes joke = restTemplate.getForObject("https://official-joke-api.appspot.com/random_joke", Jokes.class);
        return new Message(joke.getSetup()+" "+joke.getPunchline());
    }


}
