package com.meal_generator.api.builder;

import com.meal_generator.api.dto.IngredientDto;
import com.meal_generator.api.dto.RecipeDto;

import java.util.List;

public class RecipeDtoBuilder {

    private RecipeDto recipeDto = new RecipeDto();

    public RecipeDtoBuilder withExternalId(String externalId) {
        recipeDto.setExternalId(externalId);
        return this;
    }

    public RecipeDtoBuilder withName(String name) {
        recipeDto.setName(name);
        return this;
    }

    public RecipeDtoBuilder withDays(Integer days) {
        recipeDto.setDays(days);
        return this;
    }

    public RecipeDtoBuilder withIngredients(List<IngredientDto> ingredients) {
        recipeDto.setIngredients(ingredients);
        return this;
    }

    public RecipeDtoBuilder withInstruction(String instruction) {
        recipeDto.setInstruction(instruction);
        return this;
    }


    public RecipeDtoBuilder withEstimatedTime(Integer estimatedTime) {
        recipeDto.setEstimatedTime(estimatedTime);
        return this;
    }


    public RecipeDto build() {
        return recipeDto;
    }
}
