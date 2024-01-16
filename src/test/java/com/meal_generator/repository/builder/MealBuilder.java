package com.meal_generator.repository.builder;

import com.meal_generator.repository.model.Meal;
import com.meal_generator.repository.model.Recipe;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;

public class MealBuilder {

    private Meal meal = new Meal();

    public MealBuilder withId(Long id) {
        meal.setId(id);
        return this;
    }

    public MealBuilder withExternalId(String externalId) {
        meal.setExternalId(externalId);
        return this;
    }

    public MealBuilder withName(String name) {
        meal.setName(name);
        return this;
    }

    public MealBuilder withStartAt(LocalTime startAt) {
        meal.setStartAt(startAt);
        return this;
    }

    public MealBuilder withRecipes(List<Recipe> recipes) {
        meal.setMealRecipes(recipes);
        return this;
    }

    public Meal build() {
        return meal;
    }
}
