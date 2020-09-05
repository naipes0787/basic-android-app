package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set click listener to the random button
        view.findViewById<Button>(R.id.random_button).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        // Set click listener to the greeting button
        view.findViewById<Button>(R.id.greeting_button).setOnClickListener {
            val myToast = Toast.makeText(context, getString(R.string.greeting_text), Toast.LENGTH_SHORT)
            myToast.show()
        }

        // Set click listener to the count button
        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            countMe(view)
        }
    }

    /**
     * Basic method which counts starting from the number on the screen (Incrementing by one the
     * number and then showing it on the screen)
     * @param view The current view from which the starting number is extracted
     */
    private fun countMe(view: View) {
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        val countString = showCountTextView.text.toString()
        var count = countString.toInt()
        count++
        showCountTextView.text = count.toString()
    }
}