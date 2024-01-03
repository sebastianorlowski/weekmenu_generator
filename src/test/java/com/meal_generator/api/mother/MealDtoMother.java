package com.meal_generator.api.mother;

import com.meal_generator.api.builder.MealDtoBuilder;

import java.time.OffsetDateTime;

public class MealDtoMother {

    public static final String NAME = "spaghetti";
    public static final String EXTERNAL_ID = "528155ff-be7c-4cf5-aea6-4a55dee6061f";
    public static final OffsetDateTime START_AT = OffsetDateTime.parse("2023-12-23T19:00:00Z");

    public static MealDtoBuilder complete() {
        return new MealDtoBuilder()
                .withExternalId(EXTERNAL_ID)
                .withName(NAME)
                .withStartAt(START_AT);
    }
}
