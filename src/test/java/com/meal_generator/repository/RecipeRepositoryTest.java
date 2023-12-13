package com.meal_generator.repository;

import com.meal_generator.api.builder.RecipeDtoBuilder;
import com.meal_generator.api.dto.IngredientDto;
import com.meal_generator.api.dto.RecipeDto;
import com.meal_generator.repository.builder.RecipeBuilder;
import com.meal_generator.repository.model.Ingredient;
import com.meal_generator.repository.model.Recipe;
import com.meal_generator.repository.mother.RecipeMother;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void shouldFindRecipeById() {
        Recipe recipe = RecipeMother.complete().withId(null).build();
        entityManager.persist(recipe);
        Optional<Recipe> result = recipeRepository.findById(recipe.getId());

        assertThat(result).hasValue(recipe);
    }
}