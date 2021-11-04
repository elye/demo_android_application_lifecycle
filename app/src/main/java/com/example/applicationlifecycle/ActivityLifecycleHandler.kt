package com.example.applicationlifecycle

import android.app.Activity
import android.app.Application

import android.os.Bundle
import android.util.Log


/**
 * A convenience lifecycle handler that tracks whether the overall application is
 * started, in the foreground, in the background or stopped and ignores transitions
 * between individual activities.
 */
class ActivityLifecycleHandler(private val listener: LifecycleListener?) :
    Application.ActivityLifecycleCallbacks {
    /**
     * Informs the listener about application lifecycle events.
     */
    interface LifecycleListener {

        /**
         * Called right after the application is created
         */
        fun onApplicationCreated(bundle: Bundle?)

        /**
         * Called right before the application is stopped.
         */
        fun onApplicationStopped()

        /**
         * Called right after the application has been started.
         */
        fun onApplicationStarted()

        /**
         * Called when the application is paused (but still awake).
         */
        fun onApplicationPaused()

        /**
         * Called right after the application has been resumed (come to the foreground).
         */
        fun onApplicationResumed()


        /**
         * Called right after the application is stopped
         */
        fun onApplicationSaveInstanceState(bundle: Bundle)
    }

    private var started = 0
    private var resumed = 0
    private var transitionPossible = false
    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
        Log.d("Elisha", "onActivityCreated ${activity.localClassName}")
        if (activity.isChangingConfigurations) return
        if (started == 0) listener?.onApplicationCreated(bundle)
    }
    override fun onActivityStarted(activity: Activity) {
        if (activity.isChangingConfigurations) return
        if (started == 0) listener?.onApplicationStarted()
        started++
    }

    override fun onActivityResumed(activity: Activity) {
        if (activity.isChangingConfigurations) return
        if (resumed == 0 && !transitionPossible) listener?.onApplicationResumed()
        transitionPossible = false
        resumed++
    }

    override fun onActivityPaused(activity: Activity) {
        if (activity.isChangingConfigurations) return
        transitionPossible = true
        resumed--
    }

    override fun onActivityStopped(activity: Activity) {
        if (activity.isChangingConfigurations) return
        if (started == 1) {
            // We only know the application was paused when it's stopped (because transitions always pause activities)
            // http://developer.android.com/guide/components/activities.html#CoordinatingActivities
            if (transitionPossible && resumed == 0) listener?.onApplicationPaused()
            listener?.onApplicationStopped()
        }
        transitionPossible = false
        started--
    }

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {
        if (activity.isChangingConfigurations) return
        if (started == 0) listener?.onApplicationSaveInstanceState(bundle)
    }

    override fun onActivityDestroyed(activity: Activity) {}
}
