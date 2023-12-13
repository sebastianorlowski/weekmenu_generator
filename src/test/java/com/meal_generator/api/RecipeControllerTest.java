package com.meal_generator.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meal_generator.api.common.ApiPath;
import com.meal_generator.api.dto.RecipeDto;
import com.meal_generator.api.mother.RecipeDtoMother;
import com.meal_generator.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeController.class)
class RecipeControllerTest {

    @MockBean
    private RecipeService recipeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateRecipe() throws Exception {
        RecipeDto recipeToCreate = RecipeDtoMother.complete().build();
        RecipeDto savedRecipe = RecipeDtoMother.complete().build();
        when(recipeService.createRecipe(recipeToCreate))
                .thenReturn(savedRecipe);

        mockMvc.perform(post(ApiPath.CREATE_RECIPE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(recipeToCreate)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(savedRecipe)));
    }

    @Test
    void shouldUpdateRecipe() throws Exception {
        RecipeDto recipeToUpdate = RecipeDtoMother.complete().build();
        RecipeDto savedRecipe = RecipeDtoMother.complete().build();
        when(recipeService.updateRecipe(RecipeDtoMother.EXTERNAL_ID, recipeToUpdate))
                .thenReturn(RecipeDtoMother.complete().build());

        mockMvc.perform(put(ApiPath.UPDATE_RECIPE, RecipeDtoMother.EXTERNAL_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(recipeToUpdate)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(savedRecipe)));
    }

    @Test
    void shouldRetrieveRecipeById() throws Exception {
        RecipeDto existingRecipe = RecipeDtoMother.complete().build();
        when(recipeService.retrieveRecipe(RecipeDtoMother.EXTERNAL_ID))
                .thenReturn(existingRecipe);

        mockMvc.perform(get(ApiPath.RETRIEVE_RECIPE, RecipeDtoMother.EXTERNAL_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(existingRecipe)));
    }

    @Test
    void shouldRetrieveAllRecipes() throws Exception {
        RecipeDto existingRecipe = RecipeDtoMother.complete().build();
        when(recipeService.retrieveRecipes())
                .thenReturn(List.of(existingRecipe));

        mockMvc.perform(get(ApiPath.RETRIEVE_RECIPES)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(existingRecipe))));
    }
}