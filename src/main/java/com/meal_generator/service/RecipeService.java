package com.meal_generator.service;

import com.meal_generator.api.dto.RecipeDto;
import com.meal_generator.api.validation.exception.RecipeNotFoundException;
import com.meal_generator.repository.RecipeRepository;
import com.meal_generator.repository.model.Recipe;
import com.meal_generator.service.mapper.RecipeMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.meal_generator.api.validation.RecipeDtoValidationMessage.RECIPE_NOT_FOUND_ERROR;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class RecipeService {

    private RecipeRepository recipeRepository;
    private RecipeMapper recipeMapper;

    public RecipeDto createRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.asRecipeEntity(recipeDto);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return recipeMapper.asRecipeDto(savedRecipe);
    }

    public RecipeDto updateRecipe(String id, RecipeDto recipeDto) {
        Recipe existingRecipe = getRecipeByExternalId(id);
        Recipe recipe = recipeMapper.asRecipeEntity(recipeDto);
        recipeMapper.updateRecipe(existingRecipe, recipe);
        Recipe savedRecipe = recipeRepository.save(existingRecipe);
        return recipeMapper.asRecipeDto(savedRecipe);
    }

    public RecipeDto retrieveRecipe(String id) {
        Recipe recipe = getRecipeByExternalId(id);
        return recipeMapper.asRecipeDto(recipe);
    }

    public List<RecipeDto> retrieveRecipes() {
        return recipeMapper.asRecipeDtoList(findRecipes());
    }

    public Recipe getRecipeByExternalId(String id) {
        return findRecipeByExternalId(id)
                .orElseThrow(() -> new RecipeNotFoundException(RECIPE_NOT_FOUND_ERROR, id));
    }

    public Optional<Recipe> findRecipeByExternalId(String id) {
        return recipeRepository.findRecipeByExternalId(id);
    }

    public List<Recipe> findRecipes() {
        return recipeRepository.findAll();
    }
}
