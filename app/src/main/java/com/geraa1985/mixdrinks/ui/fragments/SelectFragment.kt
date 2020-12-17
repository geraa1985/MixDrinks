package com.geraa1985.mixdrinks.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geraa1985.mixdrinks.MyApp
import com.geraa1985.mixdrinks.databinding.FragmentSelectBinding
import com.geraa1985.mixdrinks.mvp.presenter.base.SelectPresenter
import com.geraa1985.mixdrinks.mvp.view.base.ISelectView
import com.geraa1985.mixdrinks.ui.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SelectFragment: MvpAppCompatFragment(), ISelectView, BackButtonListener {

    private lateinit var binding: FragmentSelectBinding

    private val presenter: SelectPresenter by moxyPresenter {
        SelectPresenter().apply { MyApp.instance.mainGraph.inject(this) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectBinding.inflate(inflater)
        return binding.root
    }

    override fun backClicked(): Boolean {
        return presenter.backClicked()
    }
}