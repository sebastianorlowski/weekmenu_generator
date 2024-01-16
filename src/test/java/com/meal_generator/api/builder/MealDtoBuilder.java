package com.meal_generator.api.builder;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.dto.RecipeDto;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;

public class MealDtoBuilder {

    private MealDto mealDto = new MealDto();

    public MealDtoBuilder withExternalId(String externalId) {
        mealDto.setId(externalId);
        return this;
    }

    public MealDtoBuilder withName(String name) {
        mealDto.setName(name);
        return this;
    }

    public MealDtoBuilder withStartAt(LocalTime startAt) {
        mealDto.setStartAt(startAt);
        return this;
    }

    public MealDtoBuilder withRecipes(List<RecipeDto> recipes) {
        mealDto.setRecipes(recipes);
        return this;
    }

    public MealDto build() {
        return mealDto;
    }
}
