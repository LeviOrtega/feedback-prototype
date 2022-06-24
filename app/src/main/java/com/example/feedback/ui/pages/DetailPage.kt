package com.example.feedback.ui.pages


import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.feedback.R
import com.example.feedback.ui.theme.FeedbackTheme
import com.microsoft.device.dualscreen.twopanelayout.Screen
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneNavScope

@Composable
fun TwoPaneNavScope.DetailPage(navHostController: NavHostController) {
    Scaffold(
        topBar = { DetailTopBar(navHostController) },
        content = { DetailContent() },

        )
}


@Composable
fun TwoPaneNavScope.DetailTopBar(navHostController: NavHostController) {
    TopAppBar(
        title = { Text(stringResource(id = R.string.bug_details)) },
        navigationIcon = {
            IconButton(onClick = { /*TODO navigate back to my feedback page*/ navHostController.navigateTo(
                "home",
                        Screen.Pane1
            )
            }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        },
        backgroundColor = colors.surface,
        elevation = 0.dp
    )
}

@Composable
fun DetailContent() {
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
    ) {
        DetailPageDetails()
        DetailAdditionalInfo()
        DetailCommentSeparator()
        Comments(modifier = Modifier.fillMaxHeight())
    }
}

@Composable
fun Comments(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        LazyColumn(
            Modifier
                .padding(top = 15.dp, bottom = 15.dp)
                .fillMaxHeight(0.8f)
        ) {
            items(5) { index ->
                Comment()
                Spacer(modifier = Modifier.size(5.dp))
            }
        }

        Divider(color = colors.surface)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxHeight()
                .clickable {/* TODO comment*/ }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.comment),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Text(stringResource(id = R.string.comment), style = typography.subtitle1)
        }
    }
}

@Composable
fun Comment() {
    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            PersonIcon(bgColor = colors.primary, iconColor = colors.onBackground)
            Text(stringResource(id = R.string.username), style = typography.subtitle1)
        }
        Text(stringResource(id = R.string.comment_example), style = typography.subtitle1)

    }
}

@Composable
fun SeeAllButton(modifier: Modifier = Modifier) {
    Button(onClick = { /*TODO See all images*/ }, modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.media),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .padding(end = 5.dp),
                tint = colors.onSurface
            )
            Text(text = stringResource(id = R.string.see_all), color = colors.onSurface)
        }
    }
}

@Composable
fun CommentNum(modifier: Modifier = Modifier, num: Int) {
    Text(
        num.toString() + " " + stringResource(id = R.string.comments),
        style = MaterialTheme.typography.subtitle2,
        modifier = modifier
    )
}

@Composable
fun DetailCommentSeparator() {
    Box(modifier = Modifier.fillMaxWidth()) {
        SeeAllButton(Modifier.align(Alignment.CenterStart))
        CommentNum(num = 2, modifier = Modifier.align(Alignment.CenterEnd))
    }
}

@Composable
fun DetailAdditionalInfo() {
    Column(modifier = Modifier.padding(top = 10.dp, end = 10.dp)) {
        Text(stringResource(id = R.string.build_identity), style = MaterialTheme.typography.caption)

        Row(
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            BugImage()
            BugImage()
            BugImage()
        }
    }
}

@Composable
fun BugImage() {
    Surface(color = colors.secondaryVariant) {
        Image(
            painter = painterResource(id = R.drawable.media),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .size(50.dp)
        )
    }
}


@Composable
fun DetailPageDetails() {
    OutlinedTextField(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxWidth()
            .fillMaxHeight(0.25f),
        value = stringResource(id = R.string.feedback_placeholder),
        readOnly = true,
        onValueChange = {},
        colors = TextFieldDefaults.textFieldColors(
            textColor = colors.onBackground,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = colors.surface,
            unfocusedIndicatorColor = colors.surface
        )
    )
    Row(horizontalArrangement = Arrangement.Center) {
        OutlinedTextField(
            value = stringResource(id = R.string.device_mode),
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .padding(end = 20.dp)
                .fillMaxWidth(0.5f),
            colors = TextFieldDefaults.textFieldColors(
                textColor = colors.onBackground,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = colors.surface,
                unfocusedIndicatorColor = colors.surface
            )
        )
        OutlinedTextField(
            value = stringResource(id = R.string.frequency),
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                textColor = colors.onBackground,
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = colors.surface,
                unfocusedIndicatorColor = colors.surface
            )
        )
    }
}


@Preview
@Composable
fun TwoPaneNavScope.PreviewDetailPage() {
    FeedbackTheme {
        DetailPage(navHostController = rememberNavController())
    }
}