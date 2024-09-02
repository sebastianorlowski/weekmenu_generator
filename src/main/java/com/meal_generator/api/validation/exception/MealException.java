package com.meal_generator.api.validation.exception;

public class MealException extends RuntimeException {

    private String name;

    public MealException(String message, String... names) {
        super(String.format(message, names));
    }

    public MealException(String message) {
        super(message);
    }
}
