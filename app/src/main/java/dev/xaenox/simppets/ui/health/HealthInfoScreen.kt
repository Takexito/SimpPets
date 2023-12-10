package dev.xaenox.simppets.ui.health

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.xaenox.simppets.data.PetsRepository
import dev.xaenox.simppets.entities.Pet
import dev.xaenox.simppets.ui.add_pet.TextFieldInput
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate

@Composable
fun ScrollableContent(
    scrollState: ScrollState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        AnimatedVisibility(
            modifier = Modifier
                .padding(top = 0.dp)
                .align(Alignment.TopCenter),
            visible = scrollState.canScrollBackward
        ) {
            ScrollIndicator(icon = Icons.Default.KeyboardArrowUp, modifier = Modifier.padding(0.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .matchParentSize()
                .padding(vertical = 24.dp, horizontal = 20.dp)
                .verticalScroll(scrollState)
        ) {
            content()
        }

        AnimatedVisibility(
            modifier = Modifier
                .padding(bottom = 0.dp)
                .align(Alignment.BottomCenter),
            visible = scrollState.canScrollForward
        ) {
            ScrollIndicator(
                icon = Icons.Default.KeyboardArrowDown,
                modifier = Modifier.padding(0.dp)
            )
        }
    }
}

@Composable
fun ScrollIndicator(modifier: Modifier = Modifier, icon: ImageVector) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {

        IconButton(
            onClick = { /* handle dialog confirm button click */ },
            modifier = Modifier
                .padding(8.dp)
                .size(24.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Scroll Indicator",
                tint = Color.Black
            )
        }

    }
}

@Composable
fun HealthInfoScreen(
    modifier: Modifier = Modifier
) {
    var species by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var breed by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var housing by remember { mutableStateOf("") }
    var parks by remember { mutableStateOf("") }
    var abroad by remember { mutableStateOf("") }
    var sterilization by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }
    var stance by remember { mutableStateOf("") }
    var bodytype by remember { mutableStateOf("") }
    var fatness by remember { mutableStateOf("") }
    var activity by remember { mutableStateOf("") }
    var development by remember { mutableStateOf("") }
    var isondiet by remember { mutableStateOf("") }
    var stool by remember { mutableStateOf("") }
    var meat by remember { mutableStateOf("") }
    var feeding by remember { mutableStateOf("") }
    var convulsions by remember { mutableStateOf("") }
    var lungdisease by remember { mutableStateOf("") }
    var heartdisease by remember { mutableStateOf("") }
    var temperature by remember { mutableStateOf("") }
    var appetite by remember { mutableStateOf("") }
    var vomit by remember { mutableStateOf("") }
    var diarrhea by remember { mutableStateOf("") }
    var urination by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFBE6ED),
                        Color(0xFFE0E3F6)
                    )
                )
            )
            .padding(16.dp)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
            text = "Здоровье",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF320071)
            )
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(20.dp),
            contentColor = Color.Unspecified,
            color = Color.White
        ) {
            ScrollableContent(
                scrollState,
                Modifier.fillMaxWidth()
            ) {
                TextFieldInput(
                    value = species,
                    onValueChange = { species = it },
                    label = "Вид",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = gender,
                    onValueChange = { gender = it },
                    label = "Пол",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = breed,
                    onValueChange = { breed = it },
                    label = "Порода",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = age,
                    onValueChange = { age = it },
                    label = "Возраст",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = weight,
                    onValueChange = { weight = it },
                    label = "Вес",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = housing,
                    onValueChange = { housing = it },
                    label = "Содержание",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = parks,
                    onValueChange = { parks = it },
                    label = "Постоянные прогулки в парках",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = abroad,
                    onValueChange = { abroad = it },
                    label = "Перемещение за границу в теч. последнего года",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = sterilization,
                    onValueChange = { sterilization = it },
                    label = "Кастрация/Стерилизация",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = color,
                    onValueChange = { color = it },
                    label = "Окрас",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = stance,
                    onValueChange = { stance = it },
                    label = "Положение тела",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = bodytype,
                    onValueChange = { bodytype = it },
                    label = "Телосложение",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = fatness,
                    onValueChange = { fatness = it },
                    label = "Упитанность",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = activity,
                    onValueChange = { activity = it },
                    label = "Изменение физической активности",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = development,
                    onValueChange = { development = it },
                    label = "Характер роста и развития",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = isondiet,
                    onValueChange = { isondiet = it },
                    label = "Диетическое кормление",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = stool,
                    onValueChange = { stool = it },
                    label = "Консистенция стула",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = meat,
                    onValueChange = { meat = it },
                    label = "Содержание мяса в рационе",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = feeding,
                    onValueChange = { feeding = it },
                    label = "Характер кормления",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = convulsions,
                    onValueChange = { convulsions = it },
                    label = "Судороги",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = lungdisease,
                    onValueChange = { lungdisease = it },
                    label = "Болезни легких",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = heartdisease,
                    onValueChange = { heartdisease = it },
                    label = "Болезни сердца",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = temperature,
                    onValueChange = { temperature = it },
                    label = "Температура",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = appetite,
                    onValueChange = { appetite = it },
                    label = "Аппетит",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = vomit,
                    onValueChange = { vomit = it },
                    label = "Рвота",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = diarrhea,
                    onValueChange = { diarrhea = it },
                    label = "Диарея",
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                TextFieldInput(
                    value = urination,
                    onValueChange = { urination = it },
                    label = "Мочеиспускание",
                    modifier = Modifier.padding(bottom = 16.dp)
                )

            }
        }

        val scope = rememberCoroutineScope()

        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    scope.launch {
                        try {
                            PetsRepository.analyzeHealthInfo(
                                Pet.HealthInfo(
                                    species = species,
                                    gender = gender,
                                    breed = breed,
                                    birthDate = LocalDate.parse(age),
                                    weight = weight.toFloat(),
                                    housing = housing,
                                    parks = parks,
                                    abroad = abroad,
                                    sterilization = sterilization,
                                    color = color,
                                    stance = stance,
                                    bodytype = bodytype,
                                    fatness = fatness,
                                    activity = activity,
                                    development = development,
                                    isondiet = isondiet,
                                    stool = stool,
                                    meat = meat,
                                    feeding = feeding,
                                    convulsions = convulsions,
                                    lungdisease = lungdisease,
                                    heartdisease = heartdisease,
                                    temperature = temperature.toFloat(),
                                    appetite = appetite,
                                    vomit = vomit,
                                    diarrhea = diarrhea,
                                    urination = urination
                                )
                            )
                        } catch (e: Exception) {
                            println(e)
                        }
                    }
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White)
                    .align(Alignment.Center),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                )
            ) {
                Text(
                    text = "Отправить",
                    color = Color.Black,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun HealthInfoScreenPreview() {
    HealthInfoScreen()
}