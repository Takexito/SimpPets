package dev.xaenox.simppets.data

import dev.xaenox.simppets.entities.Email
import dev.xaenox.simppets.entities.Password
import dev.xaenox.simppets.entities.Token
import dev.xaenox.simppets.entities.User
import kotlinx.coroutines.flow.MutableStateFlow

object UserRepository {
    val currentUser = MutableStateFlow<User?>(null)
    val currentToken = MutableStateFlow<Token?>(null)

    suspend fun auth(email: Email, password: Password): Token {
        val token = UserApi.auth(email, password)
        currentToken.value = token
        return token
    }

    fun signOut() {

    }
}