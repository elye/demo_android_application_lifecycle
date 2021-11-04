package com.example.applicationlifecycle

import android.app.Application
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log

class MainApplication: Application(), ActivityLifecycleHandler.LifecycleListener {

    companion object {
        const val APPLICATION_SAVED_KEY = "application_saved_key"
        var applicationNoSaved = false
        var applicationSaved = false
    }

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(ActivityLifecycleHandler(this))

//        registerActivityLifecycleCallbacks(object: ActivityLifecycleCallbacks{
//            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
//                if (savedInstanceState != null) {
//                    Log.d("Elisha", "onActivityCreated with State ${activity.localClassName}")
//                    applicationSaved = savedInstanceState.getBoolean(APPLICATION_SAVED_KEY)
//                } else {
//                    Log.d("Elisha", "onActivityCreated without State ${activity.localClassName}")
//                }
//            }
//
//            override fun onActivityStarted(activity: Activity) {
//                Log.d("Elisha", "onActivityStarted ${activity.localClassName}")
//            }
//
//            override fun onActivityResumed(activity: Activity) {
//                Log.d("Elisha", "onActivityResumed ${activity.localClassName}")
//            }
//
//            override fun onActivityPaused(activity: Activity) {
//                Log.d("Elisha", "onActivityPaused ${activity.localClassName}")
//            }
//
//            override fun onActivityStopped(activity: Activity) {
//                Log.d("Elisha", "onActivityStopped ${activity.localClassName}")
//            }
//
//            override fun onActivitySaveInstanceState(activity: Activity, savedInstanceState: Bundle) {
//                Log.d("Elisha", "onActivitySaveInstanceState ${activity.localClassName}")
//                savedInstanceState.putBoolean(APPLICATION_SAVED_KEY, applicationSaved)
//            }
//
//            override fun onActivityDestroyed(activity: Activity) {
//                Log.d("Elisha", "onActivityDestroyed ${activity.localClassName}")
//            }
//        })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d("Elisha", "onConfigurationChanged")
    }

    override fun onApplicationCreated(bundle: Bundle?) {
        Log.d("Elisha", "onApplicationCreated")
    }

    override fun onApplicationStopped() {
        Log.d("Elisha", "onApplicationStopped")
    }

    override fun onApplicationStarted() {
        Log.d("Elisha", "onApplicationStarted")
    }

    override fun onApplicationPaused() {
        Log.d("Elisha", "onApplicationPaused")
    }

    override fun onApplicationResumed() {
        Log.d("Elisha", "onApplicationResumed")
    }

    override fun onApplicationSaveInstanceState(bundle: Bundle) {
        Log.d("Elisha", "onApplicationSaveInstanceState")
    }
}
