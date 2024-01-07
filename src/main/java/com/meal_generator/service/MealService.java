package com.meal_generator.service;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.repository.MealRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class MealService {

    private final MealRepository mealRepository;

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
}
