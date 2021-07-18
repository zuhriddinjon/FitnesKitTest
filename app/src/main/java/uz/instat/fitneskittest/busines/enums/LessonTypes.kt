package uz.instat.fitneskittest.busines.enums

import androidx.annotation.DrawableRes
import uz.instat.fitneskittest.R
import uz.instat.fitneskittest.busines.utils.getStringArray


enum class LessonTypes(val value: String, val drawable: Int) {
    GROUP("Group", R.drawable.ic_people),
    PERSONAL("Personal",R.drawable.ic_person);

    companion object {
        fun getByValue(value: String) = values().find { it.value == value } ?: GROUP
        val LessonTypes.title: String
            get() = getStringArray(R.array.lesson_types)[ordinal]
    }
}