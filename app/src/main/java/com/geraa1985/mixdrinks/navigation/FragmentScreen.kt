package com.geraa1985.mixdrinks.navigation

import androidx.fragment.app.Fragment
import com.geraa1985.mixdrinks.ui.fragments.CocktailFragment
import com.geraa1985.mixdrinks.ui.fragments.ListFragment
import com.geraa1985.mixdrinks.ui.fragments.SelectFragment
import moxy.MvpAppCompatFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FragmentScreen(private val fragment: MvpAppCompatFragment): SupportAppScreen() {

    override fun getFragment(): Fragment {
        return fragment
    }

    companion object{
        fun selectScreen() = FragmentScreen(SelectFragment())
        fun listScreen(isAlco: Boolean) = FragmentScreen(ListFragment.newInstance(isAlco))
        fun cocktailScreen(id: String) = FragmentScreen(CocktailFragment.newInstance(id))
    }
}