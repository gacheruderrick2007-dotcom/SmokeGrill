package com.example.Derrick.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.Derrick.ui.theme.Black

@Composable
fun OnboardingScreen(onFinish: () -> Unit) {
    val gradient = Brush.verticalGradient(
        colors = listOf(
                    Color(0xFF8EC5FC),
                    Color(0xFFA18CD1),
                    Color(0xFFD299FF)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.RestaurantMenu,
            contentDescription = "App Logo",
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 24.dp),
            tint = Black
        )
        Text(
            text = "Welcome to Smoke $ Grill Recipes",
            style = MaterialTheme.typography.headlineLarge,
            color = Black,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Discover the best recipes for your favorite dishes.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button(
            onClick = onFinish,
            modifier = Modifier.fillMaxWidth(0.7f),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("Get Started", style = MaterialTheme.typography.labelLarge)
        }
    }
}
