package com.example.Derrick.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val id: Int? = null,
    val title: String,
    val description: String,
    val imageUrl: String,
    val ingredients: List<String>,
    val instructions: List<String>,
    val estimatedCost: Int? = null, // Cost in KES
    val webUrl: String? = null,
    val category: String = "General"
)