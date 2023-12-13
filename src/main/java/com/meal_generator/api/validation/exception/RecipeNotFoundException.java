package com.meal_generator.api.validation.exception;

public class RecipeNotFoundException extends RuntimeException {

    private String id;

    public RecipeNotFoundException(String message, String id) {
        super(String.format(message, id));
    }
}
