package com.example.feedback.ui.pages.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.feedback.ui.pages.GiveFeedbackPage
import com.example.feedback.ui.pages.MyFeedbackPage
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayout

@Composable
fun FeedbackPageNav(navController: NavController){
    TwoPaneLayout(
        pane1 = {
           MyFeedbackPage()
        },
        pane2 = {
            GiveFeedbackPage()
        }
    )
}