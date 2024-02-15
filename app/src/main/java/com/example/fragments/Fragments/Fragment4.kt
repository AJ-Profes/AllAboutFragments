package com.example.fragments.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fragments.R
import com.example.fragments.SharedViewModel
import com.example.fragments.databinding.Fragment3Binding
import com.example.fragments.databinding.Fragment4Binding


class Fragment4 : Fragment() {

    private lateinit var binding: Fragment4Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  Fragment4Binding.inflate(inflater, container, false)

//        val model =  ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
//
//        model.input_data.observe(viewLifecycleOwner, Observer {
//
//            binding.txt.text = it.toString()
//
//        })

        return binding.root
    }
}