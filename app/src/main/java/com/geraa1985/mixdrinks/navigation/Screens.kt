package com.geraa1985.mixdrinks.navigation

import androidx.fragment.app.Fragment
import com.geraa1985.mixdrinks.ui.fragments.CocktailFragment
import com.geraa1985.mixdrinks.ui.fragments.ListFragment
import com.geraa1985.mixdrinks.ui.fragments.SelectFragment
import moxy.MvpAppCompatFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens(private val fragment: MvpAppCompatFragment): SupportAppScreen() {

    override fun getFragment(): Fragment {
        return fragment
    }

    companion object{
        fun selectScreen() = Screens(SelectFragment())
        fun listScreen(isAlco: Boolean) = Screens(ListFragment.newInstance(isAlco))
        fun cocktailScreen(id: String) = Screens(CocktailFragment.newInstance(id))
    }
}