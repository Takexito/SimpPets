package dev.xaenox.simppets.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Event(
    val name: String,
    val date: String,
    val time: String,
    val petName: String
)

@Composable
fun EventsBlock(event: Event?, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Ближайшие события",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF320071)
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (event != null) {
            Event(event)
        }
    }
}

@Composable
fun Event(event: Event?, modifier: Modifier = Modifier) {
    if (event != null) {
        EventCard(event)
    } else {
        EmptyEventCard()
    }
}

@Composable
private fun EmptyEventCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(4.5f),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.elevatedCardElevation(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                modifier = Modifier,
                text = "Событий не найдено",
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun EventCard(event: Event) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(4.5f),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0x66CFCEFB))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxHeight(),
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Event icon"
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = event.petName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF320071)
                )
                Text(
                    text = event.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
                Text(
                    text = "${event.date} ${event.time}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EventsBlockPreview() {
    EventsBlock(Event("Event 1", "2022-01-01", "12:00", "Dog"))
}

@Preview(showBackground = true)
@Composable
private fun EventPreview() {
    Event(Event("Event 1", "2022-01-01", "12:00", "Dog"))
}

@Preview(showBackground = true)
@Composable
private fun EmptyEventPreview() {
    Event(null)
}