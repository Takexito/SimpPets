package dev.xaenox.simppets.ui.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.xaenox.simppets.R

typealias OnChanged <T> = (T) -> Unit

// TODO: implement it
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(query: String, onQueryChanged: OnChanged<String>, modifier: Modifier = Modifier) {
    TextField(
        modifier = modifier.border(BorderStroke(1.dp, Color.Cyan)),
        value = query,
        placeholder = { Text(text = "Search") },
        onValueChange = onQueryChanged,
        trailingIcon = {
            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Search icon"
            )
        },
        shape = RoundedCornerShape(8.dp)
    )
}

@Preview
@Composable
private fun SearchBarPreview() {
    SearchBar("Search", {})
}