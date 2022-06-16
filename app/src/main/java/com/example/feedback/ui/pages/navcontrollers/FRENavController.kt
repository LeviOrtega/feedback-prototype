package com.example.feedback.ui.pages.navcontrollers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.feedback.ui.pages.FRELogo
import com.example.feedback.ui.pages.FREPageFull
import com.example.feedback.ui.pages.FREPageHalf
import com.example.feedback.ui.pages.LoginLogos
import com.example.feedback.ui.pages.LoginPageFull
import com.example.feedback.ui.pages.LoginPageHalf
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayout
import com.microsoft.device.dualscreen.windowstate.WindowState

@Composable
fun FRENav(navController: NavController, windowState: WindowState){
    TwoPaneLayout(
        pane1 = {
            if (windowState.isDualScreen()){
                Box(modifier = Modifier.fillMaxSize()){
                    FRELogo(Modifier.align(Alignment.Center))
                }
            }
            else {
                FREPageFull(navController = navController)
            }
        },
        pane2 = {
            FREPageHalf(navController = navController)
        }
    )
}