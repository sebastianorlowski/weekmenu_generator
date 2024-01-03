package com.meal_generator.api.controller;

import com.meal_generator.api.dto.RecipeDto;
import com.meal_generator.repository.model.Recipe;
import com.meal_generator.service.RecipeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

import java.util.List;

import static com.meal_generator.api.common.ApiPath.*;

@RestController
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping(value = CREATE_RECIPE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createRecipe(@RequestBody @Valid RecipeDto recipeDto) {
        return new ResponseEntity<>(recipeService.createRecipe(recipeDto), HttpStatus.CREATED);
    }

    @PutMapping(value = UPDATE_RECIPE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateRecipe(@PathVariable String id,
                                          @RequestBody @Valid RecipeDto recipeDto) {
        return new ResponseEntity<>(recipeService.updateRecipe(id, recipeDto), HttpStatus.OK);
    }

    @GetMapping(value = RETRIEVE_RECIPE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> retrieveRecipe(@PathVariable String id) {
        return new ResponseEntity<>(recipeService.retrieveRecipe(id), HttpStatus.OK);
    }

    @GetMapping(value = RETRIEVE_RECIPES, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> retrieveRecipes() {
        return new ResponseEntity<>(recipeService.retrieveRecipes(), HttpStatus.OK);
    }
}
