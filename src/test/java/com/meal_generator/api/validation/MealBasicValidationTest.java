package com.meal_generator.api.validation;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.meal_generator.api.common.ApiPath;
import com.meal_generator.api.controller.MealController;
import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.mother.MealDtoMother;
import com.meal_generator.service.MealService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import static com.meal_generator.api.validation.MealDtoValidationMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MealController.class)
public class MealBasicValidationTest {

    @MockBean
    private MealService mealService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Nested
    @DisplayName("POST " + ApiPath.CREATE_MEAL)
    class CreateMealValidationTests {

        @Test
        void shouldThrowExceptionWhenNameIsNull() throws Exception {
            MealDto meal = MealDtoMother.complete().withName(null).build();

            validate(meal, MEAL_NAME_REQUIRED_ERROR);
        }

        @Test
        void shouldThrowExceptionWhenNameIsEmpty() throws Exception {
            MealDto meal = MealDtoMother.complete().withName("").build();

            validate(meal, MEAL_NAME_LENGTH_ERROR);
        }

        private void validate(MealDto savedMeal, String... errorMessage) throws Exception {
            MealDto meal = mock(MealDto.class);
            when(mealService.createMeal(meal))
                    .thenReturn(savedMeal);

            MockHttpServletResponse response = mockMvc.perform(post(ApiPath.CREATE_MEAL)
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
