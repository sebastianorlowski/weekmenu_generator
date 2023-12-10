package com.meal_generator.api.mother;

import com.meal_generator.api.builder.MealDtoBuilder;
import com.meal_generator.api.dto.IngredientDto;
import com.meal_generator.repository.model.enums.MealType;

import java.util.List;

public class MealDtoMother {

    private static final String NAME = "Spaghetti Bolognese";
    private static final String MEAL_TYPE = MealType.DINNER.name();
    private static final Integer DAYS = 2;
    private static final List<IngredientDto> INGREDIENTS = List.of(
            IngredientDtoMother.complete()
                    .withName("Minced Meat")
                    .withValue(0.4)
                    .withCountable(false)
                    .withDivisible(false)
                    .build(),
            IngredientDtoMother.complete()
                    .withName("Onion")
                    .withValue(1.0)
                    .withCountable(true)
                    .withDivisible(false)
                    .build(),
            IngredientDtoMother.complete()
                    .withName("Garlic")
                    .withValue(2.0)
                    .withCountable(true)
                    .withDivisible(true)
                    .build(),
            IngredientDtoMother.complete()
                    .withName("Carrot")
                    .withValue(1.0)
                    .withCountable(true)
                    .withDivisible(false)
                    .build(),
            IngredientDtoMother.complete()
                    .withName("Tomato")
                    .withValue(1.0)
                    .withCountable(false)
                    .withDivisible(false)
                    .build(),
            IngredientDtoMother.complete()
                    .withName("Spaghetti")
                    .withValue(0.4)
                    .withCountable(false)
                    .withDivisible(false)
                    .build()
    );
    private static final String INSTRUCTION = "" +
            "In a large pot over medium heat, heat the oil. Add the chopped onion and sauté until softened.\n" +
            "Add the garlic for about 1 minute until it releases its aroma.\n" +
            "Add the minced meat and cook, stirring, until evenly browned.\n" +
            "Add the diced carrot, continue cooking for a few minutes.\n" +
            "Add the canned diced tomatoes, tomato paste, oregano, basil, salt, and pepper. Stir well, reduce the heat, and simmer for about 20-30 minutes.\n" +
            "Meanwhile, cook the spaghetti according to the package instructions.\n" +
            "Once the spaghetti is cooked, drain it.\n" +
            "Serve the Bolognese sauce over the cooked spaghetti. You can sprinkle it with grated Parmesan and chopped fresh basil.";
    private static final Integer ESTIMATED_TIME = 30;

    public static MealDtoBuilder complete() {
        return new MealDtoBuilder()
                .withName(NAME)
                .withMealType(MEAL_TYPE)
                .withDays(DAYS)
                .withIngredients(INGREDIENTS)
                .withInstruction(INSTRUCTION)
                .withEstimatedTime(ESTIMATED_TIME);
    }
}
