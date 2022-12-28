package com.example.tmsquizapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmsquizapp.model.Repo

class QuizViewModel(val repo : Repo) : ViewModel() {
    val currentQuestionId = MutableLiveData<Int>(0)
    val currentQuestion = MutableLiveData<String>()
    val userAnswer = -1
    var userAnswers = arrayListOf<Int>()


    fun getQuestionsAmount() = repo.data.size

    fun loadNextQuestion() {
        currentQuestionId.value!!.inc()
        currentQuestion.value = repo.data[currentQuestionId.value!!]
    }

    fun loadPreviousQuestion() {
        currentQuestionId.value!!.dec()
        currentQuestion.value = repo.data[currentQuestionId.value!!]
    }

    fun saveUserAnswer() {
        userAnswers[currentQuestionId.value!!] = userAnswer
    }

    fun loadAnswers(questionNumber: Int): ArrayList<String>{
        return repo.answersAsVariants[questionNumber]
    }

}