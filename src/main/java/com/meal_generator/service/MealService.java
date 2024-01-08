package com.meal_generator.service;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.validation.exception.MealNotFoundException;
import com.meal_generator.repository.MealRepository;
import com.meal_generator.repository.model.Meal;
import com.meal_generator.repository.model.Recipe;
import com.meal_generator.service.mapper.MealMapper;
import com.meal_generator.service.mapper.RecipeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.meal_generator.api.validation.MealDtoValidationMessage.MEAL_NOT_FOUND_ERROR;

@Service
@AllArgsConstructor
public class MealService {

    private MealRepository mealRepository;
    private MealMapper mealMapper;
    private RecipeService recipeService;
    private RecipeMapper recipeMapper;

    public MealDto createMeal(MealDto mealDto) {
        return null;
    }

    public MealDto updateMeal(String id, MealDto mealDto) {
        return null;
    }

    public MealDto retrieveMeal(String id) {
        return null;
    }

    public List<MealDto> retrieveMeals() {
        return Collections.emptyList();
    }

    public void linkMealToRecipe(String mealId, String recipeId) {
        Meal meal = getMealByExternalId(mealId);
        Recipe recipe = recipeService.getRecipeByExternalId(recipeId);
        meal.getMealRecipes().add(recipe);
    }

    public Optional<Meal> findMealByExternalId(String externalId) {
        return mealRepository.findMealByExternalId(externalId);
    }

    public Meal getMealByExternalId(String externalId) {
        return findMealByExternalId(externalId)
                .orElseThrow(() -> new MealNotFoundException(MEAL_NOT_FOUND_ERROR, externalId);
    }
}
