package uz.instat.fitneskittest.busines.network.implementation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import uz.instat.fitneskittest.busines.interactors.ApiResult
import uz.instat.fitneskittest.busines.network.abstraction.MainService
import uz.instat.fitneskittest.busines.network.data.LessonHistory
import uz.instat.fitneskittest.busines.network.data.VisitsHistory
import uz.instat.fitneskittest.busines.network.data.VisitsHistoryDomain
import uz.instat.fitneskittest.busines.network.mainInterface.MainInterface
import uz.instat.fitneskittest.busines.utils.safeApiCall
import javax.inject.Inject

class MainServiceImpl @Inject constructor(
    private val mainInterface: MainInterface
) : MainService {
    override fun getLessons(): Flow<ApiResult<Response<LessonHistory>?>> {
        return flow {
            emit(safeApiCall(Dispatchers.IO) {
                mainInterface.lessonHistory()
            })
        }
    }

    override fun getVisits(): Flow<ApiResult<Response<VisitsHistory>?>> {
        return flow {
            emit(safeApiCall(Dispatchers.IO) {
                mainInterface.visitsHistory()
            })
        }    }
}