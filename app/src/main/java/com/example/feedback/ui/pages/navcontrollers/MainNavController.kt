package com.example.feedback.ui.pages.navcontrollers


import androidx.compose.material.DrawerValue
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feedback.ui.pages.DetailPage
import com.example.feedback.ui.pages.PrivacyStatementPage
import com.example.feedback.ui.pages.TermsPage
import com.example.feedback.ui.pages.components.DrawerWrapper
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayout
import com.microsoft.device.dualscreen.windowstate.WindowState
import kotlinx.coroutines.launch


@Composable
fun PageManager(windowState: WindowState) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // any page can open the drawer just pass this val to it, closing is handled by the drawer
    val updateDrawerState: (DrawerValue) -> Unit = { drawerValue ->
        scope.launch {
            when (drawerValue) {
                DrawerValue.Closed -> {
                    drawerState.close()
                }
                DrawerValue.Open -> {
                    drawerState.open()
                }
            }
        }
    }
    // Drawer must wrap the nav host
    DrawerWrapper(
        drawerContent = {
            NavHost(navController = navController, startDestination = "login") {
                composable("login") { LoginPageNav(navController, windowState) }
                composable("fre") { FRENav(navController, windowState) }
                composable("privacy") { PrivacyStatementPage(navController) }
                composable("terms") { TermsPage(navController) }
                composable("detail") { DetailPage(navController) }
                composable("feedback") {
                    // we only need to handle opening the drawer so just pass that value in the function to call
                    MyFeedbackNav(navController) { updateDrawerState(DrawerValue.Open) }
                }

            }
        },
        navController = navController,
        drawerState = drawerState,
        updateDrawerState = updateDrawerState
    )

}