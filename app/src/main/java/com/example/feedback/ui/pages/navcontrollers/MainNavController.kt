package com.example.feedback.ui.pages


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DrawerValue
import androidx.compose.material.ModalDrawer
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feedback.ui.pages.components.Drawer
import com.example.feedback.ui.pages.components.DrawerScreens
import com.example.feedback.ui.pages.components.DrawerWrapper
import com.example.feedback.ui.pages.components.LoginPageNav
import com.example.feedback.ui.pages.components.MyFeedbackNav
import com.example.feedback.ui.pages.navcontrollers.FRENav
import com.example.feedback.ui.theme.customShape
import com.microsoft.device.dualscreen.windowstate.WindowState
import kotlinx.coroutines.launch


// Modal Drawers cannot have their sizes set, so you must pass it a custom shape

@Composable
fun PageManager(windowState: WindowState) {
    val navController = rememberNavController()
    DrawerWrapper(drawerContent = {
        NavHost(navController = navController, startDestination = "login") {
            composable("login") { LoginPageNav(navController, windowState) }
            composable("fre") { FRENav(navController, windowState) }
            composable("feedback") { MyFeedbackNav(navController) { open } }

        }
    }, navController = navController)

}