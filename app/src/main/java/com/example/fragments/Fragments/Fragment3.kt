package com.example.fragments.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fragments.SharedViewModel
import com.example.fragments.databinding.Fragment3Binding


class Fragment3 : Fragment() {

    private lateinit var binding: Fragment3Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  Fragment3Binding.inflate(inflater, container, false)

        val model =  ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.btnnn.setOnClickListener{

            model.saveTxt(binding.edittText.text.toString().toInt())

            it.hideKeyboard()
        }

        return binding.root
    }
}