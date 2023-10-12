package dev.xaenox.simppets.ui.pet_details

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.xaenox.simppets.R
import dev.xaenox.simppets.ui.main.Event

@Composable
fun PetDetailsUI(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.4f),
            model = "",
            contentDescription = "Pet image"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Name",
                    modifier = Modifier,
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    color = Color(0xFF320071)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_cat),
                    contentDescription = "type"
                )

                Spacer(modifier = Modifier.width(4.dp))

                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_male),
                    contentDescription = "gender"
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_dog),
                    contentDescription = "edit"
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Species",
                    modifier = Modifier,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = Color(0xFF000000),
                    letterSpacing = 2.76.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "3",
                    modifier = Modifier,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 36.sp,
                    color = Color(0xFF721CFF),
                )

                Text(
                    text = "years",
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(bottom = 8.dp, start = 8.dp),
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    color = Color(0xFF000000),
                )

                Spacer(modifier = Modifier.width(40.dp))

                Text(
                    text = "3,5",
                    modifier = Modifier,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 36.sp,
                    color = Color(0xFF000000),
                )

                Text(
                    text = "kg",
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(bottom = 8.dp, start = 8.dp),
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    color = Color(0xFF000000),
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Event(event = null, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Документы",
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color(0xFF320071)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /* handle dialog confirm button click */ },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFFE7E7FD)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                )
            ) {
                Text(
                    text = "Паспорт",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }

            Button(
                onClick = { /* handle dialog confirm button click */ },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                )
            ) {
                Text(
                    text = "+",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 32.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetDetailsUIPreview() {
    PetDetailsUI(Modifier.fillMaxSize())
}
