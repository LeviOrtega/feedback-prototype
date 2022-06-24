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
import androidx.navigation.NavHostController
import com.example.feedback.R

@Composable
fun TermsPage(navHostController: NavHostController){
    Scaffold(
        topBar = { TermsTopBar(navHostController = navHostController) },
        content = { TermsContent() },
    )
}


@Composable
fun TermsTopBar(navHostController: NavHostController) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.terms_of_use)) },
        navigationIcon = {
            IconButton(onClick = { /*TODO navigate back */  navHostController.popBackStack()}) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 0.dp
    )
}

@Composable
fun TermsContent(){
    Text(stringResource(id = R.string.terms_of_use))
}