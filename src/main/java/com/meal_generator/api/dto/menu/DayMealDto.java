package com.meal_generator.api.dto.menu;

import com.meal_generator.api.dto.MealDto;
import lombok.Data;

import java.util.List;

@Data
public class DayMealDto {

    private String id;
    private DayEnum dayEnum;
    private List<DailyMeal> dailyMeals;

    // Monday
    // List<Meal> -> 1, 2, 3, 4
    // Every Meal has one recipe - should be in line 2 in row
    // Prepare recipe for monday, tuesday, and wednesday

}
