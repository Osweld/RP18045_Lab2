package com.example.rp18045_lab2.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rp18045_lab2.models.dao.CelularDao
import com.example.rp18045_lab2.models.dao.PropietarioDao
import com.example.rp18045_lab2.models.entity.Celular
import com.example.rp18045_lab2.models.entity.Propietario

@Database(
    entities = [Propietario::class,Celular::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract val propietarioDao :PropietarioDao;
    abstract val celularDao :CelularDao;

    companion object{
        const val DATABASE_NAME = "inventario"
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context: Context) :AppDatabase {
            synchronized(this){

                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        DATABASE_NAME
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}

