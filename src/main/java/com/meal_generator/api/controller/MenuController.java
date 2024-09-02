package com.meal_generator.api.controller;

import com.meal_generator.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.meal_generator.api.common.ApiPath.CREATE_DAY_MENU;
import static com.meal_generator.api.common.ApiPath.CREATE_WEEK_MENU;

@RestController
@AllArgsConstructor
public class MenuController {

    private MenuService menuService;

    // Day menu - generate menu
    @GetMapping(value = CREATE_DAY_MENU, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createDayMenu() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Week menu - generate menu
    @GetMapping(value = CREATE_WEEK_MENU, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createWeekMenu(Boolean isWeekendDifferently) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
