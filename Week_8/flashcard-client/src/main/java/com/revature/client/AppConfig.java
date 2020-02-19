package com.revature.client;

import com.revature.client.entities.Flashcard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AppConfig {

    private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);
    private static final String API_URL = "http://localhost:5000/flashcards";

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        try {

            LOG.info("Getting all flashcards...");
            ResponseEntity<Flashcard[]> resp = restTemplate.getForEntity(API_URL, Flashcard[].class);
            LOG.info("Resource consumption successful");
            LOG.info(resp.toString());
            LOG.info("Status code: [" + resp.getStatusCodeValue() + "] - " + resp.getStatusCode());
            LOG.info("Response headers: " + resp.getHeaders());
            LOG.info("Payload: ");
            for (Flashcard card : resp.getBody()) {
                LOG.info("\t" + card);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
