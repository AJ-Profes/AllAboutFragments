package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fragments.Fragments.BlankFragment
import com.example.fragments.Fragments.Fragment3
import com.example.fragments.Fragments.Fragment4
import com.example.fragments.Fragments.fragment1
import com.example.fragments.databinding.ActivityFragmentBinding
import com.example.fragments.databinding.ActivityMainBinding
import kotlin.random.Random

class FragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentBinding

    var freq : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(Fragment3())
        replaceFragments(Fragment4())

        val model = ViewModelProvider(this).get(SharedViewModel::class.java)

        model.input_data.observe(this, Observer {
            freq = it.toInt()
            if(freq!! >0){

                freq?.let { addFragments(it) }

            }
            else{
                Toast.makeText(this@FragmentActivity, "Please Enter value Greater than 0", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun addFragments(freq: Int) {

        val color = randomColor()
        val fragment = BlankFragment.newInstance(freq, color)
        replaceFragments(fragment)

    }

    fun randomColor() : Int{

        var list = ArrayList<Int>()

        list.add(R.color.random_color_1)
        list.add(R.color.random_color_2)
        list.add(R.color.random_color_3)
        list.add(R.color.random_color_4)
        list.add(R.color.random_color_5)

        val randNum = java.util.Random().nextInt(5)

        return list[randNum]

    }

    private fun replaceFragments(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frag2Container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.commit()

    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frag1Container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        fragmentTransaction.commit()

    }
}