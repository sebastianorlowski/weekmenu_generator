package com.meal_generator.api.mother;

import com.meal_generator.api.builder.IngredientDtoBuilder;

public class IngredientDtoMother {

    private static final String NAME = "";
    private static final Double VALUE = 5.0;
    private static final Boolean IS_COUNTABLE = true;
    private static final Boolean IS_DIVISIBLE = false;

    public static IngredientDtoBuilder complete() {
        return new IngredientDtoBuilder()
                .withName(NAME)
                .withValue(VALUE)
                .withCountable(IS_COUNTABLE)
                .withDivisible(IS_DIVISIBLE);
    }
}
