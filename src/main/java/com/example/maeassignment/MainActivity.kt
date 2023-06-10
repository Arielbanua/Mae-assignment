package com.example.maeassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.maeassignment.ui.theme.MaeassignmentTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appDatabase = AppDatabase.getInstance(this)
        setContent {
            MaeassignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TrackItApp()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TrackItApp() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val userDao = AppDatabase.getInstance(context).userDao()
    val userRepository = UserRepository(userDao)


    NavHost(navController = navController, startDestination = "login") {
        composable("expense") {
            ExpenseScreen(navController = navController, viewModel = FinanceViewModel(context))
        }
        composable("budget") {
            BudgetScreen(navController = navController, viewModel = FinanceViewModel(context))
        }
        composable("login") {
            LoginScreen(navController = navController, viewModel = AuthViewModel(userRepository))
        }
        composable("register") {
            RegisterScreen(navController = navController, viewModel = AuthViewModel(userRepository))
        }
    }
}


