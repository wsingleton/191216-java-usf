package com.revature.quizzard.entities;

import java.util.Objects;

public class FlashCard {

    private int id;
    private String question;
    private String answer;

    public FlashCard() {
        super();
    }

    public FlashCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public FlashCard(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
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
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlashCard flashCard = (FlashCard) o;
        return id == flashCard.id &&
                Objects.equals(question, flashCard.question) &&
                Objects.equals(answer, flashCard.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer);
    }

    @Override
    public String toString() {
        return "FlashCard{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

}
