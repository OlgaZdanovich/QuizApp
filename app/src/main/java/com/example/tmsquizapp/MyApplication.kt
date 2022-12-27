package com.example.tmsquizapp

import android.app.Application
import com.example.tmsquizapp.model.Repo

class MyApplication : Application() {
    lateinit var repo: Repo
    override fun onCreate() {
        super.onCreate()
        repo = Repo()
    }
}