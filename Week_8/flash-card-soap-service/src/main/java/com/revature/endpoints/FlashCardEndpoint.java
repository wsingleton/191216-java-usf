package com.revature.endpoints;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.revature.generated.DeleteFlashCardByIdRequest;
import com.revature.generated.DeletedFlashCardResponse;
import com.revature.generated.FlashCard;
import com.revature.generated.FlashCardResponse;
import com.revature.generated.GetAllFlashCardsRequest;
import com.revature.generated.GetAllFlashCardsResponse;
import com.revature.generated.GetFlashCardByIdRequest;
import com.revature.generated.GetFlashCardByQuestionRequest;
import com.revature.generated.PostFlashCardRequest;
import com.revature.generated.UpdateFlashCardRequest;
import com.revature.repos.FlashCardRepository;

@Endpoint
public class FlashCardEndpoint {

	private static final String NAMESPACE_URI = "http://revature.com";
	
	private FlashCardRepository cardRepo;
	
	@Autowired
	public FlashCardEndpoint(FlashCardRepository repo) {
		this.cardRepo = repo;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getAllFlashCardsRequest")
	public GetAllFlashCardsResponse getAllFlashCards(@RequestPayload GetAllFlashCardsRequest request) {
		GetAllFlashCardsResponse response = new GetAllFlashCardsResponse();
		response.getCards().addAll(cardRepo.findAll());
		return response;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getFlashCardByIdRequest")
	public FlashCardResponse getFlashCardById(@RequestPayload GetFlashCardByIdRequest request) {
		FlashCardResponse response = new FlashCardResponse();
		Optional<FlashCard> _card = cardRepo.findById(request.getId());
		if(!_card.isPresent()) throw new RuntimeException("No flash card found with provided id");
		response.setCard(_card.get());
		return response;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getFlashCardByQuestionRequest")
	public FlashCardResponse getFlashCardByQuestion(@RequestPayload GetFlashCardByQuestionRequest request) {
		FlashCardResponse response = new FlashCardResponse();
		FlashCard card = cardRepo.getFlashCardByQuestion(request.getQuestion());
		if(card == null) throw new RuntimeException("No flash card found with provided question text");
		response.setCard(card);
		return response;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="postFlashCardRequest")
	public FlashCardResponse addNewFlashCard(@RequestPayload PostFlashCardRequest request) {
		FlashCardResponse response = new FlashCardResponse();
		if(request.getNewCard() == null) throw new RuntimeException("Invalid card object provided");
		FlashCard persistedCard = cardRepo.save(request.getNewCard());
		response.setCard(persistedCard);
		return response;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="updateFlashCardRequest")
	public FlashCardResponse updateFlashCard(@RequestPayload UpdateFlashCardRequest request) {
		FlashCardResponse response = new FlashCardResponse();
		if(request.getUpdatedCard() == null) throw new RuntimeException("Invalid card object provided");
		FlashCard persistedCard = cardRepo.save(request.getUpdatedCard());
		response.setCard(persistedCard);
		return response;
	}
	
	@ResponsePayload
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="deleteFlashCardByIdRequest")
	public DeletedFlashCardResponse deleteFlashCardById(@RequestPayload DeleteFlashCardByIdRequest request) {
		DeletedFlashCardResponse response = new DeletedFlashCardResponse();
		cardRepo.deleteById(request.getId());
		response.setDeleted(true);
		return response;
	}
	
}
