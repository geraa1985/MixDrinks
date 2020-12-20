package com.geraa1985.mixdrinks.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.geraa1985.mixdrinks.MyApp
import com.geraa1985.mixdrinks.R
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

    private lateinit var searchItem: MenuItem

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
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val mainToolbar = binding.listToolbar
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(mainToolbar)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.appbar_menu, menu)
        searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = presenter.searchHint()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchItem.collapseActionView()
                presenter.searchCocktail(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                presenter.searchCocktails(newText)
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
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
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun backClicked(): Boolean {
        return presenter.backClicked()
    }

    override fun onStop() {
        searchItem.collapseActionView()
        super.onStop()
    }
}