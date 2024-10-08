package com.meal_generator.repository.builder;

import com.meal_generator.repository.model.Ingredient;

public class IngredientBuilder {

    private Ingredient ingredient = new Ingredient();

    public IngredientBuilder withId(Long id) {
        ingredient.setId(id);
        return this;
    }

    public IngredientBuilder withName(String name) {
        ingredient.setName(name);
        return this;
    }

    public IngredientBuilder withExtraInfo(String extraInfo) {
        ingredient.setExtraInfo(extraInfo);
        return this;
    }

    public Ingredient build() {
        return ingredient;
    }
}
