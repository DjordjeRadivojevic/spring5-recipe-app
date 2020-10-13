package com.springframework.spring5recipeapp.services;

import com.springframework.spring5recipeapp.commands.RecipeCommand;
import com.springframework.spring5recipeapp.converters.RecipeCommandToRecipe;
import com.springframework.spring5recipeapp.converters.RecipeToRecipeCommand;
import com.springframework.spring5recipeapp.domain.Recipe;
import com.springframework.spring5recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    @InjectMocks
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void getRecipeByIdTest() throws Exception {
//        Recipe recipe = new Recipe();
//        recipe.setId(1L);
//        Optional<Recipe> recipeOptional = Optional.of(recipe);
//        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
//        Recipe recipeReturned = recipeService.findById(1L);
//        assertNotNull(recipeReturned, "Null recipe returned");
//        verify(recipeRepository, times(1)).findById(anyLong());
//        verify(recipeRepository, never()).findAll();
//    }
//
//    @Test
//    public void getRecipeCommandByIdTest() throws Exception {
//        Recipe recipe = new Recipe();
//        recipe.setId(1L);
//        Optional<Recipe> recipeOptional = Optional.of(recipe);
//        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
//        RecipeCommand recipeCommand = new RecipeCommand();
//        recipeCommand.setId(1L);
//        when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);
//        RecipeCommand commandById = recipeService.findCommandById(1L);
//        assertNotNull(commandById,"Null recipe returned");
//        verify(recipeRepository, times(1)).findById(anyLong());
//        verify(recipeRepository, never()).findAll();
//    }
//
//    @Test
//    public void getRecipesTest() throws Exception {
//
//        Recipe recipe = new Recipe();
//        HashSet receipesData = new HashSet();
//        receipesData.add(recipe);
//
//        //when(recipeService.getRecipes()).thenReturn(receipesData);
//        when(recipeRepository.findAll()).thenReturn(receipesData);
//        Set<Recipe> recipes = recipeService.getRecipes();
//        assertEquals(recipes.size(), 1);
//        verify(recipeRepository, times(1)).findAll();
//        verify(recipeRepository, never()).findById(anyLong());
//    }
//
//    @Test
//    public void testDeleteById() throws Exception {
//        Long idToDelete = Long.valueOf(2L);
//        recipeService.deleteById(idToDelete);
//        verify(recipeRepository, times(1)).deleteById(anyLong());
//    }
}