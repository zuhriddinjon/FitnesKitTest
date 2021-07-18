package uz.instat.fitneskittest.busines.network.data

import com.google.gson.annotations.SerializedName


data class VisitsHistoryDomain(
    @SerializedName("name")
    val name: String,
    @SerializedName("date")
    val data: String,
)