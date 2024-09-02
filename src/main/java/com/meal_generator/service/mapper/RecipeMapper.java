package com.meal_generator.service.mapper;

import com.meal_generator.api.dto.RecipeDto;
import com.meal_generator.repository.model.Recipe;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE)
public interface RecipeMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    Recipe asRecipeEntity(RecipeDto recipeDto);

    @Mapping(target = "id", source = "externalId")
    RecipeDto asRecipeDto(Recipe recipe);

    default List<RecipeDto> asRecipeDtoList(List<Recipe> recipeList) {
        if (CollectionUtils.isEmpty(recipeList)) {
            return Collections.emptyList();
        }
        return recipeList.stream()
                .map(this::asRecipeDto)
                .toList();
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "externalId", ignore = true)
    Recipe updateRecipe(@MappingTarget Recipe existingRecipe, Recipe recipe);
}
