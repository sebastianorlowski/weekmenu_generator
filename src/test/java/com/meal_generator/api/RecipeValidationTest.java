package com.meal_generator.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meal_generator.api.common.ApiPath;
import com.meal_generator.api.dto.RecipeDto;
import com.meal_generator.api.mother.IngredientDtoMother;
import com.meal_generator.api.mother.RecipeDtoMother;
import com.meal_generator.service.RecipeService;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.meal_generator.api.validation.RecipeDtoValidationMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeController.class)
public class RecipeValidationTest {

    @MockBean
    private RecipeService recipeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DisplayName("POST " + ApiPath.CREATE_RECIPE)
    class CreateRecipeValidationTests {

        @Test
        void shouldThrowExceptionWhenNameIsNull() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete().withName(null).build();

            validate(recipeDto, RECIPE_NAME_REQUIRED_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenNameIsEmpty() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete().withName("").build();

            validate(recipeDto, RECIPE_NAME_LENGTH_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenNameLengthIsLessThan3() throws Exception {
            String shortString = StringUtils.repeat("a", 2);
            RecipeDto recipeDto = RecipeDtoMother.complete().withName(shortString).build();

            validate(recipeDto, RECIPE_NAME_LENGTH_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenNameLengthIsMoreThan100() throws Exception {
            String longString = StringUtils.repeat("a", 101);
            RecipeDto recipeDto = RecipeDtoMother.complete().withName(longString).build();

            validate(recipeDto, RECIPE_NAME_LENGTH_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenMealTypeIsNull() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete().withRecipeType(null).build();

            validate(recipeDto, RECIPE_TYPE_REQUIRED_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenMealTypeIsWrong() throws Exception {
            RecipeDto savedMeal = RecipeDtoMother.complete().withRecipeType("meal").build();

            validate(savedMeal, RECIPE_TYPE_PATTERN_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenMealDaysLessThan1() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete().withDays(0).build();

            validate(recipeDto, RECIPE_DAYS_MIN_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenMealDaysMoreThan7() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete().withDays(8).build();

            validate(recipeDto, RECIPE_DAYS_MAX_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenMealDaysAreNull() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete().withDays(null).build();

            validate(recipeDto, RECIPE_DAYS_REQUIRED_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenMealInstructionIsNull() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete().withInstruction(null).build();

            validate(recipeDto, RECIPE_INSTRUCTION_REQUIRED_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenMealInstructionLengthIsMoreThan10000() throws Exception {
            String longString = StringUtils.repeat("i", 10001);
            RecipeDto recipeDto = RecipeDtoMother.complete().withInstruction(longString).build();

            validate(recipeDto, RECIPE_INSTRUCTION_LENGTH_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenMealInstructionLengthIsLessThan10() throws Exception {
            String shortString = StringUtils.repeat("i", 9);
            RecipeDto recipeDto = RecipeDtoMother.complete().withInstruction(shortString).build();

            validate(recipeDto, RECIPE_INSTRUCTION_LENGTH_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenEstimatedTimeIsNull() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete().withEstimatedTime(null).build();

            validate(recipeDto, RECIPE_ESTIMATED_TIME_REQUIRED_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenEstimatedTimeMinimumIsLessThan5() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete().withEstimatedTime(4).build();

            validate(recipeDto, RECIPE_ESTIMATED_TIME_MIN_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenEstimatedTimeMinimumIsMoreThan1200() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete().withEstimatedTime(1201).build();

            validate(recipeDto, RECIPE_ESTIMATED_TIME_MAX_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenIngredientsAreEmpty() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete().withIngredients(Collections.emptyList()).build();

            validate(recipeDto, RECIPE_INGREDIENTS_REQUIRED_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenIngredientsAreNull() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete().withIngredients(null).build();

            validate(recipeDto, RECIPE_INGREDIENTS_REQUIRED_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenIngredientNameIsNull() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete()
                    .withIngredients(List.of(
                            IngredientDtoMother.complete()
                                    .withName(null)
                                    .build()))
                    .build();

            validate(recipeDto, RECIPE_INGREDIENT_NAME_REQUIRED_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenIngredientNameIsEmpty() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete()
                    .withIngredients(List.of(
                            IngredientDtoMother.complete()
                                    .withName("")
                                    .build()))
                    .build();

            validate(recipeDto, RECIPE_INGREDIENT_NAME_LENGTH_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenIngredientNameIsLessThan3() throws Exception {
            String shortString = StringUtils.repeat("a", 2);
            RecipeDto recipeDto = RecipeDtoMother.complete()
                    .withIngredients(List.of(
                            IngredientDtoMother.complete()
                                    .withName(shortString)
                                    .build()))
                    .build();

            validate(recipeDto, RECIPE_INGREDIENT_NAME_LENGTH_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenIngredientNameIsMoreThan1000() throws Exception {
            String longString = StringUtils.repeat("a", 1001);
            RecipeDto recipeDto = RecipeDtoMother.complete()
                    .withIngredients(List.of(
                            IngredientDtoMother.complete()
                                    .withName(longString)
                                    .build()))
                    .build();

            validate(recipeDto, RECIPE_INGREDIENT_NAME_LENGTH_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenIngredientWorthIsNull() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete()
                    .withIngredients(List.of(
                            IngredientDtoMother.complete()
                                    .withWorth(null)
                                    .build()))
                    .build();

            validate(recipeDto, RECIPE_INGREDIENT_WORTH_REQUIRED_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenIngredientWorthIsNegativeNumber() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete()
                    .withIngredients(List.of(
                            IngredientDtoMother.complete()
                                    .withWorth(-1)
                                    .build()))
                    .build();

            validate(recipeDto, RECIPE_INGREDIENT_WORTH_MIN_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenIngredientWorthExcess1000000() throws Exception {
            RecipeDto recipeDto = RecipeDtoMother.complete()
                    .withIngredients(List.of(
                            IngredientDtoMother.complete()
                                    .withWorth(10000001)
                                    .build()))
                    .build();

            validate(recipeDto, RECIPE_INGREDIENT_WORTH_MAX_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenIngredientExtraInfoExcess1000() throws Exception {
            String longString = StringUtils.repeat("a", 1001);
            RecipeDto recipeDto = RecipeDtoMother.complete()
                    .withIngredients(List.of(
                            IngredientDtoMother.complete()
                                    .withExtraInfo(longString)
                                    .build()))
                    .build();

            validate(recipeDto, RECIPE_INGREDIENT_EXTRA_INFO_LENGTH_ERROR);
        }

        @Test
        void shouldThrowExceptionFromEveryField() throws Exception {
            RecipeDto recipeDto = new RecipeDto();
            String[] errorMessages = new String[] {
                    RECIPE_ESTIMATED_TIME_REQUIRED_ERROR,
                    RECIPE_DAYS_REQUIRED_ERROR,
                    RECIPE_INSTRUCTION_REQUIRED_ERROR,
                    RECIPE_NAME_REQUIRED_ERROR,
                    RECIPE_TYPE_REQUIRED_ERROR,
                    RECIPE_INGREDIENTS_REQUIRED_ERROR
            };

            validate(recipeDto, errorMessages);
        }

        private void validate(RecipeDto savedMeal, String... errorMessage) throws Exception {
            RecipeDto meal = mock(RecipeDto.class);
            when(recipeService.createRecipe(meal))
                    .thenReturn(savedMeal);

            MockHttpServletResponse response = mockMvc.perform(post(ApiPath.CREATE_RECIPE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(savedMeal)))
                    .andExpect(status().isBadRequest())
                    .andReturn().getResponse();

            String expectedResponseBody = buildExpectedResponseBody(List.of(errorMessage));

            assertThat(response.getContentAsString()).isEqualTo(expectedResponseBody);
        }
    }

    private String buildExpectedResponseBody(List<String> errors) {
        String errorsJson = errors.stream()
                .map(error -> "\"" + error + "\"")
                .collect(Collectors.joining(","));

        return "{\"errors\":[" + errorsJson + "]}";
    }
}
