package ni.edu.uca.peliculas.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Idioma::class], version = 1)
abstract class IdiomaDatabase: RoomDatabase() {
    abstract fun tblidioma(): IdiomaDao

    companion object{
        @Volatile
        private var INSTANCE: IdiomaDatabase? = null

        fun getDatabase(context: Context): IdiomaDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    IdiomaDatabase::class.java,
                    "idiomadatabase"
                ).build()

                INSTANCE = instance

                return instance

            }
        }
    }
}