package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.features.activities.ActivitiesScreen
import com.example.features.home.HomeScreen
import com.example.features.sessions.ContinueSessionScreen
import com.example.features.sessions.NewSessionScreen
import com.example.features.students.StudentsScreen
import com.example.shared.theme.PrismaTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      PrismaTheme {
        val navController = rememberNavController()
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = androidx.compose.material3.MaterialTheme.colorScheme.background
        ) {
          NavHost(
            navController = navController,
            startDestination = "home"
          ) {
            composable("home") {
              HomeScreen(
                onNavigateToContinueSession = { navController.navigate("continue_session") },
                onNavigateToNewSession = { navController.navigate("new_session") },
                onNavigateToStudents = { navController.navigate("students") },
                onNavigateToActivities = { navController.navigate("activities") }
              )
            }
            composable("continue_session") {
              ContinueSessionScreen(onNavigateBack = { navController.popBackStack() })
            }
            composable("new_session") {
              NewSessionScreen(onNavigateBack = { navController.popBackStack() })
            }
            composable("students") {
              StudentsScreen(onNavigateBack = { navController.popBackStack() })
            }
            composable("activities") {
              ActivitiesScreen(onNavigateBack = { navController.popBackStack() })
            }
          }
        }
      }
    }
  }
}

