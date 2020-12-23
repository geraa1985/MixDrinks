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

    override fun showIngredient1(ingredient: String) {
        binding.ingredient1.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient2(ingredient: String) {
        binding.ingredient2.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient3(ingredient: String) {
        binding.ingredient3.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient4(ingredient: String) {
        binding.ingredient4.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient5(ingredient: String) {
        binding.ingredient5.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient6(ingredient: String) {
        binding.ingredient6.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient7(ingredient: String) {
        binding.ingredient7.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient8(ingredient: String) {
        binding.ingredient8.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient9(ingredient: String) {
        binding.ingredient9.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient10(ingredient: String) {
        binding.ingredient10.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient11(ingredient: String) {
        binding.ingredient11.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient12(ingredient: String) {
        binding.ingredient12.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient13(ingredient: String) {
        binding.ingredient13.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient14(ingredient: String) {
        binding.ingredient14.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showIngredient15(ingredient: String) {
        binding.ingredient15.apply {
            visibility = View.VISIBLE
            text = ingredient
        }
    }

    override fun showMeasure1(measure: String) {
        binding.measure1.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure2(measure: String) {
        binding.measure2.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure3(measure: String) {
        binding.measure3.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure4(measure: String) {
        binding.measure4.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure5(measure: String) {
        binding.measure5.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure6(measure: String) {
        binding.measure6.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure7(measure: String) {
        binding.measure7.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure8(measure: String) {
        binding.measure8.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure9(measure: String) {
        binding.measure9.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure10(measure: String) {
        binding.measure10.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure11(measure: String) {
        binding.measure11.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure12(measure: String) {
        binding.measure12.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure13(measure: String) {
        binding.measure13.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure14(measure: String) {
        binding.measure14.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showMeasure15(measure: String) {
        binding.measure15.apply {
            visibility = View.VISIBLE
            text = measure
        }
    }

    override fun showCategory(categoty: String) {
        binding.category.apply {
            visibility = View.VISIBLE
            text = categoty
        }
    }

    override fun showAlcoholic(alcoholic: String) {
        binding.alcoholic.apply {
            visibility = View.VISIBLE
            text = alcoholic
        }
    }

    override fun showGlass(glass: String) {
        binding.glass.apply {
            visibility = View.VISIBLE
            text = glass
        }
    }

    override fun showInstruction(instruction: String) {
        binding.instruction.apply {
            visibility = View.VISIBLE
            text = instruction
        }
    }

    @SuppressLint("ShowToast")
    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun backClicked(): Boolean {
        return presenter.backClicked()
    }
}