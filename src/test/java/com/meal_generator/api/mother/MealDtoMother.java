package com.meal_generator.api.mother;

import com.meal_generator.api.builder.MealDtoBuilder;
import com.meal_generator.api.dto.RecipeDto;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;

public class MealDtoMother {

    public static final String NAME = "dinner";
    public static final String EXTERNAL_ID = "528155ff-be7c-4cf5-aea6-4a55dee6061f";
    public static final LocalTime START_AT = LocalTime.parse("15:30");
    public static final List<RecipeDto> RECIPES = List.of(RecipeDtoMother.complete().build());

    public static MealDtoBuilder complete() {
        return new MealDtoBuilder()
                .withExternalId(EXTERNAL_ID)
                .withName(NAME)
                .withStartAt(START_AT)
                .withRecipes(RECIPES);
    }
}
