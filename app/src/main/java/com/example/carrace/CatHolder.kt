package com.example.carrace

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.carrace.databinding.ItemCatsBinding

class CatHolder (
    private val binding: ItemCatsBinding,
    private val onClick: (Int) -> Unit,
) : ViewHolder(binding.root) {

    fun onBind(cat: Cat) {
        binding.run {
            tvName.text = cat.name
            tvShortDesc.text = cat.shortDescription

            Glide.with(itemView.context).
            load(cat.imageUrl).
            error(R.drawable.image_not_found).
            placeholder(R.drawable.image_loading).
            into(ivImage)

            root.setOnClickListener{
                onClick(cat.id)
            }
        }
    }
}