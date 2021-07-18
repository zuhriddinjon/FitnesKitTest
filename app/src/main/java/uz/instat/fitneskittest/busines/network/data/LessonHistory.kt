package uz.instat.fitneskittest.busines.network.data

import com.google.gson.annotations.SerializedName


data class LessonHistory(
    @SerializedName("lessons_history")
    var lessonsHistory: List<LessonsHistoryDomain>
)