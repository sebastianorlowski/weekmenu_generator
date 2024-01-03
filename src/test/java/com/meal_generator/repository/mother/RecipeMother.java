package com.meal_generator.repository.mother;

import com.meal_generator.repository.builder.RecipeBuilder;
import com.meal_generator.repository.model.Ingredient;
import com.meal_generator.repository.model.Meal;

import java.util.List;

public class RecipeMother {

    public static final Long ID = 6L;
    public static final String EXTERNAL_ID = "ed1cfd2d-a7ed-4ca0-bc57-47c764d2eda0";
    public static final String NAME = "Spaghetti Bolognese";
    public static final Integer DAYS = 2;
    public static final List<Ingredient> INGREDIENTS = List.of(
            IngredientMother.complete()
                    .withName("Minced Meat")
                    .withWorth(400)
                    .withCountable(false)
                    .withDivisible(false)
                    .build(),
            IngredientMother.complete()
                    .withName("Onion")
                    .withWorth(1000)
                    .withCountable(true)
                    .withDivisible(false)
                    .build(),
            IngredientMother.complete()
                    .withName("Garlic")
                    .withWorth(2)
                    .withCountable(true)
                    .withDivisible(true)
                    .withExtraInfo("clove")
                    .build(),
            IngredientMother.complete()
                    .withName("Carrot")
                    .withWorth(1)
                    .withCountable(true)
                    .withDivisible(false)
                    .build(),
            IngredientMother.complete()
                    .withName("Tomato")
                    .withWorth(1000)
                    .withCountable(false)
                    .withDivisible(false)
                    .build(),
            IngredientMother.complete()
                    .withName("Spaghetti")
                    .withWorth(400)
                    .withCountable(false)
                    .withDivisible(false)
                    .withExtraInfo("pasta")
                    .build()
    );
    public static final String INSTRUCTION =
            "In a large pot over medium heat, heat the oil. Add the chopped onion and sauté until softened.\n" +
            "Add the garlic for about 1 minute until it releases its aroma.\n" +
            "Add the minced meat and cook, stirring, until evenly browned.\n" +
            "Add the diced carrot, continue cooking for a few minutes.\n" +
            "Add the canned diced tomatoes, tomato paste, oregano, basil, salt, and pepper. Stir well, reduce the heat, and simmer for about 20-30 minutes.\n" +
            "Meanwhile, cook the spaghetti according to the package instructions.\n" +
            "Once the spaghetti is cooked, drain it.\n" +
            "Serve the Bolognese sauce over the cooked spaghetti. You can sprinkle it with grated Parmesan and chopped fresh basil.";
    public static final Integer ESTIMATED_TIME = 30;
    public static final List<Meal> MEALS = List.of(MealMother.complete().build());

    public static RecipeBuilder complete() {
        return new RecipeBuilder()
                .withId(ID)
                .withExternalId(EXTERNAL_ID)
                .withName(NAME)
                .withDays(DAYS)
                .withIngredients(INGREDIENTS)
                .withInstruction(INSTRUCTION)
                .withEstimatedTime(ESTIMATED_TIME)
                .withMeal(MEALS);
    }
}
