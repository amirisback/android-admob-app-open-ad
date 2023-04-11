package com.google.android.gms.example.appopenexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.example.appopenexample.R
import com.google.android.gms.example.appopenexample.common.base.BaseActivity
import com.google.android.gms.example.appopenexample.databinding.ActivityMainBinding
import com.google.android.gms.example.appopenexample.util.startActivityExt

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
                startActivityExt(DetailActivity::class.java)
            }
        }
    }

}