package com.example.avatarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.avatarapp.ui.screen.LoginScreen
import com.example.avatarapp.ui.screen.RegisterScreen
import com.example.avatarapp.ui.screen.ProfileScreen
import com.example.avatarapp.ui.theme.AvatarAppTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.avatarapp.ui.screen.AvatarScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvatarAppTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "register" // Kita mulai dari login atau register sesuai keinginan
                ) {
                    // 1. Rute Register
                    composable("register") {
                        RegisterScreen(
                            onNavigateToLogin = { navController.navigate("login") }
                        )
                    }

                    // 2. Rute Login
                    composable("login") {
                        LoginScreen(
                            // Sesuai parameter di fungsi LoginScreen Anda: onMasukClick
                            onMasukClick = { email, password ->
                                // Arahkan ke rute "profile"
                                navController.navigate("profile") {
                                    // Opsional: Hapus riwayat login agar tidak bisa 'back' ke login
                                    popUpTo("login") { inclusive = true }
                                }
                            },
                            onDaftarClick = { navController.navigate("register") }
                        )
                    }

                    // 3. Rute Profile
                    composable("profile") {
                        ProfileScreen(
                            onNavigateToAvatar = { navController.navigate("avatar")}
                        )
                    }

                    composable("avatar") {
                        AvatarScreen()
                    }
                }
            }
        }
    }
}
