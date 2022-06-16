package com.example.feedback.ui.pages.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.feedback.ui.pages.GiveFeedbackPage
import com.example.feedback.ui.pages.MyFeedbackPage
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayout
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneMode

@Composable
fun MyFeedbackNav(navController: NavController){
    TwoPaneLayout(
        paneMode = TwoPaneMode.HorizontalSingle,
        pane1 = {
           MyFeedbackPage()
        },
        pane2 = {
            GiveFeedbackPage()
        }
    )
}