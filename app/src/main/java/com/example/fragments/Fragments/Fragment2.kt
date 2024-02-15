package com.example.fragments.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments.OnPassDataCommunicator
import com.example.fragments.R
import com.example.fragments.databinding.FragmentFragment2Binding

class fragment2 : Fragment(R.layout.fragment_fragment2) {

    private lateinit var binding: FragmentFragment2Binding


    private lateinit var onPassDataCommunicator: OnPassDataCommunicator

    private var input_data : String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFragment2Binding.inflate(inflater, container, false)

        input_data = arguments?.getString("inputText").toString()

        onPassDataCommunicator = requireActivity() as OnPassDataCommunicator

        if(input_data=="null"){
            input_data = "Welcome to Fragment 2"
        }

        binding.otText.setText(input_data)

        binding.fragBtn.setOnClickListener {

            onPassDataCommunicator.passData(binding.ediText.text.toString(), fragment1())

        }

        return binding.root
    }
}