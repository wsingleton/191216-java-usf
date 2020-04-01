package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.FlashCard;

@Service
public class FlashCardService {

	private static ArrayList<FlashCard> cardsDB;
	private static int idSequence = 1;
	
	static {
		System.out.println("Instantiating and populating card database...");
		cardsDB = new ArrayList<>();
		cardsDB.add(new FlashCard(idSequence++, "test1", "answer1"));
		cardsDB.add(new FlashCard(idSequence++, "test2", "answer2"));
		cardsDB.add(new FlashCard(idSequence++, "test3", "answer3"));
		cardsDB.add(new FlashCard(idSequence++, "test4", "answer4"));
		cardsDB.add(new FlashCard(idSequence++, "test5", "answer5"));
		System.out.println("Mock card database populated.");
	}
	
	public List<FlashCard> getAll() {
        return cardsDB;
    }
    
    public FlashCard getById(int id) {
        Optional<FlashCard> _card = cardsDB.stream().filter(card -> card.getId() == id).findFirst();
        if(_card.isPresent()) return _card.get();
        else throw new ResourceNotFoundException("No flash card with id " + id + " found.");
    }
    
    public FlashCard add(FlashCard newCard) {
        newCard.setId(idSequence++);
        cardsDB.add(newCard);
        return newCard;
    }
    
    public FlashCard update(FlashCard updatedCard) {
        FlashCard oldCard = getById(updatedCard.getId());
        if(oldCard == null) throw new ResourceNotFoundException("No flash card with id " + updatedCard.getId() + " found.");
        oldCard.setQuestion(updatedCard.getQuestion());
        oldCard.setAnswer(updatedCard.getAnswer());
        return updatedCard;
    }
    
    public void delete(int id) {
        boolean wasDeleted = cardsDB.removeIf(card -> card.getId() == id);
        if(!wasDeleted) throw new ResourceNotFoundException("No flash card with id " + id + " found.");
    }
    
}
