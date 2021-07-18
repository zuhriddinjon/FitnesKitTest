package uz.instat.fitneskittest.framework

import kotlinx.coroutines.flow.Flow
import uz.instat.fitneskittest.busines.cache.data.VisitsHistoryCache
import uz.instat.fitneskittest.busines.interactors.UiState
import uz.instat.fitneskittest.busines.local.LessonsHistoryLocal
import uz.instat.fitneskittest.busines.local.VisitsHistoryLocal

interface MainRepo {
    fun getLessons(): Flow<UiState<List<LessonsHistoryLocal>>>
    fun getVisits(): Flow<UiState<List<VisitsHistoryLocal>>>
}