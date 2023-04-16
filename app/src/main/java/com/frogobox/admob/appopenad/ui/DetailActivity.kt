package com.frogobox.admob.appopenad.ui

import android.os.Bundle
import com.frogobox.admob.appopenad.common.base.BaseActivity
import com.frogobox.admob.appopenad.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    override fun setupViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}