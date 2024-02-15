package com.example.fragments.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments.OnPassDataCommunicator
import com.example.fragments.R
import com.example.fragments.databinding.FragmentFragment1Binding


class fragment1 : Fragment(R.layout.fragment_fragment1) {

    private lateinit var binding: FragmentFragment1Binding

    private lateinit var onPassDataCommunicator: OnPassDataCommunicator

    private var input_data : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFragment1Binding.inflate(inflater, container, false)

        input_data = arguments?.getString("inputText").toString()

        if (input_data=="null"){
            binding.frag1Text.text = "Welcome to Fragment 1"
        }else{
            binding.frag1Text.text = input_data
        }

        onPassDataCommunicator = requireActivity() as OnPassDataCommunicator

        binding.btn.setOnClickListener {

            onPassDataCommunicator.passData(binding.edText.text.toString(), fragment2())

        }

        return binding.root
    }

    companion object{

    }


}