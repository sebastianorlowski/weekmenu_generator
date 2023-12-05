package com.meal_generator.service.mapper;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.repository.model.Meal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MealMapper {

    Meal asMealEntity(MealDto mealDto);

    MealDto asMealDto(Meal meal);
}
