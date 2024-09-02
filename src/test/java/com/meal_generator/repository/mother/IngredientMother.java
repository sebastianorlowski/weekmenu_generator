package com.meal_generator.repository.mother;

import com.meal_generator.repository.builder.IngredientBuilder;

public class IngredientMother {

    public static final Long ID = 981L;
    public static final String NAME = "Tomato";
    public static final String EXTRA_INFO = "cut into small cubes";

    public static IngredientBuilder complete() {
        return new IngredientBuilder()
                .withId(ID)
                .withName(NAME)
                .withExtraInfo(EXTRA_INFO);
    }
}
