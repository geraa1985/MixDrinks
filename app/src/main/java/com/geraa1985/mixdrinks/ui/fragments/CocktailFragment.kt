package com.geraa1985.mixdrinks.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.geraa1985.mixdrinks.MyApp
import com.geraa1985.mixdrinks.databinding.FragmentCocktailBinding
import com.geraa1985.mixdrinks.mvp.model.repositoties.ILoadImage
import com.geraa1985.mixdrinks.mvp.presenter.base.CocktailPresenter
import com.geraa1985.mixdrinks.mvp.view.base.ICocktailView
import com.geraa1985.mixdrinks.ui.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class CocktailFragment: MvpAppCompatFragment(), BackButtonListener, ICocktailView {

    companion object {
        private const val ID_KEY = "id"

        fun newInstance(id: String) = CocktailFragment().apply {
            arguments = Bundle().apply {
                putString(ID_KEY, id)
            }
            MyApp.instance.mainGraph.inject(this)
        }
    }

    @Inject
    lateinit var imgLoader: ILoadImage<ImageView>

    private lateinit var binding: FragmentCocktailBinding

    private val presenter: CocktailPresenter by moxyPresenter {
        CocktailPresenter().apply { MyApp.instance.mainGraph.inject(this) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCocktailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun setId() {
        val id: String? = arguments?.getString(ID_KEY)
        presenter.setId(id)
    }

    override fun showPicture(url: String) {
        imgLoader.loadInto(url, binding.cocktailPicture)
    }

    override fun showName(name: String) {
        binding.cocktailToolbar.title = name
    }

    @SuppressLint("ShowToast")
    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun backClicked(): Boolean {
        return presenter.backClicked()
    }
}