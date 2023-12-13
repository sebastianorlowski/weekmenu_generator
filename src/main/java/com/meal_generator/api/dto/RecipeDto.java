package com.meal_generator.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

import static com.meal_generator.api.validation.RecipeDtoValidationMessage.*;

@Data
public class RecipeDto {

    private String externalId;

    @NotNull(message = RECIPE_NAME_REQUIRED_ERROR)
    @Size(min = 3, max = 100, message = RECIPE_NAME_LENGTH_ERROR)
    private String name;

    @Pattern(regexp = RECIPE_TYPE_REGEX_PATTERN,
            message = RECIPE_TYPE_PATTERN_ERROR,
            flags = Pattern.Flag.CASE_INSENSITIVE)
    @NotNull(message = RECIPE_TYPE_REQUIRED_ERROR)
    private String recipeType;

    @NotNull(message = RECIPE_DAYS_REQUIRED_ERROR)
    @Min(value = 1, message = RECIPE_DAYS_MIN_ERROR)
    @Max(value = 7, message = RECIPE_DAYS_MAX_ERROR)
    private Integer days;

    @NotEmpty(message = RECIPE_INGREDIENTS_REQUIRED_ERROR)
    @Valid
    private List<IngredientDto> ingredients;

    @NotNull(message = RECIPE_INSTRUCTION_REQUIRED_ERROR)
    @Size(min = 10, max = 10000, message = RECIPE_INSTRUCTION_LENGTH_ERROR)
    private String instruction;

    @NotNull(message = RECIPE_ESTIMATED_TIME_REQUIRED_ERROR)
    @Min(value = 5, message = RECIPE_ESTIMATED_TIME_MIN_ERROR)
    @Max(value = 1200, message = RECIPE_ESTIMATED_TIME_MAX_ERROR)
    private Integer estimatedTime;
}
