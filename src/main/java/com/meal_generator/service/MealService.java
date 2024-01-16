package com.meal_generator.service;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.validation.exception.MealException;
import com.meal_generator.api.validation.exception.MealNotFoundException;
import com.meal_generator.api.validation.validator.MealValidator;
import com.meal_generator.repository.MealRepository;
import com.meal_generator.repository.model.Meal;
import com.meal_generator.repository.model.Recipe;
import com.meal_generator.service.mapper.MealMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.meal_generator.api.validation.MealDtoValidationMessage.MEAL_NAME_EXISTS_ERROR;
import static com.meal_generator.api.validation.MealDtoValidationMessage.MEAL_NOT_FOUND_ERROR;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class MealService {

    private MealRepository mealRepository;
    private MealMapper mealMapper;
    private RecipeService recipeService;
    private MealValidator mealValidator;

    public MealDto createMeal(MealDto mealDto) {
        mealValidator.validateCreateMeal(mealDto);

        Meal meal = mealMapper.asMealEntity(mealDto);
        Meal savedMeal = mealRepository.save(meal);
        return mealMapper.asMealDto(savedMeal);
    }

    public MealDto updateMeal(String id, MealDto mealDto) {
        Meal existingMeal = getMealByExternalId(id);
        mealValidator.validateUpdateMeal(existingMeal.getName(), mealDto);

        Meal meal = mealMapper.asMealEntity(mealDto);
        mealMapper.updateMeal(existingMeal, meal);
        Meal savedMeal = mealRepository.save(existingMeal);
        return mealMapper.asMealDto(savedMeal);
    }

    public MealDto retrieveMeal(String id) {
        Meal meal = getMealByExternalId(id);
        return mealMapper.asMealDto(meal);
    }

    public List<MealDto> retrieveMeals() {
        List<Meal> mealList = mealRepository.findAll();
        return mealMapper.asMealDtoList(mealList);
    }

    public void linkMealToRecipe(String mealId, String recipeId) {
        Meal meal = getMealByExternalId(mealId);
        Recipe recipe = recipeService.getRecipeByExternalId(recipeId);
        meal.getMealRecipes().add(recipe);
        mealRepository.save(meal);
    }

    public void unLinkMealToRecipe(String mealId, String recipeId) {
        Meal meal = getMealByExternalId(mealId);
        Recipe recipe = recipeService.getRecipeByExternalId(recipeId);
        meal.getMealRecipes().remove(recipe);
    }

    public Optional<Meal> findMealByExternalId(String externalId) {
        return mealRepository.findMealByExternalId(externalId);
    }

    public Meal getMealByExternalId(String externalId) {
        return findMealByExternalId(externalId)
                .orElseThrow(() -> new MealNotFoundException(MEAL_NOT_FOUND_ERROR, externalId));
    }

    public void isMealExistsByName(String name) {
        if (mealRepository.existsMealByName(name)) {
            throw new MealException(MEAL_NAME_EXISTS_ERROR, name);
        }
    }
}
