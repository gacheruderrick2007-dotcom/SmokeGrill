package com.example.Derrick.ui.screens.authentication.forgotpassword

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.Derrick.ui.theme.Black

@Composable
fun ForgotPasswordScreen(
    onResetSent: () -> Unit,
    onNavigateBack: () -> Unit
) {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Forgot Password", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Enter your email to receive a password reset link.")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Black,
                unfocusedTextColor = Black,
                cursorColor = Black
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onResetSent,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send Reset Link")
        }
        TextButton(onClick = onNavigateBack) {
            Text("Back to Login")
        }
    }
}
