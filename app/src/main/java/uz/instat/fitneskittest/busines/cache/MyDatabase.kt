package uz.instat.fitneskittest.busines.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.instat.fitneskittest.busines.cache.dao.LessonsHistoryDao
import uz.instat.fitneskittest.busines.cache.dao.VisitsHistoryDao
import uz.instat.fitneskittest.busines.cache.data.LessonsHistoryCache
import uz.instat.fitneskittest.busines.network.data.LessonsHistoryDomain
import uz.instat.fitneskittest.busines.cache.data.VisitsHistoryCache

@Database(
    entities = [LessonsHistoryCache::class, VisitsHistoryCache::class],
    version = 3,
    exportSchema = false
)

abstract class MyDatabase : RoomDatabase() {
    abstract fun lessonDao(): LessonsHistoryDao
    abstract fun visitsDao(): VisitsHistoryDao

    companion object {
        const val DB_NAME = "fitness_kit_dao"
    }
}