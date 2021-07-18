package uz.instat.fitneskittest.busines.cache.dao

import androidx.room.*
import uz.instat.fitneskittest.busines.cache.data.LessonsHistoryCache

@Dao
interface LessonsHistoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(list: List<LessonsHistoryCache>): LongArray

    @Delete
    suspend fun delete(lessonCache: LessonsHistoryCache)

    @Query("DELETE FROM lesson_history")
    suspend fun deleteAll()

}