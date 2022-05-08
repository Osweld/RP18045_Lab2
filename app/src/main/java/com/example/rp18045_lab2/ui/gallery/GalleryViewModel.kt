package com.example.rp18045_lab2.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rp18045_lab2.models.AppDatabase

class GalleryViewModel : ViewModel() {
    private lateinit var database : AppDatabase
    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
}