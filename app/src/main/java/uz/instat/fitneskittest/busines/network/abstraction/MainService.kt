package uz.instat.fitneskittest.busines.network.abstraction

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import uz.instat.fitneskittest.busines.interactors.ApiResult
import uz.instat.fitneskittest.busines.network.data.LessonHistory
import uz.instat.fitneskittest.busines.network.data.VisitsHistory
import uz.instat.fitneskittest.busines.network.data.VisitsHistoryDomain

interface MainService {
    fun getLessons(): Flow<ApiResult<Response<LessonHistory>?>>
    fun getVisits(): Flow<ApiResult<Response<VisitsHistory>?>>
}