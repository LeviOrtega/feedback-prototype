package com.example.feedback.ui.pages.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerValue
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.feedback.ui.pages.PersonIcon
import com.example.feedback.ui.theme.customShape
import kotlinx.coroutines.launch


// all of the routes that are in the drawer screen
sealed class DrawerScreens(val title: String, val route: String) {
    object Login : DrawerScreens("Login", "login")
    object FRE : DrawerScreens("Fre", "fre")
    object Feedback : DrawerScreens("Feedback", "feedback")
}

private val screens = listOf(
    DrawerScreens.Login,
    DrawerScreens.FRE,
    DrawerScreens.Feedback
)

@Composable
fun DrawerWrapper(
    drawerContent: @Composable (openDrawer: () -> Unit) -> Unit,
    navController: NavController
) {
    val configuration = LocalConfiguration.current
    val density = configuration.densityDpi / 160f
    val w = (configuration.screenWidthDp.toFloat() * density) / 3.0f
    val h = (configuration.screenHeightDp.toFloat() * density) + 1.0f

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val openDrawer = {
        scope.launch {
            drawerState.open()
        }
    }
    ModalDrawer(
        modifier = Modifier.fillMaxSize(),
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerShape = customShape(w, h),
        drawerContent = {
            Drawer(
                onDestinationClicked = { route: String ->
                    scope.launch {
                        drawerState.close()
                    }
                    navController.navigate(route) {
                        popUpTo(DrawerScreens.Feedback.route)
                        launchSingleTop = true
                    }
                }
            )
        }
    ) {
        drawerContent { openDrawer() }
    }
}


@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit

) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        PersonIcon(
            bgColor = MaterialTheme.colors.primary,
            iconColor = MaterialTheme.colors.onBackground
        )
        screens.forEach { screen ->
            Spacer(Modifier.height(14.dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.clickable {
                    onDestinationClicked(screen.route)
                }
            )
        }
    }
}