package com.meal_generator.api.dto.menu;

import com.meal_generator.api.dto.MealDto;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class DailyMeal {

    private String id;

    private String name;

    private LocalTime startAt;

    private List<MealDto> meals;
}
