package com.geraa1985.mixdrinks.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.geraa1985.mixdrinks.MyApp
import com.geraa1985.mixdrinks.databinding.FragmentListBinding
import com.geraa1985.mixdrinks.mvp.presenter.base.ListPresenter
import com.geraa1985.mixdrinks.mvp.view.base.IListView
import com.geraa1985.mixdrinks.ui.BackButtonListener
import com.geraa1985.mixdrinks.ui.adapters.CoctailsRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ListFragment: MvpAppCompatFragment(), IListView, BackButtonListener {

    companion object {
        private const val ALCO_KEY = "alco"

        fun newInstance(isAlco: Boolean) = ListFragment().apply {
            arguments = Bundle().apply {
                putBoolean(ALCO_KEY, isAlco)
            }
        }
    }

    private lateinit var binding: FragmentListBinding

    private val presenter: ListPresenter by moxyPresenter {
        ListPresenter().apply { MyApp.instance.mainGraph.inject(this) }
    }

    private var adapter: CoctailsRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun setIsAlco() {
        val isAlco: Boolean? = arguments?.getBoolean(ALCO_KEY)
        presenter.setIsAlco(isAlco)
    }

    override fun initRvCoctails() {
        binding.rvCoctails.layoutManager = GridLayoutManager(requireContext(),2)
        adapter = CoctailsRVAdapter(presenter.coctailListPresenter).apply { MyApp.instance.mainGraph.inject(this) }
        binding.rvCoctails.adapter = adapter
    }

    override fun updateCoctailsList() {
        adapter?.notifyDataSetChanged()
    }

    @SuppressLint("ShowToast")
    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
    }

    override fun backClicked(): Boolean {
        return presenter.backClicked()
    }
}