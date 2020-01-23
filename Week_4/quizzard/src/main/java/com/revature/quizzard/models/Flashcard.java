package com.revature.quizzard.models;

import java.util.Objects;

public class Flashcard {

    private int id;
    private String question;
    private String answer;
    private Category category;

    public Flashcard(String question, String answer) {
        this.id = 0;
        this.question = (question != null) ? question : "";
        this.answer = (answer != null) ? answer : "";
        this.category = Category.OTHER;
    }

    public Flashcard(String question, String answer, Category category) {
        this.id = 0;
        this.question = (question != null) ? question : "";
        this.answer = (answer != null) ? answer : "";
        this.category = (category != null) ? category : Category.OTHER;
    }

    public Flashcard(int id, String question, String answer, Category category) {
        this.id = id;
        this.question = (question != null) ? question : "";
        this.answer = (answer != null) ? answer : "";
        this.category = (category != null) ? category : Category.OTHER;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        if (question == null) return;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        if (answer == null) return;
        this.answer = answer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (category == null) return;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashcard flashcard = (Flashcard) o;
        return id == flashcard.id &&
                question.equals(flashcard.question) &&
                answer.equals(flashcard.answer) &&
                category == flashcard.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, category);
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", category=" + category +
                '}';
    }

}
