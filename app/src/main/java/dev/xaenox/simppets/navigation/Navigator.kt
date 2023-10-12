package dev.xaenox.simppets.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

object Navigator {
    private var coroutineScope: CoroutineScope? = null
    private val _navigation: MutableStateFlow<List<Navigation>> =
        MutableStateFlow(listOf(Navigation.Home))
    private val _present: MutableStateFlow<Navigation?> = MutableStateFlow(null)

    val currentScreen: StateFlow<Navigation>
        get() = _navigation.map { it.last() }
            .stateIn(coroutineScope!!, SharingStarted.Eagerly, Navigation.Home)

    val presentScreen: StateFlow<Navigation?>
        get() = _present

    fun init(coroutineScope: CoroutineScope) {
        this.coroutineScope = coroutineScope
    }

    fun navigateTo(screen: Navigation) {
        if (_present.value != null) dismiss()
        _navigation.value += screen
    }

    fun navigateBack() {
        if (_present.value != null) dismiss()
        else _navigation.value = _navigation.value.dropLast(1)
    }

    fun present(screen: Navigation) {
        _present.value = screen
    }

    fun dismiss() {
        _present.value = null
    }
}