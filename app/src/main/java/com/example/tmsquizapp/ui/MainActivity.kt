package com.example.tmsquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmsquizapp.viewmodels.QuizViewModel
import com.example.tmsquizapp.viewmodels.QuizViewModelFactory

class MainActivity : AppCompatActivity() {
    val viewModel: QuizViewModel =
        ViewModelProvider(this, QuizViewModelFactory((application as MyApplication).repo))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        viewModel.cn.observe(this) {
            Log.d("TAG", "onCreate: ${it}")
        }
    }

}