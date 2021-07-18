package uz.instat.fitneskittest.busines.network.data

import com.google.gson.annotations.SerializedName


data class VisitsHistory(
    @SerializedName("visits_history")
    var visitsHistory: List<VisitsHistoryDomain>
)