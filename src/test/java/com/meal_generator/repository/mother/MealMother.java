package com.meal_generator.repository.mother;

import com.meal_generator.repository.builder.MealBuilder;
import com.meal_generator.repository.model.Recipe;

import java.time.OffsetDateTime;
import java.util.List;

public class MealMother {

    public static final String EXTERNAL_ID = "7aa10582-8d6e-4909-9823-d80c6cd33f00";
    public static final Long ID = 18L;
    public static final String NAME = "BREAKFAST";
    public static final OffsetDateTime START_AT = OffsetDateTime.parse("2023-12-19T07:00:00Z");
    public static final List<Recipe> RECIPES = List.of(RecipeMother.complete().build());

    public static MealBuilder complete() {
        return new MealBuilder()
                .withId(ID)
                .withExternalId(EXTERNAL_ID)
                .withName(NAME)
                .withStartAt(START_AT)
                .withRecipes(RECIPES);
    }
}
