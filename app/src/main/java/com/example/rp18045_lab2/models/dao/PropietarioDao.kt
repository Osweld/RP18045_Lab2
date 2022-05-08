package com.example.rp18045_lab2.models.dao

import androidx.room.*
import com.example.rp18045_lab2.models.entity.Propietario

@Dao
interface PropietarioDao {

    @Insert
    fun insertPropietario(propietario: Propietario)

    @Update
    fun updatePropietario(propietario: Propietario)

    @Delete
    fun deletePropietario(propietario: Propietario)

    @Query("SELECT * FROM propietario")
    fun getAllPropietarios():List<Propietario>

    @Query("SELECT * FROM propietario where dui = :dui")
    fun getPropietario(dui:String): Propietario
}