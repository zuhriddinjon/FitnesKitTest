package uz.instat.fitneskittest.framework.datasource

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response
import uz.instat.fitneskittest.busines.interactors.ApiResultHandler
import uz.instat.fitneskittest.busines.interactors.DataState
import uz.instat.fitneskittest.busines.network.abstraction.MainService
import uz.instat.fitneskittest.busines.network.data.LessonHistory
import uz.instat.fitneskittest.busines.network.data.LessonsHistoryDomain
import uz.instat.fitneskittest.busines.network.data.VisitsHistory
import uz.instat.fitneskittest.busines.network.data.VisitsHistoryDomain
import javax.inject.Inject

class MainDataSourceImpl @Inject constructor(
    private val mainService: MainService,
    ):MainDataSource {
    override fun getLessons(): Flow<DataState<List<LessonsHistoryDomain>>> {
        return mainService.getLessons().map {
            object : ApiResultHandler<Response<LessonHistory>, List<LessonsHistoryDomain>>(it) {
                override fun handleSuccess(response: Response<LessonHistory>): DataState<List<LessonsHistoryDomain>> {
                    return DataState.data(response.body()?.lessonsHistory)
                }
            }.getResult()
        }
    }

    override fun getVisits(): Flow<DataState<List<VisitsHistoryDomain>>> {
        return mainService.getVisits().map {
            object : ApiResultHandler<Response<VisitsHistory>, List<VisitsHistoryDomain>>(it) {
                override fun handleSuccess(response: Response<VisitsHistory>): DataState<List<VisitsHistoryDomain>> {
                    return DataState.data(response.body()?.visitsHistory)
                }
            }.getResult()
        }

    }
}