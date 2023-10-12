package dev.xaenox.simppets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import dev.xaenox.simppets.navigation.NavHost
import dev.xaenox.simppets.navigation.Navigator
import dev.xaenox.simppets.ui.theme.SimpPetsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Navigator.init(lifecycleScope)
        setContent {
            SimpPetsTheme {
                val currentScreen = Navigator.currentScreen.collectAsState()
                val presentScreen = Navigator.presentScreen.collectAsState()

                NavHost(
                    currentScreen = currentScreen.value,
                    presentScreen = presentScreen.value,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

    override fun onBackPressed() {
        Navigator.navigateBack()
    }
}