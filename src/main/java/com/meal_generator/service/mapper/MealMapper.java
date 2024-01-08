package com.meal_generator.service.mapper;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.repository.model.Meal;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface MealMapper {

    Meal asEntity(MealDto mealDto);

    MealDto asDto(Meal meal);
}
