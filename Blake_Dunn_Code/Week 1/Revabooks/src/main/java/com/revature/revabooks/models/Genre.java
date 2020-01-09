package com.revature.revabooks.models;

public enum Genre {

    TECHNICAL("Technical"), FANTASY("Fantasy"), ADVENTURE("Adventure"), ROMANCE("Romance"), CONTEMPORARY("Contemporary"),
    DYSTOPIAN("Dystopian"), MYSTERY("Mystery"), HORROR("Horror"), THRILLER("Thriller"),
    HISTORICAL_FICTION("Historical Fiction"), SCIENCE_FICTION("Science Fiction"), COOKING("Cooking"),
    ART("Art"), PERSONAL_DEVELOPMENT("Personal Development"), SPIRITUAL("Spiritual"), BIOGRAPHY("Biography"), OTHER("Other");

    private String genre;
    private Genre(String genre) {
        this.genre = genre;
    }
    @Override
    public String toString() {
        return genre;
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
