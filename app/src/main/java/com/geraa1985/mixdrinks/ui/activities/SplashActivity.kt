package com.geraa1985.mixdrinks.ui.activities

import android.content.Intent
import com.geraa1985.mixdrinks.mvp.presenter.base.SplashPresenter
import com.geraa1985.mixdrinks.mvp.view.base.ISplashView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class SplashActivity : MvpAppCompatActivity(), ISplashView {

    val presenter: SplashPresenter by moxyPresenter { SplashPresenter() }

    override fun go() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun theEnd() {
        finish()
    }

    override fun onPause() {
        super.onPause()
        presenter.theEnd()
    }

}