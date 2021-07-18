package uz.instat.fitneskittest.busines.network.data.mapper

import uz.instat.fitneskittest.busines.local.VisitsHistoryLocal
import uz.instat.fitneskittest.busines.network.NetworkMapper
import uz.instat.fitneskittest.busines.network.data.VisitsHistoryDomain
import javax.inject.Inject

class VisitNetworkMapper @Inject constructor() :
    NetworkMapper<VisitsHistoryDomain, VisitsHistoryLocal>() {
    override fun mapFromDomain(domain: VisitsHistoryDomain): VisitsHistoryLocal {
        return VisitsHistoryLocal(
            name = domain.name,
            data = domain.data
        )
    }

    override fun mapFromLocal(local: VisitsHistoryLocal): VisitsHistoryDomain {
        return VisitsHistoryDomain(
            name = local.name,
            data = local.data
        )
    }
}