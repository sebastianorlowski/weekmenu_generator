package com.meal_generator.service.mapper;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.repository.model.Meal;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE, uses = RecipeMapper.class)
public interface MealMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mealRecipes", ignore = true)
    Meal asMealEntity(MealDto mealDto);

    @Mapping(target = "id", source = "externalId")
    @Mapping(target = "recipes", source = "mealRecipes")
    MealDto asMealDto(Meal meal);

    default List<MealDto> asMealDtoList(List<Meal> mealList) {
        if (CollectionUtils.isEmpty(mealList)) {
            return Collections.emptyList();
        }
        return mealList.stream()
                .map(this::asMealDto)
                .toList();
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    @Mapping(target = "mealRecipes", ignore = true)
    Meal updateMeal(@MappingTarget Meal existingMeal, Meal meal);
}
