package com.example.movieappmad24.workManagers

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class DatabaseWorker(context: Context) {
    private val workManager = WorkManager.getInstance(context)
    fun seedRequest() = workManager.enqueue(OneTimeWorkRequestBuilder<Worker>().build())

}