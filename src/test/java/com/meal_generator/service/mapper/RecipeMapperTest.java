package com.meal_generator.service.mapper;

import com.meal_generator.api.dto.RecipeDto;
import com.meal_generator.api.mother.IngredientDtoMother;
import com.meal_generator.api.mother.MealDtoMother;
import com.meal_generator.api.mother.RecipeDtoMother;
import com.meal_generator.repository.model.Recipe;
import com.meal_generator.repository.mother.IngredientMother;
import com.meal_generator.repository.mother.MealMother;
import com.meal_generator.repository.mother.RecipeMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecipeMapperTest {

    @InjectMocks
    private RecipeMapper mapper = Mappers.getMapper(RecipeMapper.class);

    @Test
    void shouldMapRecipeAsEntity() {
        RecipeDto recipeDto = RecipeDtoMother.complete()
                .withIngredients(List.of(IngredientDtoMother.complete().build()))
                .build();

        Recipe result = mapper.asRecipeEntity(recipeDto);

        assertThat(result.getId()).isNull();
        assertThat(result.getExternalId()).isNull();
        assertThat(result.getDays()).isEqualTo(RecipeDtoMother.DAYS);
        assertThat(result.getInstruction()).isEqualTo(RecipeDtoMother.INSTRUCTION);
        assertThat(result.getEstimatedTime()).isEqualTo(RecipeDtoMother.ESTIMATED_TIME);
        assertThat(result.getIngredients()).singleElement().satisfies(ingredient -> {
            assertThat(ingredient.getName()).isEqualTo(IngredientDtoMother.NAME);
            assertThat(ingredient.getWorth()).isEqualTo(IngredientDtoMother.WORTH);
            assertThat(ingredient.getIsCountable()).isEqualTo(IngredientDtoMother.IS_COUNTABLE);
            assertThat(ingredient.getIsDivisible()).isEqualTo(IngredientDtoMother.IS_DIVISIBLE);
            assertThat(ingredient.getExtraInfo()).isEqualTo(IngredientDtoMother.EXTRA_INFO);
        });
        assertThat(result.getDailyList()).isNull();
    }

    @Test
    void shouldMapRecipeAsDto() {
        Recipe recipe = RecipeMother.complete()
                .withIngredients(List.of(IngredientMother.complete().build()))
                .build();

        RecipeDto result = mapper.asRecipeDto(recipe);

        assertThat(result.getId()).isEqualTo(RecipeMother.EXTERNAL_ID);
        assertThat(result.getDays()).isEqualTo(RecipeMother.DAYS);
        assertThat(result.getInstruction()).isEqualTo(RecipeMother.INSTRUCTION);
        assertThat(result.getEstimatedTime()).isEqualTo(RecipeMother.ESTIMATED_TIME);
        assertThat(result.getIngredients()).singleElement().satisfies(ingredient -> {
            assertThat(ingredient.getName()).isEqualTo(IngredientMother.NAME);
            assertThat(ingredient.getWorth()).isEqualTo(IngredientMother.WORTH);
            assertThat(ingredient.getIsCountable()).isEqualTo(IngredientMother.IS_COUNTABLE);
            assertThat(ingredient.getIsDivisible()).isEqualTo(IngredientMother.IS_DIVISIBLE);
            assertThat(ingredient.getExtraInfo()).isEqualTo(IngredientMother.EXTRA_INFO);
        });
    }

    @Test
    void shouldUpdateRecipe() {
        final int days = 5;
        final String instruction = "test_instruction";
        final String ingredientName = "potatoe";
        final boolean isCountable = false;
        Recipe existingRecipe = RecipeMother.complete()
                .withIngredients(List.of(IngredientMother.complete().build()))
                .build();
        Recipe recipeUpdate = RecipeMother.complete()
                .withDays(5)
                .withInstruction("test_instruction")
                .withIngredients(List.of(IngredientMother.complete()
                        .withCountable(false)
                        .withName("potatoe")
                        .build()))
                .build();

        Recipe result = mapper.updateRecipe(existingRecipe, recipeUpdate);

        assertThat(result.getId()).isEqualTo(RecipeMother.ID);
        assertThat(result.getExternalId()).isEqualTo(RecipeMother.EXTERNAL_ID);
        assertThat(result.getDays()).isEqualTo(days);
        assertThat(result.getInstruction()).isEqualTo(instruction);
        assertThat(result.getEstimatedTime()).isEqualTo(RecipeMother.ESTIMATED_TIME);
        assertThat(result.getIngredients()).singleElement().satisfies(ingredient -> {
            assertThat(ingredient.getName()).isEqualTo(ingredientName);
            assertThat(ingredient.getWorth()).isEqualTo(IngredientMother.WORTH);
            assertThat(ingredient.getIsCountable()).isEqualTo(isCountable);
            assertThat(ingredient.getIsDivisible()).isEqualTo(IngredientMother.IS_DIVISIBLE);
            assertThat(ingredient.getExtraInfo()).isEqualTo(IngredientMother.EXTRA_INFO);
        });
        assertThat(result.getDailyList()).isNull();
        assertThat(result.getMealRecipes()).singleElement().satisfies(recipe -> {
            assertThat(recipe.getStartAt()).isEqualTo(MealMother.START_AT);
            assertThat(recipe.getName()).isEqualTo(MealMother.NAME);
        });
    }
}