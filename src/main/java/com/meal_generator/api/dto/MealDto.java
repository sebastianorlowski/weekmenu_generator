package com.meal_generator.api.dto;

import com.meal_generator.repository.model.enums.MealType;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class MealDto {

    @NotBlank(message = "Name cannot be empty.")
    @NotNull(message = "Name is required.")
    private String name;

    private MealType mealType;

    @Min(value = 1, message = "Minimum days must be 1.")
    @Max(value = 2, message = "Maximum days must be 2.")
    private Integer days;

    @NotEmpty(message = "You must provide ingredients.")
    private List<IngredientDto> ingredients;

    @NotBlank(message = "Instruction cannot be empty.")
    @Size(min = 10, max = 10000, message = "Instruction should be between 10 and 1000 characters.")
    private String instruction;

    @Min(value = 5, message = "Minimum estimated minutes must be 5.")
    @Max(value = 1200, message = "Maximum estimated minutes must be 1200.")
    private Integer estimatedTime;
}
