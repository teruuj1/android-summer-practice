package com.example.carrace

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrace.databinding.ItemCatsBinding

class CatAdapter(
    private val list: List<Cat>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<CatHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatHolder
         = CatHolder(
            binding = ItemCatsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick = onClick,
        )


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CatHolder, position: Int) {
        holder.onBind(list[position])
    }
}