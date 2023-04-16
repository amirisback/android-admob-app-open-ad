package com.frogobox.admob.appopenad

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.android.gms.ads.MobileAds
import com.frogobox.admob.appopenad.common.callback.AdmobAppOpenAdCallback
import com.frogobox.admob.appopenad.util.Constant

/** Application class that initializes, loads and show ads when activities change states. */
class MyApplication : Application(),
    Application.ActivityLifecycleCallbacks,
    LifecycleObserver
{

    companion object {
        const val LOG_TAG = "MyApplication"
    }

    private lateinit var appOpenAdManager: AppOpenAdManager
    private var currentActivity: Activity? = null

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this)

        // Log the Mobile Ads SDK version.
        Log.d(LOG_TAG, "Google Mobile Ads SDK Version: " + MobileAds.getVersion())

        MobileAds.initialize(this) {}
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        appOpenAdManager = AppOpenAdManager()
    }

    /** LifecycleObserver method that shows the app open ad when the app moves to foreground. */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMoveToForeground() {
        // Show the ad (if available) when the app moves to foreground.
        currentActivity?.let { appOpenAdManager.showAdIfAvailable(it, Constant.AD_UNIT_ID) }
    }

    /** ActivityLifecycleCallback methods. */
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

    override fun onActivityStarted(activity: Activity) {
        // An ad activity is started when an ad is showing, which could be AdActivity class from Google
        // SDK or another activity class implemented by a third party mediation partner. Updating the
        // currentActivity only when an ad is not showing will ensure it is not an ad activity, but the
        // one that shows the ad.
        if (!appOpenAdManager.isShowingAd) {
            currentActivity = activity
        }
    }

    override fun onActivityResumed(activity: Activity) {}

    override fun onActivityPaused(activity: Activity) {}

    override fun onActivityStopped(activity: Activity) {}

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

    override fun onActivityDestroyed(activity: Activity) {}

    /**
     * Shows an app open ad.
     *
     * @param activity the activity that shows the app open ad
     * @param admobAppOpenAdCallback the listener to be notified when an app open ad is complete
     */
    fun showAdIfAvailable(
        activity: Activity,
        appOpenAdUnitId: String,
        admobAppOpenAdCallback: AdmobAppOpenAdCallback
    ) {
        // We wrap the showAdIfAvailable to enforce that other classes only interact with MyApplication
        // class.
        appOpenAdManager.showAdIfAvailable(activity, appOpenAdUnitId, admobAppOpenAdCallback)
    }

}
