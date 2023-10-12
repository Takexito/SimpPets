package dev.xaenox.simppets.ui.add_pet

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import dev.xaenox.simppets.R
import dev.xaenox.simppets.entities.Id
import dev.xaenox.simppets.entities.Pet

fun Pet.Gender.toIcon() = when (this) {
    Pet.Gender.MALE -> R.drawable.ic_male
    Pet.Gender.FEMALE -> R.drawable.ic_female
}

fun Int.toGender() = when (this) {
    R.drawable.ic_male -> Pet.Gender.MALE
    R.drawable.ic_female -> Pet.Gender.FEMALE
    else -> Pet.Gender.MALE
}

fun Int.toType() = when (this) {
    R.drawable.ic_dog -> Pet.Type.DOG
    R.drawable.ic_cat -> Pet.Type.CAT
    else -> Pet.Type.CAT
}

fun Pet.Type.toIcon() = when (this) {
    Pet.Type.DOG -> R.drawable.ic_dog
    Pet.Type.CAT -> R.drawable.ic_cat
}

@Composable
fun AddPetScreen(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onSaveClick: (Pet) -> Unit,
) {
    var petName by remember { mutableStateOf("") }
    var petBreed by remember { mutableStateOf("") }
    var petDateOfBirth by remember { mutableStateOf("") }
    var petWeight by remember { mutableStateOf("") }
    var selectedAnimalType by remember { mutableStateOf(Pet.Type.CAT) }
    var selectedGender by remember { mutableStateOf(Pet.Gender.MALE) }

    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = modifier
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .padding(16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Добавить питомца",
                    modifier = Modifier.padding(10.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color(0xFF320071)
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(onClick = onDismiss) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close"
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Selector(
                modifier = Modifier.fillMaxWidth(),
                label = "Вид",
                icon1 = R.drawable.ic_cat,
                icon2 = R.drawable.ic_dog,
                selectedIcon = selectedAnimalType.toIcon()
            ) { selectedAnimalType = it.toType() }

            Spacer(modifier = Modifier.height(16.dp))

            TextFieldInput(
                modifier = Modifier.fillMaxWidth(),
                value = petName,
                onValueChange = { petName = it },
                label = "Имя"
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextFieldInput(
                modifier = Modifier.fillMaxWidth(),
                value = petBreed,
                onValueChange = { petBreed = it },
                label = "Порода"
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextFieldInput(
                modifier = Modifier.fillMaxWidth(),
                value = petDateOfBirth,
                onValueChange = { petDateOfBirth = it },
                label = "Дата рождения",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextFieldInput(
                modifier = Modifier.fillMaxWidth(),
                value = petWeight,
                onValueChange = { petWeight = it },
                label = "Вес",
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal,
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Selector(
                modifier = Modifier.fillMaxWidth(),
                label = "Пол",
                icon1 = R.drawable.ic_male,
                icon2 = R.drawable.ic_female,
                selectedIcon = selectedGender.toIcon()
            ) { selectedGender = it.toGender() }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 16.dp, end = 16.dp)
                        .size(48.dp)
                        .background(Color(0xFFE7E7FD), shape = CircleShape)
                ) {
                    IconButton(
                        onClick = {
                            val pet = Pet(
                                Id.generate(),
                                selectedAnimalType,
                                petName,
                                petBreed,
                                petDateOfBirth,
                                petWeight.toFloat(),
                                selectedGender,
                                Uri.EMPTY
                            )
                            onSaveClick(pet)
                        },
                        modifier = Modifier.padding(8.dp),
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color(0xFFE7E7FD)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AddPetScreenPreview() {
    AddPetScreen(onDismiss = {}, onSaveClick = {})
}

@Preview
@Composable
fun SelectorPreview() {
    Selector(
        label = "Animal Type",
        icon1 = R.drawable.ic_male,
        icon2 = R.drawable.ic_female,
        selectedIcon = R.drawable.ic_male
    ) {}
}