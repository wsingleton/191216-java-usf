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
    THRILLER("thriller"), SUSPENSE("suspense"), SATIRE("satire"), TECHNICAL("technical"),
    ADVENTURE("adventure"), CONTEMPORARY("contemporary"), DYSTOPIAN("dystopian"),
    COOKING("cooking"),PERSONAL_DEVELOPMENT("personal development"), SPIRITUAL("spiritual"),
    OTHER("other");
    private String genreName;
    Genre(String genreName) {
        this.genreName=genreName;
    }
    @Override
    public String toString() {
        return genreName;
    }
    public static Genre getGenreById(int id) {
        Genre genre = null;
        switch (id) {
            case 1:
                genre = TECHNICAL;
                break;
            case 2:
                genre = FANTASY;
                break;
            case 3:
                genre = ADVENTURE;
                break;
            case 4:
                genre = ROMANCE;
                break;
            case 5:
                genre = CONTEMPORARY;
                break;
            case 6:
                genre = DYSTOPIAN;
                break;
            case 7:
                genre = MYSTERY;
                break;
            case 8:
                genre = HORROR;
                break;
            case 9:
                genre = THRILLER;
                break;
            case 10:
                genre = HISTORICAL_FICTION;
                break;
            case 11:
                genre = SCIENCE_FICTION;
                break;
            case 12:
                genre = COOKING;
                break;
            case 13:
                genre = ART;
                break;
            case 14:
                genre = PERSONAL_DEVELOPMENT;
                break;
            case 15:
                genre = SPIRITUAL;
                break;
            case 16:
                genre = BIOGRAPHY;
                break;
            default:
                genre = OTHER;
        }
        return genre;
    }
}