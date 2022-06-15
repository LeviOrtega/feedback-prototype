package com.example.feedback.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.feedback.R
import com.example.feedback.ui.theme.FeedbackTheme
import com.microsoft.device.dualscreen.twopanelayout.navigateToPane2

var toggle: Boolean by (mutableStateOf(false))

@Composable
fun MyFeedbackPage() {
    Scaffold(
        topBar = { MyFeedbackTopBar() },
        content = { MyFeedbackContent() },
        floatingActionButton = { AddFeedbackFloatingButton() }
    )
}

@Composable
fun AddFeedbackFloatingButton() {
    Button(
        onClick = { /*TODO Navigate to new feedback */ navigateToPane2() },
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.size(65.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.plus),
            contentDescription = null,
            tint = MaterialTheme.colors.onBackground
        )
    }
}

@Composable
fun MyFeedbackTopBar() {
    Column(modifier = Modifier.background(MaterialTheme.colors.surface)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO open menu */ }) {
                Icon(Icons.Filled.Menu, null)
            }
            Text(stringResource(id = R.string.feedback))
        }

        SearchBar(
            Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .size(50.dp)
        )

        FeedbackToggleButtons(
            Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Spacer(Modifier.size(10.dp))
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(stringResource(id = R.string.search)) },
        leadingIcon = { Icon(Icons.Filled.Search, null) },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = MaterialTheme.colors.surface,
            unfocusedIndicatorColor = MaterialTheme.colors.surface
        )
    )
}

@Composable
fun FeedbackToggleButtons(modifier: Modifier = Modifier) {
    Row(modifier) {
        Button(
            modifier = Modifier
                .padding(end = 10.dp)
                .fillMaxWidth(0.5f)
                .size(35.dp),
            shape = MaterialTheme.shapes.medium,
            onClick = { toggle = false },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (!toggle) MaterialTheme.colors.primary else MaterialTheme.colors.secondary,
                contentColor = if (!toggle) MaterialTheme.colors.onBackground else MaterialTheme.colors.secondaryVariant
            )
        ) {
            Text(stringResource(id = R.string.my_feedback))
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .size(35.dp),
            shape = MaterialTheme.shapes.medium,
            onClick = { toggle = true },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (toggle) MaterialTheme.colors.primary else MaterialTheme.colors.secondary,
                contentColor = if (toggle) MaterialTheme.colors.onBackground else MaterialTheme.colors.secondaryVariant
            )
        ) {
            Text(stringResource(id = R.string.latest_feedback))
        }
    }
}

@Composable
fun MyFeedbackContent() {
    if (toggle){
       LatestFeedbackList()
    }
    else {
        MyFeedbackList()
    }
}

@Composable
fun MyFeedbackList(){
    LazyColumn(Modifier.padding(start = 10.dp, end = 10.dp, top = 15.dp)) {
        items(15) { index ->
            FeedbackFragment(
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth()
                    .clickable { /*TODO Navigate to feedback using Index */ },
                titleID = R.string.fragment_title,
                descriptionID = R.string.fragment_description,
                imageID = R.drawable.add_media
            )
        }
    }
}

@Composable
fun LatestFeedbackList(){
    LazyColumn(Modifier.padding(start = 10.dp, end = 10.dp, top = 15.dp)) {
        items(2) { index ->
            FeedbackFragment(
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth()
                    .clickable { /*TODO Navigate to feedback using Index */ },
                titleID = R.string.fragment_title,
                descriptionID = R.string.fragment_description,
                imageID = R.drawable.add_media
            )
        }
    }
}

@Composable
fun FeedbackFragment(
    modifier: Modifier = Modifier,
    titleID: Int,
    descriptionID: Int,
    imageID: Int
) {
    Surface(modifier) {
        Row(
            Modifier.padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = imageID),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                contentDescription = null
            )

            Spacer(Modifier.size(10.dp))

            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    stringResource(id = titleID),
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    stringResource(id = descriptionID),
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}


@Composable
@Preview
fun PreviewMyFeedbackPage() {
    FeedbackTheme {
        MyFeedbackPage()
    }
}

