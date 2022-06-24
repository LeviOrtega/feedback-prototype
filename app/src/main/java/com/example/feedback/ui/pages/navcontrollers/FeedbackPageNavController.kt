package com.example.feedback.ui.pages.navcontrollers

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.feedback.ui.pages.DetailPage
import com.example.feedback.ui.pages.GiveFeedbackPage
import com.example.feedback.ui.pages.MyFeedbackPage
import com.microsoft.device.dualscreen.twopanelayout.Destination
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayoutNav

@Composable
fun MyFeedbackNav(openDrawer: () -> Unit) {
    val navHostController = rememberNavController()
    val destinations = arrayOf(
        Destination("home") {
            MyFeedbackPage(
                navHostController
            ) { openDrawer() }
        },
        Destination("give") { GiveFeedbackPage(navHostController) },
        Destination("detail") { DetailPage(navHostController) },
    )

    TwoPaneLayoutNav(
        navController = navHostController,
        destinations = destinations,
        singlePaneStartDestination = "home",
        pane1StartDestination = "home",
        pane2StartDestination = "give"
    )


}