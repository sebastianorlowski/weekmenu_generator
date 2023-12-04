package com.meal_generator.api.dto;

import com.meal_generator.repository.model.enums.MealType;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MealDto {

    @NotBlank(message = "Name cannot be empty.")
    @NotNull(message = "Name is required.")
    private String name;

    private MealType mealType;

    @Min(value = 1, message = "Minimum days must be 1.")
    @Max(value = 2, message = "Maximum days must be 2.")
    private int days;

    @NotEmpty(message = "You must provide ingredients.")
    private List<IngredientDto> ingredients;
}
