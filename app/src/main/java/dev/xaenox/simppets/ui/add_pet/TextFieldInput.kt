package dev.xaenox.simppets.ui.add_pet

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color(0xFFCFCEFB),
            unfocusedBorderColor = Color(0xFFC6C6C8),
            containerColor = Color(0xCCF9F9F9),
            unfocusedLabelColor = Color(0xFFC6C6C8),
            focusedLabelColor = Color(0xFFCFCEFB),
        ),
        textStyle = TextStyle(
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal
        ),
        keyboardOptions = keyboardOptions
    )
}