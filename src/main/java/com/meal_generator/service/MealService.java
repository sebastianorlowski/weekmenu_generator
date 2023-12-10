package com.meal_generator.service;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.repository.MealRepository;
import com.meal_generator.repository.model.Meal;
import com.meal_generator.service.mapper.MealMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MealService {

    private MealRepository mealRepository;
    private MealMapper mealMapper;

    public MealDto createMeal(MealDto mealDto) {
        Meal meal = mealMapper.asMealEntity(mealDto);
        Meal savedMeal = mealRepository.save(meal);
        return mealMapper.asMealDto(savedMeal);
    }

    private Meal saveMeal(Meal meal) {
        return null;
    }
}
