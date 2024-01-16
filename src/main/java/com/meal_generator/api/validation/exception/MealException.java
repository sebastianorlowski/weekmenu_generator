package com.meal_generator.api.validation.exception;

public class MealException extends RuntimeException {

    private String name;

    public MealException(String message, String name) {
        super(String.format(message, name));
    }
}
