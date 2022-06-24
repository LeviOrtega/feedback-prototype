package com.example.feedback.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.feedback.R

var signedInBefore: Boolean by (mutableStateOf(true))


@Composable
fun LoginPageFull(navHostController: NavHostController) {
    Scaffold(
        content = { LoginContentFull() },
        bottomBar = { LoginBottomBar(navHostController = navHostController) }
    )
}

@Composable
fun LoginPageHalf(navHostController: NavHostController) {
    Scaffold(
        content = { LoginContentHalf() },
        bottomBar = { LoginBottomBar(navHostController = navHostController) }
    )
}

@Composable
fun LoginContentHalf() {
    Box(Modifier.fillMaxSize()) {
        AppDescription(
            Modifier
                .fillMaxWidth(0.7f)
                .align(Alignment.Center)
        )
    }

}

@Composable
fun LoginContentFull() {
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .align(Alignment.TopCenter)
                // for text rounding
                .fillMaxWidth(0.7f)
                // 10 % of the screen down
                .padding(top = (LocalConfiguration.current.screenHeightDp * 0.1).dp)
        ) {
            LoginLogos(Modifier.fillMaxWidth())
            AppDescription(Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun LoginBottomBar(navHostController: NavHostController) {
    Column {
        if (signedInBefore) {
            LoginSignInChoices(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
            )
        } else {
            LoginSignInButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
            )
        }

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
                    .align(Alignment.CenterEnd)
                    .width(70.dp)
                    .height(40.dp),
                onClick = {/*TODO navigate to FRE*/ navHostController.navigate("fre") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                border = BorderStroke(1.dp, MaterialTheme.colors.onBackground)
            ) {
                Text(stringResource(id = R.string.skip))
            }
        }
    }
}

@Composable
fun LoginSignInChoices(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Button(
            modifier = modifier,
            onClick = { /*TODO Sign in*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
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
                    Text(
                        stringResource(id = R.string.placeholder_email),
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }

        }
        Button(
            modifier = modifier,
            onClick = { /*TODO Choose other account*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
        ) {
            Box(Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.align(Alignment.CenterStart),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PersonIcon(
                        bgColor = MaterialTheme.colors.secondaryVariant,
                        iconColor = MaterialTheme.colors.onBackground
                    )
                    Text(
                        stringResource(id = R.string.other_account),
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginSignInButton(modifier: Modifier = Modifier) {
    Button(
        modifier = modifier.height(40.dp),
        onClick = { /*TODO Sign in*/ },
        colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colors.onSurface)
    ) {
        Text(stringResource(id = R.string.sign_in))
    }
}

@Composable
fun LoginLogos(modifier: Modifier = Modifier) {

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier.size(50.dp),
            painter = painterResource(id = R.drawable.microsoft_logo),
            contentDescription = null
        )
        Spacer(Modifier.size(30.dp))
        Image(
            modifier = Modifier.size(130.dp),
            painter = painterResource(id = R.drawable.feedback_logo),
            contentDescription = null
        )
    }
}

@Composable
fun PersonIcon(bgColor: Color, iconColor: Color) {
    Surface(shape = MaterialTheme.shapes.large, color = bgColor) {
        Icon(
            painterResource(id = R.drawable.person),
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier
                .size(30.dp)
                .padding(5.dp)
        )
    }
}

@Composable
fun AppDescription(modifier: Modifier = Modifier) {
    Column(modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            stringResource(id = R.string.feedback_for_surface_duo),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2
        )
        Text(
            stringResource(id = R.string.app_description),
            modifier = Modifier.padding(top = 10.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2
        )
    }
}


//@Preview
//@Composable
//fun PreviewLoginPageFull() {
//    FeedbackTheme {
//        LoginPageFull()
//    }
//}

