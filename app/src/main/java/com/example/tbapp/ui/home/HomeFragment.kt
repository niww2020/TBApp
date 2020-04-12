package com.example.tbapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.tbapp.R
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val btn1: AppCompatButton = root.findViewById(R.id.btn1)
        val btn2: AppCompatButton = root.findViewById(R.id.btn2)
        btn1.setOnClickListener { Toast.makeText(root.context, "Test", Toast.LENGTH_SHORT).show() }

//        val trainingFragment = TrainingFragment()
//        val transaction = fragmentManager?.beginTransaction()

        val dataBase = Firebase.database
        val myRef = dataBase.getReference("massage")


//        btn2.setOnClickListener { btn2.setText("Work") }
        btn2.setOnClickListener {
            //todo how show new fragment
            myRef.setValue(textView.text)

//            transaction?.replace(trainingFragment)
//            transaction?.commit()

        }
        return root
    }
}
