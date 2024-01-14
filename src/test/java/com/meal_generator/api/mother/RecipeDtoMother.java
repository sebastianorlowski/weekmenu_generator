package com.meal_generator.api.mother;

import com.meal_generator.api.builder.RecipeDtoBuilder;
import com.meal_generator.api.dto.IngredientDto;

import java.util.List;

public class RecipeDtoMother {

    public static final String EXTERNAL_ID = "d37515eb-e5f1-4636-88f4-c169a1baf64b";
    public static final String NAME = "Spaghetti Bolognese";
    public static final Integer DAYS = 2;
    public static final List<IngredientDto> INGREDIENTS = List.of(
            IngredientDtoMother.complete()
                    .withName("Minced Meat")
                    .withWorth(400)
                    .withCountable(false)
                    .withDivisible(false)
                    .build(),
            IngredientDtoMother.complete()
                    .withName("Onion")
                    .withWorth(1000)
                    .withCountable(true)
                    .withDivisible(false)
                    .build(),
            IngredientDtoMother.complete()
                    .withName("Garlic")
                    .withWorth(2)
                    .withCountable(true)
                    .withDivisible(true)
                    .withExtraInfo("clove")
                    .build(),
            IngredientDtoMother.complete()
                    .withName("Carrot")
                    .withWorth(1)
                    .withCountable(true)
                    .withDivisible(false)
                    .build(),
            IngredientDtoMother.complete()
                    .withName("Tomato")
                    .withWorth(1000)
                    .withCountable(false)
                    .withDivisible(false)
                    .build(),
            IngredientDtoMother.complete()
                    .withName("Spaghetti")
                    .withWorth(400)
                    .withCountable(false)
                    .withDivisible(false)
                    .withExtraInfo("pasta")
                    .build()
    );
    public static final String INSTRUCTION = "" +
            "In a large pot over medium heat, heat the oil. Add the chopped onion and sauté until softened.\n" +
            "Add the garlic for about 1 minute until it releases its aroma.\n" +
            "Add the minced meat and cook, stirring, until evenly browned.\n" +
            "Add the diced carrot, continue cooking for a few minutes.\n" +
            "Add the canned diced tomatoes, tomato paste, oregano, basil, salt, and pepper. Stir well, reduce the heat, and simmer for about 20-30 minutes.\n" +
            "Meanwhile, cook the spaghetti according to the package instructions.\n" +
            "Once the spaghetti is cooked, drain it.\n" +
            "Serve the Bolognese sauce over the cooked spaghetti. You can sprinkle it with grated Parmesan and chopped fresh basil.";
    public static final Integer ESTIMATED_TIME = 30;

    public static RecipeDtoBuilder complete() {
        return new RecipeDtoBuilder()
                .withExternalId(EXTERNAL_ID)
                .withName(NAME)
                .withDays(DAYS)
                .withIngredients(INGREDIENTS)
                .withInstruction(INSTRUCTION)
                .withEstimatedTime(ESTIMATED_TIME);
    }
}
