package com.revature.quizzard.flashcard.controllers;

import com.revature.quizzard.flashcard.dtos.ErrorResponse;
import com.revature.quizzard.flashcard.entities.Flashcard;
import com.revature.quizzard.flashcard.exceptions.ResourceNotFoundException;
import com.revature.quizzard.flashcard.services.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/flashcards")
public class FlashcardController {

    private FlashcardService cardService;

    @Autowired
    public FlashcardController(FlashcardService service) {
        this.cardService = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Flashcard> getAll() {
        return cardService.getAllCards();
    }

    @GetMapping(value = "/{attr}/{val}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flashcard getCard(@PathVariable String attr, @PathVariable String val) {
        switch (attr) {
            case "id":
                return cardService.getCardById(Integer.parseInt(val));
            default:
                throw new RuntimeException("INVALID REQUEST");
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flashcard addNewCard(@RequestBody @Valid Flashcard newCard) {
        return cardService.addCard(newCard);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flashcard updateCard(@RequestBody @Valid Flashcard updatedCard) {
        return cardService.updateCard(updatedCard);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCardById(@PathVariable int id) {
        cardService.deleteCardById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleResourceNotFound(ResourceNotFoundException e) {
        ErrorResponse err = new ErrorResponse();
        err.setStatus(404);
        err.setMessage(e.getMessage());
        err.setTimestamp(System.currentTimeMillis());
        return err;
    }

}
