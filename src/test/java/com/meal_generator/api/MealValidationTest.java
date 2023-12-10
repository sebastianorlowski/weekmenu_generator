package com.meal_generator.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.mother.MealDtoMother;
import com.meal_generator.service.MealService;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MealController.class)
public class MealValidationTest {

    @MockBean
    private MealService mealService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DisplayName("POST /create-meal")
    class CreateMealValidationTests {

        @Test
        void shouldThrowExceptionWhenNameIsEmpty() throws Exception {
            MealDto mealDto = MealDtoMother.complete().withName("").build();
            String errorMessage = "The name of the meal should be between 3 and 100 characters.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenNameIsNull() throws Exception {
            MealDto mealDto = MealDtoMother.complete().withName(null).build();
            String errorMessage = "Meal name is required.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenMealTypeIsNull() throws Exception {
            MealDto mealDto = MealDtoMother.complete().withMealType(null).build();
            String errorMessage = "The type of meal is required.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenMealTypeIsWrong() throws Exception {
            MealDto savedMeal = MealDtoMother.complete().withMealType("meal").build();
            String errorMessage = "The meal type must match breakfast, lunch, dinner, evening_meal.";

            validate(savedMeal, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenMealDaysLessThan1() throws Exception {
            MealDto mealDto = MealDtoMother.complete().withDays(0).build();
            String errorMessage = "The minimum number of meal days must be 1.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenMealDaysMoreThan7() throws Exception {
            MealDto mealDto = MealDtoMother.complete().withDays(8).build();
            String errorMessage = "The maximum number of meal days must be 7.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenMealDaysAreNull() throws Exception {
            MealDto mealDto = MealDtoMother.complete().withDays(null).build();
            String errorMessage = "Meal days are required.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenMealInstructionIsNull() throws Exception {
            MealDto mealDto = MealDtoMother.complete().withInstruction(null).build();
            String errorMessage = "The meal instructions must not be empty.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenMealInstructionIsMoreThan10000() throws Exception {
            String longString = StringUtils.repeat("i", 10001);
            MealDto mealDto = MealDtoMother.complete().withInstruction(longString).build();
            String errorMessage = "Meal instructions should be between 10 and 10000 characters.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenMealInstructionIsLessThan10() throws Exception {
            String shortString = StringUtils.repeat("i", 9);
            MealDto mealDto = MealDtoMother.complete().withInstruction(shortString).build();
            String errorMessage = "Meal instructions should be between 10 and 10000 characters.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenEstimatedTimeIsNull() throws Exception {
            MealDto mealDto = MealDtoMother.complete().withEstimatedTime(null).build();
            String errorMessage = "Estimated meal times are required.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenEstimatedTimeMinimumIsLessThan5() throws Exception {
            MealDto mealDto = MealDtoMother.complete().withEstimatedTime(4).build();
            String errorMessage = "The minimum estimated meal time must be 5 minutes.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenEstimatedTimeMinimumIsMoreThan1200() throws Exception {
            MealDto mealDto = MealDtoMother.complete().withEstimatedTime(1201).build();
            String errorMessage = "The maximum estimated meal time must be 1200 minutes.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenIngredientsAreEmpty() throws Exception {
            MealDto mealDto = MealDtoMother.complete().withIngredients(Collections.emptyList()).build();
            String errorMessage = "You must provide the ingredients for the meal.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionWhenIngredientsAreNull() throws Exception {
            MealDto mealDto = MealDtoMother.complete().withIngredients(null).build();
            String errorMessage = "You must provide the ingredients for the meal.";

            validate(mealDto, errorMessage);
        }

        @Test
        void shouldThrowExceptionFromEveryField() throws Exception {
            MealDto mealDto = new MealDto();
            String[] errorMessages = new String[] {
                    "Estimated meal times are required.",
                    "Meal days are required.",
                    "Meal name is required.",
                    "The meal instructions must not be empty.",
                    "The type of meal is required.",
                    "You must provide the ingredients for the meal."
            };

            validate(mealDto, errorMessages);
        }

        private void validate(MealDto savedMeal, String... errorMessage) throws Exception {
            MealDto meal = mock(MealDto.class);
            when(mealService.createMeal(meal))
                    .thenReturn(savedMeal);

            MockHttpServletResponse response = mockMvc.perform(post("/create-meal")
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
