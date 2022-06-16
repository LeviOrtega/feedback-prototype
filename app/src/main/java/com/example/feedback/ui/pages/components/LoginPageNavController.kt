package com.example.feedback.ui.pages.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.feedback.ui.pages.LoginLogos
import com.example.feedback.ui.pages.LoginPageFull
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayout

@Composable
fun LoginPageNav(navController: NavController){
    TwoPaneLayout(
        pane1 = {
            LoginPageFull(navController = navController)
        },
        pane2 = {
            LoginLogos()
        }
    )
}