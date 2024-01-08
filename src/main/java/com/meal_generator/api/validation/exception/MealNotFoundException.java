package com.meal_generator.api.validation.exception;

public class MealNotFoundException extends RuntimeException {

    private String id;

    public MealNotFoundException(String message, String id) {
        super(String.format(message, id));
    }
}
