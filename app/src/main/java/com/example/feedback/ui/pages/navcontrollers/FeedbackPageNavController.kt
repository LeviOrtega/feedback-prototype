package com.example.feedback.ui.pages.navcontrollers

import androidx.compose.material.DrawerValue
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.feedback.ui.pages.DetailPage
import com.example.feedback.ui.pages.GiveFeedbackPage
import com.example.feedback.ui.pages.MyFeedbackPage
import com.example.feedback.ui.pages.PrivacyStatementPage
import com.example.feedback.ui.pages.TermsPage
import com.microsoft.device.dualscreen.twopanelayout.Destination
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayout
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayoutNav
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneMode
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneNavScope

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