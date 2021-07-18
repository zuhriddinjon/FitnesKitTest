package uz.instat.fitneskittest.busines.cache.dao

import androidx.room.*
import uz.instat.fitneskittest.busines.cache.data.VisitsHistoryCache

@Dao
interface VisitsHistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(visitsCache: VisitsHistoryCache): Long


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<VisitsHistoryCache>): LongArray

    @Delete
    suspend fun delete(visitsCache: VisitsHistoryCache)

    @Query("DELETE FROM visits_history")
    suspend fun deleteAll()

}