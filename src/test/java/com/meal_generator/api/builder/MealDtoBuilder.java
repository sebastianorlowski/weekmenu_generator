package com.meal_generator.api.builder;

import com.meal_generator.api.dto.MealDto;

import java.time.OffsetDateTime;

public class MealDtoBuilder {

    private MealDto mealDto = new MealDto();

    public MealDtoBuilder withExternalId(String externalId) {
        mealDto.setExternalId(externalId);
        return this;
    }

    public MealDtoBuilder withName(String name) {
        mealDto.setName(name);
        return this;
    }

    public MealDtoBuilder withStartAt(OffsetDateTime startAt) {
        mealDto.setStartAt(startAt);
        return this;
    }

    public MealDto build() {
        return mealDto;
    }
}
