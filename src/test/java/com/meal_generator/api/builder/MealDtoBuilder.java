package com.meal_generator.api.builder;

import com.meal_generator.api.dto.IngredientDto;
import com.meal_generator.api.dto.MealDto;
import com.meal_generator.repository.model.enums.MealType;

import java.util.List;

public class MealDtoBuilder {

    private MealDto mealDto = new MealDto();

    public MealDtoBuilder withName(String name) {
        mealDto.setName(name);
        return this;
    }

    public MealDtoBuilder withMealType(MealType mealType) {
        mealDto.setMealType(mealType);
        return this;
    }

    public MealDtoBuilder withDays(Integer days) {
        mealDto.setDays(days);
        return this;
    }

    public MealDtoBuilder withIngredients(List<IngredientDto> ingredients) {
        mealDto.setIngredients(ingredients);
        return this;
    }

    public MealDtoBuilder withInstruction(String instruction) {
        mealDto.setInstruction(instruction);
        return this;
    }


    public MealDtoBuilder withEstimatedTime(Integer estimatedTime) {
        mealDto.setEstimatedTime(estimatedTime);
        return this;
    }


    public MealDto build() {
        return mealDto;
    }
}
