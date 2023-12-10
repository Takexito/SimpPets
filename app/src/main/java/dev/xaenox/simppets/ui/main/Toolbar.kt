package dev.xaenox.simppets.ui.main

import android.net.Uri
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.xaenox.simppets.navigation.Navigator

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    backgroundGradient: List<Color> = listOf(Color(0xFFF6DBD0), Color(0xFFFAD4E1)),
    buttons: @Composable ColumnScope.() -> Unit,
    content: @Composable ColumnScope.() -> Unit = {}
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp),
        color = Color.Transparent,
        shadowElevation = 0.dp
    ) {
        Box(modifier = Modifier) {
            HorizontalGradient(
                listOfColors = backgroundGradient,
                modifier = Modifier.matchParentSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 16.dp)
            ) {
                buttons()
                content()
            }
        }
    }
}


@Composable
fun ColumnScope.BackButton(onClick: () -> Unit = { Navigator.navigateBack() }) {
    IconButton(
        onClick = { onClick() }, modifier = Modifier
            .size(32.dp)
            .align(Alignment.Start)
    ) {
        Icon(Icons.Default.ArrowBack, contentDescription = "Go back")
    }
}

@Composable
fun ColumnScope.SettingsButton(onClick: () -> Unit) {
    Icon(
        modifier = Modifier
            .size(32.dp)
            .align(Alignment.End)
            .clickable { onClick() },
        imageVector = Icons.Outlined.Settings,
        contentDescription = "Settings Button",
        tint = Color(0xCCFFFFFF)
    )
}

@Composable
fun HorizontalGradient(
    listOfColors: List<Color>,
    modifier: Modifier = Modifier,
    startX: Float = 0f
) {
    val brush = Brush.horizontalGradient(listOfColors, startX)
    Canvas(
        modifier = modifier,
        onDraw = {
            drawRect(brush)
        }
    )
}

@Preview
@Composable
private fun ToolbarPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        Toolbar(
            buttons = { SettingsButton {} }
        ) {
            HelloWidget("Name", Uri.EMPTY, Modifier.fillMaxWidth())
        }
    }
}