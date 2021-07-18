package uz.instat.fitneskittest.framework

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uz.instat.fitneskittest.busines.cache.data.VisitsHistoryCache
import uz.instat.fitneskittest.busines.interactors.DataStateHandler
import uz.instat.fitneskittest.busines.interactors.UiState
import uz.instat.fitneskittest.busines.local.LessonsHistoryLocal
import uz.instat.fitneskittest.busines.local.VisitsHistoryLocal
import uz.instat.fitneskittest.busines.network.data.LessonsHistoryDomain
import uz.instat.fitneskittest.busines.network.data.VisitsHistoryDomain
import uz.instat.fitneskittest.busines.network.data.mapper.LessonNetworkMapper
import uz.instat.fitneskittest.busines.network.data.mapper.VisitNetworkMapper
import uz.instat.fitneskittest.framework.datasource.MainDataSource
import javax.inject.Inject

class MainRepoImpl @Inject constructor(
    private val mainDataSource: MainDataSource,
    private val lessonNetworkMapper: LessonNetworkMapper,
    private val visitNetworkMapper: VisitNetworkMapper
) : MainRepo {
    override fun getLessons(): Flow<UiState<List<LessonsHistoryLocal>>> {
        return mainDataSource.getLessons().map {
            object : DataStateHandler<List<LessonsHistoryDomain>, List<LessonsHistoryLocal>>(it) {
                override fun handleSuccess(data: List<LessonsHistoryDomain>): UiState.Success<List<LessonsHistoryLocal>> {
                    return UiState.Success(lessonNetworkMapper.mapFromDomainList(data))
                }

            }.getResult()
        }
    }

    override fun getVisits(): Flow<UiState<List<VisitsHistoryLocal>>> {
        return mainDataSource.getVisits().map {
            object : DataStateHandler<List<VisitsHistoryDomain>, List<VisitsHistoryLocal>>(it) {
                override fun handleSuccess(data: List<VisitsHistoryDomain>): UiState.Success<List<VisitsHistoryLocal>> {
                    return UiState.Success(visitNetworkMapper.mapFromDomainList(data))
                }

            }.getResult()
        }
    }
}