package uz.instat.fitneskittest.busines.network.mainInterface

import retrofit2.Response
import retrofit2.http.GET
import uz.instat.fitneskittest.busines.network.NetworkConstants
import uz.instat.fitneskittest.busines.network.data.LessonHistory
import uz.instat.fitneskittest.busines.network.data.VisitsHistory

interface MainInterface {

    @GET(NetworkConstants.LESSON_HISTORY)
    suspend fun lessonHistory(): Response<LessonHistory>

    @GET(NetworkConstants.VISITS_HISTORY)
    suspend fun visitsHistory(): Response<VisitsHistory>

}