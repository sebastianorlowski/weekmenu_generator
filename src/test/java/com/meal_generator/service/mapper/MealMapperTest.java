package com.meal_generator.service.mapper;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.mother.MealDtoMother;
import com.meal_generator.repository.model.Meal;
import com.meal_generator.repository.model.Recipe;
import com.meal_generator.repository.mother.IngredientMother;
import com.meal_generator.repository.mother.MealMother;
import com.meal_generator.repository.mother.RecipeMother;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;

import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MealMapperTest {

    @InjectMocks
    private MealMapper mapper = Mappers.getMapper(MealMapper.class);

    @Test
    void shouldMapMealAsEntity() {
        MealDto meal = MealDtoMother.complete().build();

        Meal result = mapper.asMealEntity(meal);

        assertThat(result.getId()).isNull();
        assertThat(result.getExternalId()).isNull();
        assertThat(result.getName()).isEqualTo(MealDtoMother.NAME);
        assertThat(result.getStartAt()).isEqualTo(MealDtoMother.START_AT);
        assertThat(result.getMealRecipes()).isNull();
    }

    @Test
    void shouldMapRecipeAsDto() {
        Recipe recipe = RecipeMother.complete()
                .withIngredients(List.of(IngredientMother.complete().build()))
                .build();
        Meal meal = MealMother.complete()
                .withRecipes(List.of(recipe))
                .build();

        MealDto result = mapper.asMealDto(meal);

        assertThat(result.getId()).isEqualTo(MealMother.EXTERNAL_ID);
        assertThat(result.getName()).isEqualTo(MealMother.NAME);
        assertThat(result.getStartAt()).isEqualTo(MealMother.START_AT);
        assertThat(result.getRecipes()).singleElement().satisfies(recipeElement -> {
            assertThat(recipeElement.getId()).isEqualTo(RecipeMother.EXTERNAL_ID);
            assertThat(recipeElement.getDays()).isEqualTo(RecipeMother.DAYS);
            assertThat(recipeElement.getInstruction()).isEqualTo(RecipeMother.INSTRUCTION);
            assertThat(recipeElement.getEstimatedTime()).isEqualTo(RecipeMother.ESTIMATED_TIME);
            assertThat(recipeElement.getIngredients()).singleElement().satisfies(ingredient -> {
                assertThat(ingredient.getName()).isEqualTo(IngredientMother.NAME);
                assertThat(ingredient.getExtraInfo()).isEqualTo(IngredientMother.EXTRA_INFO);
            });
        });
    }

    @Test
    void shouldUpdateMeal() {
        final String newMealName = "meal";
        final LocalTime mealStart = LocalTime.parse("12:00");
        Recipe recipe = RecipeMother.complete()
                .withIngredients(List.of(IngredientMother.complete().build()))
                .build();
        Recipe recipe1 = RecipeMother.complete()
                .withIngredients(List.of(IngredientMother.complete()
                        .withName("updateName")
                        .build()))
                .build();
        Meal existingMeal = MealMother.complete()
                .withRecipes(List.of(recipe))
                .build();
        Meal mealUpdate = MealMother.complete()
                .withName(newMealName)
                .withStartAt(mealStart)
                .withRecipes(List.of(recipe1))
                .build();

        Meal result = mapper.updateMeal(existingMeal, mealUpdate);

        assertThat(result.getId()).isEqualTo(MealMother.ID);
        assertThat(result.getExternalId()).isEqualTo(MealMother.EXTERNAL_ID);
        assertThat(result.getName()).isEqualTo(newMealName);
        assertThat(result.getStartAt()).isEqualTo(mealStart);
        assertThat(result.getMealRecipes()).singleElement().satisfies(recipeElement -> {
            assertThat(recipeElement.getId()).isEqualTo(RecipeMother.ID);
            assertThat(recipeElement.getExternalId()).isEqualTo(RecipeMother.EXTERNAL_ID);
            assertThat(recipeElement.getDays()).isEqualTo(RecipeMother.DAYS);
            assertThat(recipeElement.getInstruction()).isEqualTo(RecipeMother.INSTRUCTION);
            assertThat(recipeElement.getEstimatedTime()).isEqualTo(RecipeMother.ESTIMATED_TIME);
            assertThat(recipeElement.getIngredients()).singleElement().satisfies(ingredient -> {
                assertThat(ingredient.getName()).isEqualTo(IngredientMother.NAME);
                assertThat(ingredient.getExtraInfo()).isEqualTo(IngredientMother.EXTRA_INFO);
            });
        });
    }
}