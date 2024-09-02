package com.meal_generator.api.controller;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.api.validation.validator.MealValidator;
import com.meal_generator.service.MealService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.meal_generator.api.common.ApiPath.*;
import static com.meal_generator.api.validation.MealDtoValidationMessage.MEAL_NAMES_REQUIRED_ERROR;

@RestController
@AllArgsConstructor
public class MealController {

    private MealService mealService;

    @PostMapping(value = CREATE_MEAL, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createMeal(@RequestBody @Valid MealDto mealDto) {
        return new ResponseEntity<>(mealService.createMeal(mealDto), HttpStatus.CREATED);
    }

    @PutMapping(value = UPDATE_MEAL, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMeal(@PathVariable String id,
                                        @RequestBody @Valid MealDto mealDto) {
        return new ResponseEntity<>(mealService.updateMeal(id, mealDto), HttpStatus.OK);
    }

    @GetMapping(value = RETRIEVE_MEAL, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> retrieveMeal(@PathVariable String id) {
        return new ResponseEntity<>(mealService.retrieveMeal(id), HttpStatus.OK);
    }

    @GetMapping(value = RETRIEVE_MEALS, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> retrieveMeals() {
        return new ResponseEntity<>(mealService.retrieveMeals(), HttpStatus.OK);
    }

    @PostMapping(value = CREATE_CONNECTION_TO_RECIPE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> linkMealToRecipe(@RequestParam String mealId,
                                              @RequestParam String recipeId) {
        mealService.linkMealToRecipe(mealId, recipeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = UPDATE_CONNECTION_TO_RECIPE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMealToRecipe(@RequestParam String mealId,
                                                @RequestParam String recipeId) {
        mealService.unLinkMealToRecipe(mealId, recipeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = CREATE_DAILY_MEAL_SCHEDULE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createDailyMealSchedule(@RequestParam @NotBlank @Size String name,
                                                     @NotEmpty(message = MEAL_NAMES_REQUIRED_ERROR) List<String> mealNames) {
        /*
        DailyMeal model -> name as request param


         */
        mealService.createDailyMealSchedule(name, mealNames);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = DELETE_DAILY_MEAL_SCHEDULE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteDailyMealSchedule(@RequestParam String name) {
        mealService.deleteDailyMealSchedule(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
