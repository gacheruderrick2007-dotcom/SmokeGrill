package com.example.Derrick.ui.navigations

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.Derrick.ui.screens.authentication.forgotpassword.ForgotPasswordScreen
import com.example.Derrick.ui.screens.authentication.login.LoginScreen
import com.example.Derrick.ui.screens.authentication.register.RegisterScreen
import com.example.Derrick.ui.screens.home.HomeScreen
import com.example.Derrick.ui.screens.onboarding.OnboardingScreen
import com.example.Derrick.ui.screens.profile.ProfileScreen
import com.example.Derrick.ui.screens.profile.myrecipes.MyRecipesScreen
import com.example.Derrick.ui.screens.home.favourites.FavoritesScreen
import com.example.Derrick.ui.screens.settings.SettingsScreen
import com.example.Derrick.ui.screens.settings.privacy.PrivacyPolicyScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(
            navController = navController,
            startDestination = ROUTES.ONBOARDING.name,
        ) {
            composable(ROUTES.ONBOARDING.name) {
                OnboardingScreen {
                    navController.navigate(ROUTES.LOGIN.name) {
                        popUpTo(ROUTES.ONBOARDING.name) { inclusive = true }
                    }
                }
            }
            composable(ROUTES.LOGIN.name) {
                LoginScreen(
                    onLoginSuccess = {
                        navController.navigate(ROUTES.HOME.name) {
                            popUpTo(ROUTES.LOGIN.name) { inclusive = true }
                        }
                    },
                    onNavigateToRegister = {
                        navController.navigate(ROUTES.REGISTER.name)
                    },
                    onNavigateToForgotPassword = {
                        navController.navigate(ROUTES.FORGOT_PASSWORD.name)
                    }
                )
            }
            composable(ROUTES.REGISTER.name) {
                RegisterScreen(
                    onRegisterSuccess = {
                        navController.navigate(ROUTES.LOGIN.name)
                    },
                    onNavigateToLogin = {
                        navController.navigate(ROUTES.LOGIN.name)
                    }
                )
            }
            composable(ROUTES.FORGOT_PASSWORD.name) {
                ForgotPasswordScreen(
                    onResetSent = {
                        navController.navigate(ROUTES.LOGIN.name)
                    },
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
            composable(ROUTES.HOME.name) {
                HomeScreen(
                    onNavigateToProfile = {
                        navController.navigate(ROUTES.PROFILE.name)
                    }
                )
            }
            composable(ROUTES.PROFILE.name) {
                ProfileScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    },
                    onLogout = {
                        navController.navigate(ROUTES.LOGIN.name) {
                            popUpTo(ROUTES.HOME.name) { inclusive = true }
                        }
                    },
                    onNavigateToSettings = {
                        navController.navigate(ROUTES.SETTINGS.name)
                    },
                    onNavigateToMyRecipes = {
                        navController.navigate(ROUTES.MY_RECIPES.name)
                    },
                    onNavigateToFavorites = {
                        navController.navigate(ROUTES.FAVORITES.name)
                    }
                )
            }
            composable(ROUTES.SETTINGS.name) {
                SettingsScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    },
                    onNavigateToPrivacyPolicy = {
                        navController.navigate(ROUTES.PRIVACY_POLICY.name)
                    }
                )
            }
            composable(ROUTES.PRIVACY_POLICY.name) {
                PrivacyPolicyScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
            composable(ROUTES.MY_RECIPES.name) {
                MyRecipesScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
            composable(ROUTES.FAVORITES.name) {
                FavoritesScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
