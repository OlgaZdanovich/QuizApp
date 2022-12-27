package com.example.tmsquizapp.viewmodels

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmsquizapp.model.Repo

class QuizViewModelFactory constructor(private val repo: Repo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(QuizViewModel::class.java))
        {
           return QuizViewModel(repo) as T
        }
        else
        {
            throw IllegalArgumentException("View model not found")
        }
    }
}