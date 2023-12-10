package dev.xaenox.simppets.ui.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.xaenox.simppets.ui.main.BackButton
import dev.xaenox.simppets.ui.main.Toolbar

@Composable
fun CalendarScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .verticalScroll(scrollState)
    ) {
        Toolbar(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.217f),
            backgroundGradient = listOf(Color(0xFFCFCEFB), Color(0xFFAEC9CB)),
            buttons = {
                BackButton()
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-80).dp)
                    .padding(16.dp)
            ) {
                TopBar()
                CalendarView()
            }
            Text(text = "Ближайшее событие")
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(24.dp))
            EventCard()
            Spacer(modifier = Modifier.height(24.dp))
            CategoriesRow()
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun TopBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { /* Handle back navigation */ }) {
            Icon(Icons.Default.KeyboardArrowLeft, contentDescription = "Go back")
        }
        Text("Март 2023") // Use proper localization here
        IconButton(onClick = { /* Handle forward navigation */ }) {
            Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Go forward")
        }
    }
}

@Composable
fun CalendarView() {
    // Implement a grid view here. This is a simplified version.
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        columns = GridCells.Fixed(7),
        contentPadding = PaddingValues(16.dp)
    ) {
        // Dynamically generate the calendar cells
        items(30) { day ->
            Text(text = "${day + 1}", modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun EventCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2f)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(), verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Нет события",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            // ... other event details
        }
    }
}

@Composable
fun CategoriesRow() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CategoryCard("Процедуры", Icons.Default.Settings, Modifier.fillMaxWidth())
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CategoryCard("Прививки", Icons.Default.Call, Modifier.weight(1f))
            CategoryCard("Посещения", Icons.Default.Settings, Modifier.weight(1f))
        }
    }
}

@Composable
fun CategoryCard(name: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Card(modifier) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null)
            Text(name, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun PreviewCalendarScreen() {
    CalendarScreen()
}