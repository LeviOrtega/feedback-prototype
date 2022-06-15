package com.example.feedback.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.feedback.R
import com.example.feedback.ui.theme.FeedbackTheme

@Composable
fun LoginPage() {
    Scaffold(
        content = { LoginContent() },
        bottomBar = { LoginBottomBar() }
    )
}

@Composable
fun LoginContent() {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        LoginLogos()
        AppDescription()
    }
}

@Composable
fun LoginBottomBar() {
    BottomNavigation(elevation = 10.dp, backgroundColor = Color.Transparent) {
        OutlinedButton(
            onClick = {/*TODO navigate to FRE*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
        ) {
            Text(stringResource(id = R.string.skip), modifier = Modifier)
        }
    }
}


@Composable
fun LoginLogos() {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.add_media),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
            contentDescription = null
        )
        Image(
            painter = painterResource(id = R.drawable.add_media),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
            contentDescription = null
        )
    }
}


@Composable
fun AppDescription() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(stringResource(id = R.string.feedback_for_surface_duo))
        Text(stringResource(id = R.string.app_description))
    }
}


@Preview
@Composable
fun PreviewLoginPage() {
    FeedbackTheme {
        LoginPage()
    }
}

