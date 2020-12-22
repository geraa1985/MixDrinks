package com.geraa1985.mixdrinks.ui.activities

import android.content.Intent
import android.os.Bundle
import com.geraa1985.mixdrinks.MyApp
import com.geraa1985.mixdrinks.mvp.presenter.base.SplashPresenter
import com.geraa1985.mixdrinks.mvp.view.base.ISplashView
import com.geraa1985.mixdrinks.navigation.ActivityScreen
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class SplashActivity : MvpAppCompatActivity(), ISplashView {

    val presenter: SplashPresenter by moxyPresenter {
        SplashPresenter().apply {
            MyApp.instance.mainGraph.inject(this)
        }
    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = SupportAppNavigator(this, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApp.instance.mainGraph.inject(this)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun go() {
        router.newRootScreen(ActivityScreen(Intent(this, MainActivity::class.java)))
    }

    override fun theEnd() {
        router.exit()
        navigatorHolder.removeNavigator()
    }

    override fun onPause() {
        super.onPause()
        presenter.theEnd()
    }

}