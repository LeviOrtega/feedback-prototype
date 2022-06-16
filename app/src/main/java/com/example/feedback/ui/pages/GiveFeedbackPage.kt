package com.example.feedback.ui.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.feedback.R
import com.example.feedback.ui.pages.components.DropDown
import com.example.feedback.ui.theme.FeedbackTheme
import com.microsoft.device.dualscreen.twopanelayout.navigateToPane1

@Composable
fun GiveFeedbackPage() {
    Scaffold(
        topBar = { GiveFeedbackTopBar() },
        content = { GiveFeedbackContent() },
        bottomBar = { GiveFeedbackBottomBar() }
    )
}

@Composable
fun GiveFeedbackBottomBar() {
    Divider(color = colors.surface)
    BottomNavigation(elevation = 10.dp, backgroundColor = Color.Transparent) {

        PrivacyPolicyButton(
            Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 20.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 10.dp)
        ) {

            OutlinedButton(
                onClick = { navigateToPane1() /* TODO Cancel clears all values as well? Important for dual mode when this page doesnt navigate anywhere*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                border = BorderStroke(1.dp, colors.onBackground)
            ) {
                Text(stringResource(id = R.string.cancel), modifier = Modifier)
            }

            Spacer(modifier = Modifier.size(10.dp))

            Button(
                onClick = {/*TODO navigate on submit*/ navigateToPane1() },
                colors = ButtonDefaults.buttonColors(contentColor = colors.onSurface)
            ) {
                Text(stringResource(id = R.string.submit))
            }
        }
    }
}

@Composable
fun PrivacyPolicyButton(modifier: Modifier = Modifier) {
    Text(stringResource(id = R.string.privacy_statement),
        color = MaterialTheme.colors.primary,
        modifier = modifier
            .clickable { /*TODO navigate to privacy policy*/ }
    )
}

@Composable
fun GiveFeedbackTopBar() {
    TopAppBar(
        title = { Text(stringResource(id = R.string.give_feedback_nav)) },
        navigationIcon = {
            IconButton(onClick = { /*TODO navigate back to my feedback page*/ navigateToPane1() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        backgroundColor = colors.surface,
        elevation = 0.dp
    )
}

@Composable
fun GiveFeedbackContent() {
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
    ) {
        GiveFeedbackDetails()
        GiveFeedbackAdditionalInfo()
        AddMediaButton()
    }
}

@Composable
fun AddMediaButton() {
    Button(onClick = { /*TODO Add Media*/ }, modifier = Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.add_media),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .padding(end = 5.dp),
                tint = colors.onSurface
            )
            Text(text = stringResource(id = R.string.add_media), color = colors.onSurface)
        }
    }
}

// This opt in is for removing defualt padding on the check box
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GiveFeedbackAdditionalInfo() {
    var check by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(
                painterResource(id = R.drawable.help),
                contentDescription = null,
                tint = colors.onBackground,
                modifier = Modifier.size(20.dp)
            )
            Text(
                stringResource(id = R.string.include_additional),
                color = colors.onBackground,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
        CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
            Checkbox(
                checked = check,
                onCheckedChange = { check = !check },
                modifier = Modifier.align(Alignment.CenterEnd),
                colors = CheckboxDefaults.colors(
                    checkedColor = colors.onBackground,
                    checkmarkColor = MaterialTheme.colors.background,
                    uncheckedColor = colors.onBackground
                )
            )
        }

    }
}

@Composable
fun GiveFeedbackDetails() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.25f),
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(stringResource(id = R.string.feedback_placeholder)) },
        colors = TextFieldDefaults.textFieldColors(
            textColor = colors.onBackground,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = colors.surface,
            unfocusedIndicatorColor = colors.surface
        )
    )
    Row(horizontalArrangement = Arrangement.Center) {
        DropDown(
            stringArrayResource(id = R.array.device_mode_list),
            stringResource(id = R.string.device_mode),
            modifier = Modifier
                .padding(end = 20.dp)
                .fillMaxWidth(0.5f)
        )
        DropDown(
            stringArrayResource(id = R.array.frequency_list),
            stringResource(id = R.string.frequency),
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview
@Composable
fun previewGiveFeedbackPage() {
    FeedbackTheme {
        GiveFeedbackPage()
    }
}