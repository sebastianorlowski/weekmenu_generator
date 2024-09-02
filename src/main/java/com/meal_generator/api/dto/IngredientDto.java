package com.meal_generator.api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import static com.meal_generator.api.validation.RecipeDtoValidationMessage.*;

@Data
public class IngredientDto {

    @NotNull(message = RECIPE_INGREDIENT_NAME_REQUIRED_ERROR)
    @Size(min = 3, max = 100, message = RECIPE_INGREDIENT_NAME_LENGTH_ERROR)
    private String name;

    @NotNull(message = RECIPE_INGREDIENT_QUANTITY_REQUIRED_ERROR)
    @Min(value = 0, message = RECIPE_INGREDIENT_QUANTITY_MIN_ERROR)
    @Max(value = 1000000, message = RECIPE_INGREDIENT_QUANTITY_MAX_ERROR)
    private Integer quantity;

    @NotNull(message = RECIPE_INGREDIENT_UNIT_REQUIRED_ERROR)
    @Size(min = 1, max = 100, message = RECIPE_INGREDIENT_UNIT_LENGTH_ERROR)
    private String unit;

    @Size(max = 1000, message = RECIPE_INGREDIENT_EXTRA_INFO_LENGTH_ERROR)
    private String extraInfo;
}
