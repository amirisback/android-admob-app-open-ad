package com.google.android.gms.example.appopenexample.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.google.android.gms.example.appopenexample.MyApplication
import com.google.android.gms.example.appopenexample.common.base.BaseActivity
import com.google.android.gms.example.appopenexample.common.callback.AdmobAppOpenAdCallback
import com.google.android.gms.example.appopenexample.databinding.ActivitySplashBinding
import com.google.android.gms.example.appopenexample.util.Constant
import com.google.android.gms.example.appopenexample.util.startActivityExt

/** Splash Activity that inflates splash activity xml. */
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    private var secondsRemaining: Long = 0L

    override fun setupViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create a timer so the SplashActivity will be displayed for a fixed amount of time.
        createTimer(Constant.COUNTER_TIME)
    }

    /**
     * Create the countdown timer, which counts down to zero and show the app open ad.
     *
     * @param seconds the number of seconds that the timer counts down from
     */
    private fun createTimer(seconds: Long) {
        val countDownTimer: CountDownTimer = object : CountDownTimer(seconds * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                secondsRemaining = millisUntilFinished / 1000 + 1
                binding.timer.text = "App is done loading in: $secondsRemaining"
            }

            override fun onFinish() {
                secondsRemaining = 0
                binding.timer.text = "Done."

                val application = application as? MyApplication

                // If the application is not an instance of MyApplication, log an error message and
                // start the MainActivity without showing the app open ad.
                if (application == null) {
                    Log.e("SplashScreen", "Failed to cast application to MyApplication.")
                    startMainActivity()
                    return
                }

                // Show the app open ad.
                application.showAdIfAvailable(
                    this@SplashActivity,
                    Constant.AD_UNIT_ID,
                    object : AdmobAppOpenAdCallback {
                        override fun onAdDismissed(tag: String, message: String) {
                            startMainActivity()
                        }

                        override fun onAdShowed(tag: String, message: String) {

                        }
                    })
            }
        }
        countDownTimer.start()
    }

    /** Start the MainActivity. */
    fun startMainActivity() {
        startActivityExt(MainActivity::class.java)
    }
}