package com.example.feedback.ui.pages

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feedback.R

@Composable
fun PrivacyStatementPage(navController: NavController){
    Scaffold(
        topBar = { PrivacyStatementTopBar(navController = navController) },
        content = { PrivacyStatementContent() },
    )
}


@Composable
fun PrivacyStatementTopBar(navController: NavController) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.privacy_statement)) },
        navigationIcon = {
            IconButton(onClick = { /*TODO navigate back */  navController.popBackStack()}) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 0.dp
    )
}

@Composable
fun PrivacyStatementContent(){
    Text(stringResource(id = R.string.privacy_statement))
}