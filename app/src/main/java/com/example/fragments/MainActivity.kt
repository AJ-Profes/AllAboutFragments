package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.fragments.Fragments.fragment1
import com.example.fragments.Fragments.fragment2
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnPassDataCommunicator {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btn1.setOnClickListener{

            replacefragment(fragment1())

        }

        binding.btn2.setOnClickListener{

            replacefragment(fragment2())

        }

    }

    private fun replacefragment(fragment : Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.commit()

    }

    override fun passData(data: String, fragment: Fragment) {

        val bundle = Bundle()
        bundle.putString("inputText", data)

        fragment.arguments = bundle

        replacefragment(fragment)

    }
}