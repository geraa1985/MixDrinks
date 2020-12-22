package com.geraa1985.mixdrinks.navigation

import android.content.Context
import android.content.Intent
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ActivityScreen(private val intent: Intent): SupportAppScreen() {

    override fun getActivityIntent(context: Context): Intent {
        return intent
    }

}