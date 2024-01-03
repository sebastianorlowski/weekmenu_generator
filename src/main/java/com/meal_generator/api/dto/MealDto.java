package com.meal_generator.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.OffsetDateTime;

import static com.meal_generator.api.validation.MealDtoValidationMessage.*;
import static com.meal_generator.api.validation.RecipeDtoValidationMessage.*;

@Data
public class MealDto {

    private String externalId;

    @NotNull(message = MEAL_NAME_REQUIRED_ERROR)
    @Size(min = 3, max = 100, message = RECIPE_NAME_LENGTH_ERROR)
    private String name;

    @Pattern(regexp = OFFSET_DATE_TIME_REGEX_PATTERN,
            message = MEAL_START_AT_PATTERN_ERROR,
            flags = Pattern.Flag.CASE_INSENSITIVE)
    @NotNull(message = MEAL_START_AT_REQUIRED_ERROR)
    private OffsetDateTime startAt;
}
