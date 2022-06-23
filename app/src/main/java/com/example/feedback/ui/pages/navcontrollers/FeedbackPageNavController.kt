package com.example.feedback.ui.pages.navcontrollers

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.feedback.ui.pages.GiveFeedbackPage
import com.example.feedback.ui.pages.MyFeedbackPage
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayout
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneMode

@Composable
fun MyFeedbackNav(navController: NavController, openDrawer: () -> Unit) {
    TwoPaneLayout(
        paneMode = TwoPaneMode.HorizontalSingle,
        pane1 = {
            MyFeedbackPage(navController, openDrawer)
        },
        pane2 = {
            GiveFeedbackPage(navController)
        }
    )
}