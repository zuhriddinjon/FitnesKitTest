package uz.instat.fitneskittest.framework.datasource

import kotlinx.coroutines.flow.Flow
import uz.instat.fitneskittest.busines.interactors.DataState
import uz.instat.fitneskittest.busines.network.data.LessonsHistoryDomain
import uz.instat.fitneskittest.busines.network.data.VisitsHistoryDomain

interface MainDataSource {
    fun getLessons(): Flow<DataState<List<LessonsHistoryDomain>>>
    fun getVisits(): Flow<DataState<List<VisitsHistoryDomain>>>
}