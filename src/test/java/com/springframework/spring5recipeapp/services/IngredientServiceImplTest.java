package com.springframework.spring5recipeapp.services;

import com.springframework.spring5recipeapp.commands.IngredientCommand;
import com.springframework.spring5recipeapp.converters.IngredientCommandToIngredient;
import com.springframework.spring5recipeapp.converters.IngredientToIngredientCommand;
import com.springframework.spring5recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.springframework.spring5recipeapp.domain.Ingredient;
import com.springframework.spring5recipeapp.domain.Recipe;
import com.springframework.spring5recipeapp.repositories.RecipeRepository;
import com.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest {

        private final IngredientToIngredientCommand ingredientToIngredientCommand;

        @Mock
        RecipeRepository recipeRepository;

        @Mock
        IngredientCommandToIngredient ingredientCommandToIngredient;

        @Mock
        UnitOfMeasureRepository unitOfMeasureRepository;

        IngredientService ingredientService;

        public IngredientServiceImplTest() {
            this.ingredientToIngredientCommand = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
        }

        @BeforeEach
        public void setUp() throws Exception {
            MockitoAnnotations.initMocks(this);
            ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, ingredientCommandToIngredient, recipeRepository, unitOfMeasureRepository);
        }

        @Test
        public void findByRecipeIdAndReceipeId() throws Exception {
            Recipe recipe = new Recipe();
            recipe.setId(1L);

            Ingredient ingredient1 = new Ingredient();
            ingredient1.setId(1L);

            Ingredient ingredient2 = new Ingredient();
            ingredient2.setId(2L);

            Ingredient ingredient3 = new Ingredient();
            ingredient3.setId(3L);

            recipe.addIngredient(ingredient1);
            recipe.addIngredient(ingredient2);
            recipe.addIngredient(ingredient3);
            Optional<Recipe> recipeOptional = Optional.of(recipe);

            when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
            IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);
            assertEquals(Long.valueOf(3L), ingredientCommand.getId());
            assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
            verify(recipeRepository, times(1)).findById(anyLong());
        }

}