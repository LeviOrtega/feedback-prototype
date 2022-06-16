package com.example.feedback.ui.pages

import android.view.WindowManager
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feedback.ui.pages.components.FeedbackPageNav
import com.example.feedback.ui.pages.components.LoginPageNav
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayout
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneMode

@Composable
fun PageManager(windowManager: WindowManager){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginPageNav(navController) }
        composable("feedback") { FeedbackPageNav(navController) }

    }
}