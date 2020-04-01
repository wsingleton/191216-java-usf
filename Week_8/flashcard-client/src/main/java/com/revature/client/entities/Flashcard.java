package com.revature.client.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Flashcard implements Serializable {

    private int id;
    private String question;
    private String answer;
    private Set<Category> categories;

    public Flashcard() {
        super();
    }

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Flashcard(String question, String answer, Set<Category> categories) {
        this.question = question;
        this.answer = answer;
        this.categories = categories;
    }

    public Flashcard(int id, String question, String answer, Set<Category> categories) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.categories = categories;
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void addCategories(Category... categories) {
        if (this.categories == null) this.categories = new HashSet<>();
        this.categories.addAll(Arrays.asList(categories));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flashcard flashcard = (Flashcard) o;
        return id == flashcard.id &&
                Objects.equals(question, flashcard.question) &&
                Objects.equals(answer, flashcard.answer) &&
                Objects.equals(categories, flashcard.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, categories);
    }

    @Override
    public String toString() {
        return "Flashcard{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", categories=" + categories +
                '}';
    }

}
