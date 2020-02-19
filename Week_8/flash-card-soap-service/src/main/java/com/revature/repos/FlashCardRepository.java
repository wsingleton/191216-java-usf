package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.generated.FlashCard;

@Repository
public interface FlashCardRepository extends JpaRepository<FlashCard, Integer> {

	FlashCard getFlashCardByQuestion(String questionText);
	
}
