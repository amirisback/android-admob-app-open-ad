package com.frogobox.admob.appopenad.ui

import android.os.Bundle
import android.util.Log
import com.frogobox.admob.appopenad.AdApplication
import com.frogobox.admob.appopenad.common.base.BaseActivity
import com.frogobox.admob.appopenad.common.callback.AdmobAppOpenAdCallback
import com.frogobox.admob.appopenad.databinding.ActivityMainBinding
import com.frogobox.admob.appopenad.util.AdHelper
import com.frogobox.admob.appopenad.util.Constant
import com.frogobox.admob.appopenad.util.startActivityExt

/** The main activity in the app. */
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setupViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()
    }

    /** Override the default implementation when the user presses the back key. */
    override fun onBackPressed() {
        // Move the task containing the MainActivity to the back of the activity stack, instead of
        // destroying it. Therefore, MainActivity will be shown when the user switches back to the app.
        moveTaskToBack(true)
    }

    private fun setupUI() {
        binding.apply {
            btnRequestAd.setOnClickListener {
                // Show the app open ad.
                setupAppOpenAd()

            }
        }
    }

    private fun setupAppOpenAd() {
        val application = application as? AdApplication

        if (application != null) {
            application.showAdIfAvailable(
                this@MainActivity,
                AdHelper.getAdOpenAppUnitId(this@MainActivity),
                object : AdmobAppOpenAdCallback {
                    override fun onAdDismissed(tag: String, message: String) {
                        startActivityExt(DetailActivity::class.java)
                        Log.d("MainActivity", "onAdDismissed: $tag, $message")
                    }

                    override fun onAdShowed(tag: String, message: String) {
                        Log.d("MainActivity", "onAdShowed: $tag, $message")
                    }
                })
        } else {
            Log.e("SplashScreen", "Failed to cast application to MyApplication.")
            startActivityExt(DetailActivity::class.java)
        }
    }

}