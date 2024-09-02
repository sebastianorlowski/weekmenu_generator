package com.meal_generator.api.validation;

public class MealDtoValidationMessage {

    /** 400 **/
    public static final String MEAL_NAME_REQUIRED_ERROR = "Meal name is required.";
    public static final String MEAL_NAME_EXISTS_ERROR = "Meal with name %s already exists.";
    public static final String MEAL_NAME_LENGTH_ERROR = "The name of the meal should be between 3 and 100 characters.";
    public static final String MEAL_START_AT_REQUIRED_ERROR = "Start at of meal is required.";
    public static final String MEAL_NAMES_NOT_EXISTS_ERROR = "Meal with names [%s] does not exist.";
    public static final String MEAL_NAMES_REQUIRED_ERROR = "At least one meal name must be specified.";

    /** 404 **/
    public static final String MEAL_NOT_FOUND_ERROR = "Meal with %s id not found.";
}
