package com.revature.revabooks.models;

public enum Genre {
    NONFICTION("nonfiction"), FICTION("fiction"), FANTASY("fantasy"),
    SCIENCE_FICTION("science fiction"), ROMANCE("romance"), YOUNG_ADULT("young adult"),
    CHILDRENS("children's"), SELF_HELP("self-help"),
    RELIGION_SPIRITUALITY_NEWAGE("religion, spirituality, and new-age"), PHILOSOPHY("philosophy"),
    EDUCATION("education"), ART("art"), HISTORY("history"),
    ACTION_ADVENTURE("action-adventure"), ALTERNATE_HISTORY("alternate history"),
    AUTOBIOGRAPHY("autobiography"), BIOGRAPHY("biography"), ANTHOLOGY("anthalogy"),
    COOKBOOK("cookbook"), DIARY("diary"), COMIC_BOOK("comic book"),
    COMING_OF_AGE("coming of age"), DICTIONARY("dictionary"), ENCYCLOPEDIA("encyclopedia"),
    CRIME("crime"), TRUE_CRIME("true crime"), GUIDE("guide"), HEALTH ("health"),
    JOURNAL("journal"), MATH("math"), MEMOIR("memoir"), PRAYER("prayer"),
    TEXTBOOK("textbook"), REVIEW("review"), SCIENCE("science"), TRAVEL("travel"),
    DRAMA("drama"), GRAPHIC_NOVEL("graphic novel"), HISTORICAL_FICTION("historical fiction"),
    HORROR("horror"), MYSTERY("mystery"), PARANORMAL_ROMANCE("paranormal romance"),
    PICTURE_BOOK("picture book"), POETRY("poetry"), POLITICAL_THRILLER("political thriller"),
    THRILLER("thriller"), SUSPENSE("suspense"), SATIRE("satire");
    private String genreName;
    Genre(String genreName) {
        this.genreName=genreName;
    }
    @Override
    public String toString() {
        return genreName;
    }
}