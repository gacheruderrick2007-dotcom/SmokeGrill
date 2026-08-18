package com.example.Derrick.data.repository

import com.example.Derrick.data.model.Recipe
import com.example.Derrick.data.remote.SupabaseClient
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepository {
    suspend fun getRecipes(): List<Recipe> = withContext(Dispatchers.IO) {
        SupabaseClient.client.from("recipes").select().decodeList<Recipe>()
    }

    suspend fun createRecipe(recipe: Recipe) = withContext(Dispatchers.IO) {
        SupabaseClient.client.from("recipes").insert(recipe)
    }

    suspend fun updateRecipe(recipe: Recipe) = withContext(Dispatchers.IO) {
        SupabaseClient.client.from("recipes").update(recipe) {
            filter {
                Recipe::id eq recipe.id
            }
        }
    }

    suspend fun deleteRecipe(id: Int) = withContext(Dispatchers.IO) {
        SupabaseClient.client.from("recipes").delete {
            filter {
                Recipe::id eq id
            }
        }
    }
}
