package com.revature.quizzard.repositories;

import com.revature.quizzard.entities.Flashcard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FlashcardRepository implements CRUDRepository<Flashcard> {
    @Override
    public List<Flashcard> findAll() {
        return null;
    }

    @Override
    public Flashcard findById(int id) {
        return null;
    }

    @Override
    public Flashcard save(Flashcard obj) {
        return null;
    }

    @Override
    public boolean update(Flashcard obj) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
