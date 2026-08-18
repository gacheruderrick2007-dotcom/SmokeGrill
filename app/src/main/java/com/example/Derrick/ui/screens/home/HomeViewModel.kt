package com.example.Derrick.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Derrick.data.model.Recipe
import com.example.Derrick.data.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val repository = RecipeRepository()

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _selectedCategory = MutableStateFlow("All")
    val selectedCategory: StateFlow<String> = _selectedCategory

    init {
        fetchRecipes()
    }

    fun selectCategory(category: String) {
        _selectedCategory.value = category
    }

    fun seedData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                com.example.Derrick.data.remote.RecipeSeeder.seedDatabase()
                fetchRecipes()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchRecipes() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _recipes.value = repository.getRecipes()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun addRecipe(recipe: Recipe) {
        viewModelScope.launch {
            try {
                repository.createRecipe(recipe)
                fetchRecipes()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun deleteRecipe(id: Int) {
        viewModelScope.launch {
            try {
                repository.deleteRecipe(id)
                fetchRecipes()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
