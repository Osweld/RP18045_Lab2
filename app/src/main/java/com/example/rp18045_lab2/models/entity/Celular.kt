package com.example.rp18045_lab2.models.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "celular",
foreignKeys = [
    ForeignKey(entity = Propietario::class, parentColumns = ["dui"], childColumns = ["propietario"])
])
data class Celular(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Long = 0,
    @ColumnInfo(name = "propietario")
    @NonNull
    var propietario:String,
    @ColumnInfo(name = "modelo")
    @NonNull
    var modelo:String,
    @ColumnInfo(name = "capacidad")
    @NonNull
    var capacidad:String,
)
