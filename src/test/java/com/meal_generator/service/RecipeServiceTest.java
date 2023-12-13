package com.meal_generator.service;

import com.meal_generator.api.validation.exception.RecipeNotFoundException;
import com.meal_generator.repository.RecipeRepository;
import com.meal_generator.repository.model.Recipe;
import com.meal_generator.repository.mother.RecipeMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.meal_generator.api.validation.RecipeDtoValidationMessage.RECIPE_NOT_FOUND_ERROR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeService recipeService;

    @Test
    void shouldFindRecipeByExternalId() {
        Recipe recipe = RecipeMother.complete().build();
        when(recipeRepository.findRecipeByExternalId(RecipeMother.EXTERNAL_ID))
                .thenReturn(Optional.of(recipe));

        Optional<Recipe> result = recipeService.findRecipeByExternalId(RecipeMother.EXTERNAL_ID);

        assertThat(result).hasValue(recipe);
    }

    @Test
    void shouldGetRecipeByExternalId() {
        Recipe recipe = RecipeMother.complete().build();
        when(recipeRepository.findRecipeByExternalId(RecipeMother.EXTERNAL_ID))
                .thenReturn(Optional.of(recipe));

        Recipe result = recipeService.getRecipeByExternalId(RecipeMother.EXTERNAL_ID);

        assertThat(result).isEqualTo(recipe);
    }

    @Test
    void shouldNotFindRecipeByExternalId() {
        when(recipeRepository.findRecipeByExternalId(RecipeMother.EXTERNAL_ID))
                .thenReturn(Optional.empty());

        Optional<Recipe> result = recipeService.findRecipeByExternalId(RecipeMother.EXTERNAL_ID);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldThrowExceptionWhenRecipeNotFoundByExternalId() {
        when(recipeRepository.findRecipeByExternalId(RecipeMother.EXTERNAL_ID))
                .thenReturn(Optional.empty());

        RecipeNotFoundException exception = assertThrows(RecipeNotFoundException.class, () ->
                recipeService.getRecipeByExternalId(RecipeMother.EXTERNAL_ID));

        assertThat(exception.getMessage()).isEqualTo(String.format(RECIPE_NOT_FOUND_ERROR, RecipeMother.EXTERNAL_ID));
    }
}