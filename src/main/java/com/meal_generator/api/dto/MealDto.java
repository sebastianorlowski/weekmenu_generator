package com.meal_generator.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

import static com.meal_generator.api.validation.MealDtoValidationMessage.*;

@Data
public class MealDto {

    private String id;

    @NotNull(message = MEAL_NAME_REQUIRED_ERROR)
    @Size(min = 3, max = 100, message = MEAL_NAME_LENGTH_ERROR)
    private String name;

    @NotNull(message = MEAL_START_AT_REQUIRED_ERROR)
    private OffsetDateTime startAt;

    private List<RecipeDto> recipes;
}
