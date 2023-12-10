package com.meal_generator.api.dto;

import com.meal_generator.repository.model.enums.MealType;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class MealDto {

    @NotNull(message = "Meal name is required.")
    @Size(min = 3, max = 100, message = "The name of the meal should be between 3 and 100 characters.")
    private String name;

    @Pattern(regexp = "BREAKFAST|LUNCH|DINNER|EVENING_MEAL",
            message = "The meal type must match breakfast, lunch, dinner, evening_meal.",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    @NotNull(message = "The type of meal is required.")
    private String mealType;

    @NotNull(message = "Meal days are required.")
    @Min(value = 1, message = "The minimum number of meal days must be 1.")
    @Max(value = 7, message = "The maximum number of meal days must be 7.")
    private Integer days;

    @NotEmpty(message = "You must provide the ingredients for the meal.")
    private List<IngredientDto> ingredients;

    @NotNull(message = "The meal instructions must not be empty.")
    @Size(min = 10, max = 10000, message = "Meal instructions should be between 10 and 10000 characters.")
    private String instruction;

    @NotNull(message = "Estimated meal times are required.")
    @Min(value = 5, message = "The minimum estimated meal time must be 5 minutes.")
    @Max(value = 1200, message = "The maximum estimated meal time must be 1200 minutes.")
    private Integer estimatedTime;
}
