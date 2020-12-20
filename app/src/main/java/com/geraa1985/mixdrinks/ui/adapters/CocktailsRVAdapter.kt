package com.geraa1985.mixdrinks.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.geraa1985.mixdrinks.databinding.ItemRvCocktailsBinding
import com.geraa1985.mixdrinks.mvp.model.repositoties.ILoadImage
import com.geraa1985.mixdrinks.mvp.presenter.lists.ICocktailListPresenter
import com.geraa1985.mixdrinks.mvp.view.lists.ICocktailItemView
import javax.inject.Inject

class CocktailsRVAdapter(
    private val presenter: ICocktailListPresenter
) : RecyclerView.Adapter<CocktailsRVAdapter.ViewHolder>() {

    @Inject
    lateinit var imgLoader: ILoadImage<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvCocktailsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.getItem().setOnClickListener {
            presenter.itemClickListener?.invoke(holder)
        }
        presenter.bindView(holder)

    }

    override fun getItemCount(): Int = presenter.getCount()

    inner class ViewHolder(private val binding: ItemRvCocktailsBinding) :
        RecyclerView.ViewHolder(binding.root), ICocktailItemView {

        override fun setName(name: String) {
            binding.coctailName.text = name
        }

        override fun setImage(image: String) {
            imgLoader.loadInto(image, binding.cocktailImage)
        }

        override var pos = 0

        fun getItem() = binding.root
    }
}