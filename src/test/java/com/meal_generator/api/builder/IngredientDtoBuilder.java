package com.meal_generator.api.builder;

import com.meal_generator.api.dto.IngredientDto;

public class IngredientDtoBuilder {

    private IngredientDto ingredientDto = new IngredientDto();

    public IngredientDtoBuilder withName(String name) {
        ingredientDto.setName(name);
        return this;
    }

    public IngredientDtoBuilder withWorth(Integer worth) {
        ingredientDto.setWorth(worth);
        return this;
    }

    public IngredientDtoBuilder withCountable(Boolean isCountable) {
        ingredientDto.setIsCountable(isCountable);
        return this;
    }

    public IngredientDtoBuilder withDivisible(Boolean isDivisible) {
        ingredientDto.setIsDivisible(isDivisible);
        return this;
    }

    public IngredientDtoBuilder withExtraInfo(String extraInfo) {
        ingredientDto.setExtraInfo(extraInfo);
        return this;
    }

    public IngredientDto build() {
        return ingredientDto;
    }
}
