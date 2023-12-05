package com.meal_generator.service;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.repository.MealRepository;
import com.meal_generator.repository.model.Meal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MealService {

    private MealRepository mealRepository;

    public MealDto createMeal(MealDto mealDto) {
        return null;
    }

    private Meal saveMeal(Meal meal) {
        return null;
    }
}
