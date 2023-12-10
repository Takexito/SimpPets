package dev.xaenox.simppets.entities

import java.util.UUID
import kotlinx.serialization.Serializable

@Serializable
@JvmInline
value class Email(val value: String)

@Serializable
@JvmInline
value class Password(val value: String)

@Serializable
@JvmInline
value class Id(val value: String) {
    companion object {
        fun generate() = Id(UUID.randomUUID().toString())
        fun fromUUID(uuid: UUID) = Id(uuid.toString())
    }

    fun toUUID() = UUID.fromString(this.value)
}

@Serializable
@JvmInline
value class Token(val value: String) {
    companion object {
        fun generate() = Token(UUID.randomUUID().toString())
    }
}

@Serializable
data class User(
    val uuid: Id,
    val email: Email
)
