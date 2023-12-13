package com.mbmcode.wowplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mbmcode.wowplayer.ui.screens.AddPlayerScreen
import com.mbmcode.wowplayer.ui.screens.PlayerMainScreen
import com.mbmcode.wowplayer.ui.theme.WowPlayerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WowPlayerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MyNavHost(navController = navController)
                }
            }
        }
    }
}

enum class Dest(val title: String) { MAIN("Wow Player"), ADD("Add Player Detail") }

@Composable
fun MyNavHost(navController: NavHostController) = NavHost(
    navController = navController,
    startDestination = Dest.MAIN.name
) {
        composable(route = Dest.MAIN.name) {
            PlayerMainScreen(navController)
        }
        composable(route = Dest.ADD.name) {
            AddPlayerScreen(navController)
        }
    }