package com.revature.quizzard.flashcard.services;

import com.revature.quizzard.flashcard.entities.Flashcard;
import com.revature.quizzard.flashcard.exceptions.ResourceNotFoundException;
import com.revature.quizzard.flashcard.repos.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlashcardService {

    private FlashcardRepository cardRepo;

    @Autowired
    public FlashcardService(FlashcardRepository repo) {
        this.cardRepo = repo;
    }

    @Transactional(readOnly = true)
    public Iterable<Flashcard> getAllCards() {
        return cardRepo.findAll();
    }

    @Transactional(readOnly = true)
    public Flashcard getCardById(int id) {
        return cardRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Transactional
    public Flashcard addCard(Flashcard newCard) {
        return cardRepo.save(newCard);
    }

    @Transactional
    public Flashcard updateCard(Flashcard updatedCard) {
        Flashcard card = getCardById(updatedCard.getId());
        card.setQuestion(updatedCard.getQuestion());
        card.setAnswer(updatedCard.getAnswer());
        card.setCategories(updatedCard.getCategories());
        return card;
    }

    @Transactional
    public void deleteCardById(int id) {
        cardRepo.deleteById(id);
    }
}
