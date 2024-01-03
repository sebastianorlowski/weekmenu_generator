package com.meal_generator.api.validation;

public class MealDtoValidationMessage {

    public static final String MEAL_NAME_REQUIRED_ERROR = "The type of meal is required.";
    public static final String MEAL_START_AT_REQUIRED_ERROR = "Start at of meal is required.";
    public static final String MEAL_START_AT_PATTERN_ERROR = "Start at pattern is incorrect. Should be yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String OFFSET_DATE_TIME_REGEX_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
}
