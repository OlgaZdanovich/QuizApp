package com.example.tmsquizapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.tmsquizapp.MyApplication
import com.example.tmsquizapp.R
import com.example.tmsquizapp.viewmodels.QuizViewModel
import com.example.tmsquizapp.viewmodels.QuizViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: QuizViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, QuizViewModelFactory((application as MyApplication).repo)).get(
            QuizViewModel::class.java)

        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

    }

}