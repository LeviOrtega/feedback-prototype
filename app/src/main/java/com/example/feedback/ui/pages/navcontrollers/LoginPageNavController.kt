package com.example.feedback.ui.pages.navcontrollers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.feedback.ui.pages.LoginLogos
import com.example.feedback.ui.pages.LoginPageFull
import com.example.feedback.ui.pages.LoginPageHalf
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayout
import com.microsoft.device.dualscreen.windowstate.WindowState

@Composable
fun LoginPageNav(navController: NavController, windowState: WindowState) {
    TwoPaneLayout(
        pane1 = {
            if (windowState.isDualScreen()) {
                Box(modifier = Modifier.fillMaxSize()) {
                    LoginLogos(Modifier.align(Alignment.Center))
                }
            } else {
                LoginPageFull(navController = navController)
            }
        },
        pane2 = {
            LoginPageHalf(navController = navController)
        }
    )
}