package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.ErrorResponse;
import com.revature.models.FlashCard;
import com.revature.services.FlashCardService;

@RestController
@RequestMapping("/flash-cards")
public class FlashCardController {

	private FlashCardService cardService;
	
	@Autowired
	public FlashCardController(FlashCardService service) {
		this.cardService = service;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<FlashCard> getAllCards() {
		return this.cardService.getAll();
	}
	
	// Get by id, using a path variable
	// We can still access the HttpServletRequest/Response objects by including them as params to this method
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public FlashCard getCardById(@PathVariable int id, HttpServletRequest req) {
		System.out.println(req.getMethod());
		return this.cardService.getById(id);
	}
	
	// Get by id, using a request query parameter
	@GetMapping(value="/id", produces=MediaType.APPLICATION_JSON_VALUE)
	public FlashCard getCardById_ReqParam(@RequestParam("cardId") int id) {
		return this.cardService.getById(id);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public FlashCard addCard(@RequestBody FlashCard newCard) {
		return this.cardService.add(newCard);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleNotFoundException(ResourceNotFoundException rnfe) {
		ErrorResponse err = new ErrorResponse();
		err.setStatus(404);
		err.setMessage(rnfe.getMessage());
		err.setTimestamp(System.currentTimeMillis());
		return err;
	}
}
