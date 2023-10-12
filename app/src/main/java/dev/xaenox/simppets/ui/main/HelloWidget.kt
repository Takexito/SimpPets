package dev.xaenox.simppets.ui.main

import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage

@Composable
fun HelloWidget(name: String, imageUri: Uri, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(64.dp)
                    .border(BorderStroke(2.dp, Color.White), CircleShape)
                    .clip(CircleShape)
                    .zIndex(10f)
                    .background(Color.White),
                model = imageUri,
                contentDescription = null,
                error = rememberVectorPainter(
                    image = Icons.Filled.AccountCircle
                )
            )

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .offset(x = (-24).dp)
                    .zIndex(-1f),
                color = Color.LightGray,
                shadowElevation = 0.dp,
                shape = RoundedCornerShape(60)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xCCFFFFFF))
                        .padding(start = 40.dp, end = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Hello, $name!",
                        fontSize = 16.sp,
                        color = Color(0xFF000000),
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun HelloWidgetPreview() {
    HelloWidget("Name", Uri.EMPTY)
}