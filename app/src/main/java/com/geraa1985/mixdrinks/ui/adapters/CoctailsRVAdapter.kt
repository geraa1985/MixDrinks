package com.geraa1985.mixdrinks.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.geraa1985.mixdrinks.databinding.ItemRvCoctailsBinding
import com.geraa1985.mixdrinks.mvp.model.repositoties.ILoadImage
import com.geraa1985.mixdrinks.mvp.presenter.lists.ICoctailListPresenter
import com.geraa1985.mixdrinks.mvp.view.lists.ICoctailItemView
import javax.inject.Inject

class CoctailsRVAdapter(
    private val presenter: ICoctailListPresenter
) : RecyclerView.Adapter<CoctailsRVAdapter.ViewHolder>() {

    @Inject
    lateinit var imgLoader: ILoadImage<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvCoctailsBinding.inflate(inflater, parent, false)
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

    inner class ViewHolder(private val binding: ItemRvCoctailsBinding) :
        RecyclerView.ViewHolder(binding.root), ICoctailItemView {

        override fun setName(name: String) {
            binding.coctailName.text = name
        }

        override fun setImage(image: String) {
            imgLoader.loadInto(image, binding.coctailImage)
        }

        override var pos = 0

        fun getItem() = binding.root
    }
}