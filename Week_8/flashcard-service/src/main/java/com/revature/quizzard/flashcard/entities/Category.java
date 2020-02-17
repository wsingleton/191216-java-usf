package com.revature.quizzard.flashcard.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public enum Category {

    JAVA, JAVASCRIPT, SQL, JDBC, SERVLETS, HTML, CSS,
    REACT, REDUX, HIBERNATE, SPRING, WEB_SERVICES,
    MICROSERVICES, AWS, DOCKER;
}
