package com.example.movieappmad24.WorkManagerUNUSED

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class RepositoryWorker(context: Context) {
    private val workManager = WorkManager.getInstance(context)
    fun seedRequest() {
        workManager.enqueue(OneTimeWorkRequestBuilder<Worker>().build())
    }

}