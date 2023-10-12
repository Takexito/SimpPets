package dev.xaenox.simppets.entities

import android.net.Uri
import java.util.UUID

//@Serializable
@JvmInline
value class Id(val value: String) {
    companion object {
        fun generate() = Id(UUID.randomUUID().toString())
        fun fromUUID(uuid: UUID) = Id(uuid.toString())
    }

    fun toUUID() = UUID.fromString(this.value)
}

//@Serializable
data class Pet(
    val id: Id,
    val type: Type,
    val name: String,
    val species: String,
    val birthDate: String,
    val weight: Float,
    val gender: Gender,
    val photoUrl: Uri
) {
    enum class Type {
        DOG, CAT
    }

    enum class Gender {
        MALE, FEMALE
    }

////    @Serializable
//    data class HealthInfo(
//        val species: String,
//        val gender: String,
//        val breed: String,
//        val birthDate: LocalDate,
//        val weight: Float,
//        val housing: String,
//        val parks: String,
//        val abroad: String,
//        val sterilization: String,
//        val color: String,
//        val stance: String,
//        val bodytype: String,
//        val fatness: String,
//        val activity: String,
//        val development: String,
//        val isondiet: String,
//        val stool: String,
//        val meat: String,
//        val feeding: String,
//        val convulsions: String,
//        val lungdisease: String,
//        val heartdisease: String,
//        val temperature: Float,
//        val appetite: String,
//        val vomit: String,
//        val diarrhea: String,
//        val urination: String
//    ) {
//        private fun isLeapYear(year: Int): Boolean {
//            return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)
//        }
//
//        private fun daysInMonth(month: Int, year: Int): Int {
//            return when (month) {
//                2 -> if (isLeapYear(year)) 29 else 28
//                4, 6, 9, 11 -> 30
//                else -> 31
//            }
//        }
//
//        fun getAgeInYearsMonthsDays(birthDate: LocalDate): Triple<Int, Int, Int> {
//            val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
//
//            var years = today.year - birthDate.year
//            var months = today.monthNumber - birthDate.monthNumber
//            var days = today.dayOfMonth - birthDate.dayOfMonth
//
//            if (days < 0) {
//                months -= 1
//                days += daysInMonth(birthDate.monthNumber, birthDate.year)
//            }
//
//            if (months < 0) {
//                years -= 1
//                months += 12
//            }
//
//            return Triple(years, months, days)
//        }
//    }

//    @Serializable
    sealed interface Status {
//        @Serializable
        data object NeedDoctor : Status

//        @Serializable
        data object NotNeedDoctor : Status
    }

    companion object {
        val mock = Pet(
            Id.generate(),
            Type.DOG,
            "Rex",
            "Dog",
            "2022-02-02",
            10f,
            Gender.MALE,
            Uri.EMPTY
        )
    }
}