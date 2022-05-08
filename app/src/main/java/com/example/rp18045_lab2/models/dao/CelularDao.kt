package com.example.rp18045_lab2.models.dao

import androidx.room.*
import com.example.rp18045_lab2.models.entity.Celular
import com.example.rp18045_lab2.models.entity.Propietario

@Dao
interface CelularDao {

    @Insert
    fun insertCelular(celular: Celular)

    @Update
    fun updateCelular(celular: Celular)

    @Delete
    fun deleteCelular(celular: Celular)

    @Query("SELECT * FROM celular")
    fun getAllCelulares():List<Celular>
}