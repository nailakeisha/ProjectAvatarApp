package com.example.avatarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.avatarapp.ui.screen.RegisterScreen
import com.example.avatarapp.ui.theme.AvatarAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvatarAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "register") {
                    composable("register") {
                        RegisterScreen(onNavigateToLogin = { navController.navigate("login") })
                    }
                }
            }
        }
    }
}