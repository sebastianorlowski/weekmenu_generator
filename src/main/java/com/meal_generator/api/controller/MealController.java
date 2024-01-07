package com.meal_generator.api.controller;

import com.meal_generator.api.dto.MealDto;
import com.meal_generator.service.MealService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.meal_generator.api.common.ApiPath.*;

@RestController
@AllArgsConstructor
public class MealController {

    private final MealService mealService;

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
}
