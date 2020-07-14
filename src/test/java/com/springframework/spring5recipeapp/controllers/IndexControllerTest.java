package com.springframework.spring5recipeapp.controllers;

import com.springframework.spring5recipeapp.domain.Recipe;
import com.springframework.spring5recipeapp.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @InjectMocks
    IndexController indexController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getIndexPage() {
        HashSet<Recipe> recipes = new HashSet<>();
        when(recipeService.getRecipes()).thenReturn(recipes);
        assertEquals("index", indexController.getIndexPage(model));
        verify(model,times(1)).addAttribute(eq("recipes"),anySet());
        verify(recipeService,times(1)).getRecipes();
    }
}