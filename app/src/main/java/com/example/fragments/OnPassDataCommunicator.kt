package com.example.fragments

import androidx.fragment.app.Fragment

interface OnPassDataCommunicator {

    fun passData(data : String, fragment: Fragment)

}