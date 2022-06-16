package com.example.feedback.ui.pages

import android.view.WindowManager
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feedback.ui.pages.components.MyFeedbackNav
import com.example.feedback.ui.pages.components.LoginPageNav
import com.example.feedback.ui.pages.navcontrollers.FRENav
import com.microsoft.device.dualscreen.windowstate.WindowState

@Composable
fun PageManager(windowState: WindowState){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginPageNav(navController, windowState) }
        composable("fre") { FRENav(navController, windowState) }
        composable("feedback") { MyFeedbackNav(navController) }

    }
}