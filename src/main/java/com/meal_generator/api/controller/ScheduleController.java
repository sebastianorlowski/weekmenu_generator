package com.meal_generator.api.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.meal_generator.api.common.ApiPath.CREATE_DAILY_MEAL_SCHEDULE;
import static com.meal_generator.api.validation.MealDtoValidationMessage.MEAL_NAMES_REQUIRED_ERROR;

@RestController
@AllArgsConstructor
public class ScheduleController {

    //TBC
//    private
//
//    @PostMapping(value = CREATE_DAILY_MEAL_SCHEDULE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> createDailyMealSchedule(@RequestParam @NotBlank @Size String name,
//                                                     @NotEmpty(message = MEAL_NAMES_REQUIRED_ERROR) List<String> mealNames) {
//        mealService.createDailyMealSchedule(name, mealNames);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @DeleteMapping()
//    public ResponseEntity<?> deleteDailyMealSchedule(@RequestParam String name) {
//        mealService.deleteDailyMealSchedule(name);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
