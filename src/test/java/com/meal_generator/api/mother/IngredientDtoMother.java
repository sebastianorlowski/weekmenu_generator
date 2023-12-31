package com.meal_generator.api.mother;

import com.meal_generator.api.builder.IngredientDtoBuilder;

public class IngredientDtoMother {

    public static final String NAME = "Tomato";
    public static final Integer WORTH = 500;
    public static final Boolean IS_COUNTABLE = true;
    public static final Boolean IS_DIVISIBLE = false;
    public static final String EXTRA_INFO = "cut into small cubes";

    public static IngredientDtoBuilder complete() {
        return new IngredientDtoBuilder()
                .withName(NAME)
                .withWorth(WORTH)
                .withCountable(IS_COUNTABLE)
                .withDivisible(IS_DIVISIBLE)
                .withExtraInfo(EXTRA_INFO);
    }
}
