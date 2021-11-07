package com.example.applicationlifecycle

import android.app.Application
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log

class MainApplication: Application(), ActivityLifecycleHandler.LifecycleListener {

    companion object {
        const val TrackLog = "Tracking"
    }

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(ActivityLifecycleHandler(this))
    }

    override fun onApplicationCreated(bundle: Bundle?) {
        if (bundle == null)
            Log.d(TrackLog, "onApplicationCreated without SavedState")
        else
            Log.d(TrackLog, "onApplicationCreated with SavedState")
    }

    override fun onApplicationStopped() {
        Log.d(TrackLog, "onApplicationStopped")
    }

    override fun onApplicationStarted() {
        Log.d(TrackLog, "onApplicationStarted")
    }

    override fun onApplicationPaused() {
        Log.d(TrackLog, "onApplicationPaused")
    }

    override fun onApplicationResumed() {
        Log.d(TrackLog, "onApplicationResumed")
    }

    override fun onApplicationSaveInstanceState(bundle: Bundle) {
        Log.d(TrackLog, "onApplicationSaveInstanceState")
    }

    override fun onApplicationDestroy() {
        Log.d(TrackLog, "onApplicationDestroy")
    }
}
