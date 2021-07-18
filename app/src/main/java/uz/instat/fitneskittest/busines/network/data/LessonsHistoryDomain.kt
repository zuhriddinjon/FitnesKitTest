package uz.instat.fitneskittest.busines.network.data

import com.google.gson.annotations.SerializedName


data class LessonsHistoryDomain(
    @SerializedName("name")
    val name: String,
    @SerializedName("trainer_name")
    val trainerName: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("price")
    val price: String?,
    @SerializedName("date")
    val date: String,
)