package mx.utng.smarthealthmonitor.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mx.utng.smarthealthmonitor.domain.model.LecturaFC

@Database(entities = [LecturaFC::class], version = 1, exportSchema = false)
abstract class SmartHealthDatabase : RoomDatabase() {
    abstract fun lecturaFcDao(): LecturaFcDao

    companion object {
        @Volatile
        private var INSTANCE: SmartHealthDatabase? = null

        fun getInstance(context: Context): SmartHealthDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SmartHealthDatabase::class.java,
                    "smarthealth_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
