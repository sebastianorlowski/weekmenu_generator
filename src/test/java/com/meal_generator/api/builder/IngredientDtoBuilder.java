package com.meal_generator.api.builder;

import com.meal_generator.api.dto.IngredientDto;

public class IngredientDtoBuilder {

    private IngredientDto ingredientDto = new IngredientDto();

    public IngredientDtoBuilder withName(String name) {
        ingredientDto.setName(name);
        return this;
    }

    public IngredientDtoBuilder withValue(Double value) {
        ingredientDto.setValue(value);
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

    public IngredientDto build() {
        return ingredientDto;
    }
}
