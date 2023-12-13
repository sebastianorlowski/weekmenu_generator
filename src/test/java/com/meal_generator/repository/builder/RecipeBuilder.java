package com.meal_generator.repository.builder;

import com.meal_generator.api.builder.RecipeDtoBuilder;
import com.meal_generator.api.dto.RecipeDto;
import com.meal_generator.repository.model.Ingredient;
import com.meal_generator.repository.model.Recipe;
import com.meal_generator.repository.model.enums.RecipeType;

import java.util.List;

public class RecipeBuilder {

    private Recipe recipe = new Recipe();

    public RecipeBuilder withId(Long id) {
        recipe.setId(id);
        return this;
    }

    public RecipeBuilder withExternalId(String externalId) {
        recipe.setExternalId(externalId);
        return this;
    }

    public RecipeBuilder withName(String name) {
        recipe.setName(name);
        return this;
    }

    public RecipeBuilder withRecipeType(RecipeType recipeType) {
        recipe.setRecipeType(recipeType);
        return this;
    }

    public RecipeBuilder withDays(Integer days) {
        recipe.setDays(days);
        return this;
    }

    public RecipeBuilder withIngredients(List<Ingredient> ingredients) {
        recipe.setIngredients(ingredients);
        return this;
    }

    public RecipeBuilder withInstruction(String instruction) {
        recipe.setInstruction(instruction);
        return this;
    }


    public RecipeBuilder withEstimatedTime(Integer estimatedTime) {
        recipe.setEstimatedTime(estimatedTime);
        return this;
    }


    public Recipe build() {
        return recipe;
    }
}
