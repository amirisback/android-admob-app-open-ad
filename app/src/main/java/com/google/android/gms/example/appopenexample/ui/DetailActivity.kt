package com.google.android.gms.example.appopenexample.ui

import android.os.Bundle
import com.google.android.gms.example.appopenexample.common.base.BaseActivity
import com.google.android.gms.example.appopenexample.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    override fun setupViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}