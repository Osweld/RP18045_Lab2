package com.example.rp18045_lab2.models.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "propietario")
data class Propietario(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "dui")
    var dui:String,
    @ColumnInfo(name = "nombre")
    @NonNull
    var nombre:String,
    @ColumnInfo(name = "edad")
    @NonNull
    var edad:String,
    @ColumnInfo(name = "sexo")
    @NonNull
    var sexo:String,
    @ColumnInfo(name = "estado_laborar")
    @NonNull
    var estadoLaboral:String,
    @ColumnInfo(name = "direccion")
    @NonNull
    var direccion:String
)
