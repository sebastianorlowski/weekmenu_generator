package com.meal_generator.repository.mother;

import com.meal_generator.repository.builder.MealBuilder;
import com.meal_generator.repository.model.Recipe;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;

public class MealMother {

    public static final String EXTERNAL_ID = "7aa10582-8d6e-4909-9823-d80c6cd33f00";
    public static final Long ID = 18L;
    public static final String NAME = "BREAKFAST";
    public static final LocalTime START_AT = LocalTime.parse("16:00");

    public static MealBuilder complete() {
        return new MealBuilder()
                .withId(ID)
                .withExternalId(EXTERNAL_ID)
                .withName(NAME)
                .withStartAt(START_AT);
    }
}
