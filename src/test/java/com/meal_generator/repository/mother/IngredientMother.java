package com.meal_generator.repository.mother;

import com.meal_generator.repository.builder.IngredientBuilder;

public class IngredientMother {

    public static final String NAME = "Tomato";
    public static final Integer WORTH = 500;
    public static final Boolean IS_COUNTABLE = true;
    public static final Boolean IS_DIVISIBLE = false;
    public static final String EXTRA_INFO = "cut into small cubes";

    public static IngredientBuilder complete() {
        return new IngredientBuilder()
                .withName(NAME)
                .withWorth(WORTH)
                .withCountable(IS_COUNTABLE)
                .withDivisible(IS_DIVISIBLE)
                .withExtraInfo(EXTRA_INFO);
    }
}
