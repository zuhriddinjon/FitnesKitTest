package uz.instat.fitneskittest.busines.network.data.mapper

import uz.instat.fitneskittest.busines.local.LessonsHistoryLocal
import uz.instat.fitneskittest.busines.network.NetworkMapper
import uz.instat.fitneskittest.busines.network.data.LessonsHistoryDomain
import javax.inject.Inject

class LessonNetworkMapper @Inject constructor() :
    NetworkMapper<LessonsHistoryDomain, LessonsHistoryLocal>() {
    override fun mapFromDomain(domain: LessonsHistoryDomain): LessonsHistoryLocal {
        return LessonsHistoryLocal(
            name = domain.name,
            trainerName = domain.trainerName,
            type = domain.type,
            price = domain.price,
            date = domain.date
        )
    }

    override fun mapFromLocal(local: LessonsHistoryLocal): LessonsHistoryDomain {
        return LessonsHistoryDomain(
            name = local.name,
            trainerName = local.trainerName,
            type = local.type,
            price = local.price,
            date = local.date
        )
    }
}