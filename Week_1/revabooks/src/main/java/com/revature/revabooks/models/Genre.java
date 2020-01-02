package com.revature.revabooks.models;

public enum Genre {

    FANTASY("Fantasy"), ADVENTURE("Adventure"), ROMANCE("Romance"), CONTEMPORARY("Contemporary"),
    DYSTOPIAN("Dystopian"), MYSTERY("Mystery"), HORROR("Horror"), THRILLER("Thriller"),
    HISTORICAL_FICTION("Historical Fiction"), SCIENCE_FICTION("Science Fiction"), COOKING("Cooking"),
    ART("Art"), PERSONAL_DEVELOPMENT("Personal Development"), SPIRITUAL("Spiritual"), BIOGRAPHY("Biography");

    private String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return genre;
    }

}
