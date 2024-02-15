package com.example.fragments

import android.os.Handler
import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fragments.Fragments.BlankFragment

class SharedViewModel : ViewModel() {

    private val txt = MutableLiveData<Int>()
    val input_data : LiveData<Int> = txt

    fun saveTxt(data: Int){
        val freq = data

        val handler = Handler()

        for (num in 1..freq) {
            handler.postDelayed({
                txt.value = num
            }, num * 300L) // Change the delay time as needed (e.g., num * 100L for 100 milliseconds delay)
        }
    }


}