package com.example.feedback.ui.pages

import android.view.WindowManager
import androidx.compose.runtime.Composable
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayout
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneMode

@Composable
fun PageManager(windowManager: WindowManager){

    TwoPaneLayout(
        paneMode = TwoPaneMode.TwoPane,
        pane1 = {
               MyFeedbackPage()
        },
        pane2 = {
               GiveFeedbackPage()
        }
    )
}