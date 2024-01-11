package com.example.restapiproject.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {
    var count : MutableLiveData<Int> = MutableLiveData(0)
}