package com.example.feedback.ui.pages.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.DrawerState
import androidx.compose.material.DrawerValue
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.feedback.R
import com.example.feedback.ui.pages.PersonIcon
import com.example.feedback.ui.theme.customShape
import kotlinx.coroutines.launch


class DrawerScreens(val title: String, val route: String) {}

@Composable
private fun screens(): List<DrawerScreens> {
    return listOf(
        DrawerScreens(stringResource(id = R.string.home), "feedback"),
        DrawerScreens(stringResource(id = R.string.privacy_statement), "privacy"),
        DrawerScreens(stringResource(id = R.string.terms_of_use), "terms"),
        DrawerScreens(stringResource(id = R.string.sign_in), "login"),

    )
}

@Composable
fun DrawerWrapper(
    drawerContent: @Composable () -> Unit,
    navController: NavController,
    drawerState: DrawerState,
    updateDrawerState: (DrawerValue) -> Unit,
) {
    val homeScreen = "feedback"

    // ModalDrawer does not have a way to set its size manually, so you have to do it by setting its shape. Shapes don't take DP, only floats, so we do manual conversion here
    val configuration = LocalConfiguration.current
    val density = configuration.densityDpi / 160f
    val width = (configuration.screenWidthDp.toFloat() * density) / 2.5f
    // Add additional pixels here so that I can avoid the ugliness of ceiling rounding with doubles
    val height = (configuration.screenHeightDp.toFloat() * density) + 2.0f

    ModalDrawer(
        modifier = Modifier.fillMaxSize(),
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerShape = customShape(width, height),
        drawerContent = {
            Drawer(
                onDestinationClicked = { route: String ->
                    updateDrawerState(DrawerValue.Closed)
                    navController.navigate(route) {
                        popUpTo(homeScreen)
                        launchSingleTop = true
                    }
                },
                navController = navController
            )
        }
    ) {
        drawerContent()
    }
}

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit,
    navController: NavController

) {

    Column(
        modifier
            .fillMaxSize()
            .padding(start = 10.dp, top = 48.dp)
    ) {
        Box(Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                PersonIcon(
                    bgColor = MaterialTheme.colors.onBackground,
                    iconColor = MaterialTheme.colors.primary
                )
                Column(horizontalAlignment = Alignment.Start){
                    Text(
                        stringResource(id = R.string.username),
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                        stringResource(id = R.string.placeholder_email),
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(start = 10.dp),
                        style = MaterialTheme.typography.caption
                    )
                }
            }
        }
        screens().forEach { screen ->
            Spacer(Modifier.height(14.dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.subtitle1,
                color = if (screen.title == "Home") MaterialTheme.colors.primary else MaterialTheme.colors.onBackground,
                modifier = Modifier.clickable {
                    onDestinationClicked(screen.route)
                }
            )
        }
    }
}