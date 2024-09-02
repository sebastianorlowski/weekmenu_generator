package com.meal_generator.api.mother;

import com.meal_generator.api.builder.IngredientDtoBuilder;

public class IngredientDtoMother {

    public static final String NAME = "Tomato";
    public static final Integer QUANTITY = 500;
    public static final String UNIT = "KG";
    public static final String EXTRA_INFO = "cut into small cubes";

    public static IngredientDtoBuilder complete() {
        return new IngredientDtoBuilder()
                .withQuantity(QUANTITY)
                .withUnit(UNIT)
                .withName(NAME)
                .withExtraInfo(EXTRA_INFO);
    }
}
