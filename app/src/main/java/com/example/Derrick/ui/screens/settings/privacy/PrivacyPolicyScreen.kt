package com.example.Derrick.ui.screens.settings.privacy

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreen(onNavigateBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Privacy Policy", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Privacy Policy for Smoke $ Grill",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Last updated: May 2026",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            PrivacySection(
                title = "1. Information We Collect",
                content = "Smoke $ Grill collects your email address and recipe data that you manually input into the app. We also use third-party authentication services (Google) to manage your account safely."
            )

            PrivacySection(
                title = "2. How We Use Your Information",
                content = "Your data is primarily used to synchronize your recipes across devices using Supabase. We do not sell your personal data to third parties."
            )

            PrivacySection(
                title = "3. Data Security",
                content = "We take reasonable measures to protect your information from unauthorized access. However, no internet transmission is 100% secure, so use the service at your own risk."
            )

            PrivacySection(
                title = "4. Changes to This Policy",
                content = "We may update our Privacy Policy from time to time. We will notify you of any changes by posting the new Privacy Policy on this page."
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun PrivacySection(title: String, content: String) {
    Column(modifier = Modifier.padding(bottom = 20.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = content,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
