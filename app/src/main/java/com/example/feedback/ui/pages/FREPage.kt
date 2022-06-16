package com.example.feedback.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feedback.R


@Composable
fun FREPageFull(navController: NavController) {
    Scaffold(
        content = { FREContentFull() },
        bottomBar = { FREBottomBar(navController = navController) }
    )
}

@Composable
fun FREPageHalf(navController: NavController) {
    Scaffold(
        content = { FREContentHalf() },
        bottomBar = { FREBottomBar(navController = navController) }
    )
}

@Composable
fun FREContentHalf() {
    Box(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .align(Alignment.Center)
        ) {
            AppDisclaimer()
            Box(Modifier.fillMaxWidth()) {
                PrivacyPolicyButton(Modifier.align(Alignment.Center))
            }

        }
    }

}

@Composable
fun FREContentFull() {
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .align(Alignment.TopCenter)
                // for text rounding
                .fillMaxWidth(0.7f)
                // 20 % of the screen down
                .padding(top = (LocalConfiguration.current.screenHeightDp * 0.2).dp)
        ) {
            FRELogo(Modifier.fillMaxWidth())
            AppDisclaimer(Modifier.fillMaxWidth())
            Box(Modifier.fillMaxWidth()) {
                PrivacyPolicyButton(Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
fun FREBottomBar(navController: NavController) {
    Column {
        Divider(
            color = MaterialTheme.colors.surface,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp, start = 10.dp, end = 10.dp)
        ) {
            OutlinedButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                onClick = {/*TODO navigate to feedback*/ navController.navigate("feedback") },
                colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colors.onSurface),
            ) {
                Text(stringResource(id = R.string.accept))
            }
        }
    }
}

@Composable
fun FRELogo(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(130.dp),
        painter = painterResource(id = R.drawable.feedback_logo),
        contentDescription = null
    )
}


@Composable
fun AppDisclaimer(modifier: Modifier = Modifier) {
    Column(modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            stringResource(id = R.string.we_want_hear),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2
        )
        Text(
            stringResource(id = R.string.disclaimer_1),
            modifier = Modifier.padding(top = 10.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2
        )
        Text(
            stringResource(id = R.string.disclaimer_2),
            modifier = Modifier.padding(top = 10.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2
        )
    }
}

