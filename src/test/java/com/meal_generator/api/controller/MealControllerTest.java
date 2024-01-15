package com.meal_generator.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meal_generator.api.common.ApiPath;
import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.mother.MealDtoMother;
import com.meal_generator.service.MealService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MealController.class)
class MealControllerTest {

    @MockBean
    private MealService mealService;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateMeal() throws Exception {
        MealDto mealToCreate = MealDtoMother.complete().build();
        MealDto savedMeal = MealDtoMother.complete().build();
        when(mealService.createMeal(mealToCreate))
                .thenReturn(savedMeal);

        mockMvc.perform(post(ApiPath.CREATE_MEAL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mealToCreate)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(savedMeal)));
    }

    @Test
    void shouldUpdateMeal() throws Exception {
        MealDto mealToUpdate = MealDtoMother.complete().build();
        MealDto savedMeal = MealDtoMother.complete().build();
        when(mealService.updateMeal(MealDtoMother.EXTERNAL_ID, mealToUpdate))
                .thenReturn(MealDtoMother.complete().build());

        mockMvc.perform(put(ApiPath.UPDATE_MEAL, MealDtoMother.EXTERNAL_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(mealToUpdate)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(savedMeal)));
    }

    @Test
    void shouldRetrieveMealById() throws Exception {
        MealDto existingMeal = MealDtoMother.complete().build();
        when(mealService.retrieveMeal(MealDtoMother.EXTERNAL_ID))
                .thenReturn(existingMeal);

        mockMvc.perform(get(ApiPath.RETRIEVE_MEAL, MealDtoMother.EXTERNAL_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(existingMeal)));
    }

    @Test
    void shouldRetrieveAllMeals() throws Exception {
        MealDto existingMeal = MealDtoMother.complete().build();
        when(mealService.retrieveMeals())
                .thenReturn(List.of(existingMeal));

        mockMvc.perform(get(ApiPath.RETRIEVE_MEALS)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(existingMeal))));
    }
}