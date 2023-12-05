package com.meal_generator.api;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.repository.model.Meal;
import com.meal_generator.service.MealService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MealController {

    private final MealService mealService;

    @PostMapping(value = "/create-meal", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> createMeal(@RequestBody @Valid MealDto mealDto) {
        return ResponseEntity.ok(mealService.createMeal(mealDto));
    }

    @GetMapping("/get-meal")
    public ResponseEntity<?> getMeal(Meal meal) {
        return ResponseEntity.ok("");
    }

    @PostMapping("/create-schedule")
    public ResponseEntity<?> createSchedule() {
        return ResponseEntity.ok("");
    }

    @GetMapping("/get-schedule")
    public ResponseEntity<?> getSchedule() {
        return ResponseEntity.ok("");
    }
}
