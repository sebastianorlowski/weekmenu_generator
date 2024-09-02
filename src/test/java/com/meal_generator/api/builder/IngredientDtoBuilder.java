package com.meal_generator.api.builder;

import com.meal_generator.api.dto.IngredientDto;

public class IngredientDtoBuilder {

    private IngredientDto ingredientDto = new IngredientDto();

    public IngredientDtoBuilder withName(String name) {
        ingredientDto.setName(name);
        return this;
    }

    public IngredientDtoBuilder withExtraInfo(String extraInfo) {
        ingredientDto.setExtraInfo(extraInfo);
        return this;
    }

    public IngredientDtoBuilder withQuantity(Integer quantity) {
        ingredientDto.setQuantity(quantity);
        return this;
    }

    public IngredientDtoBuilder withUnit(String unit) {
        ingredientDto.setUnit(unit);
        return this;
    }

    public IngredientDto build() {
        return ingredientDto;
    }
}
