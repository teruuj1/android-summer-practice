package com.example.carrace

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.carrace.databinding.FragmentCatDetailBinding

class CatDetailFragment : Fragment(R.layout.fragment_cat_detail) {
    private var binding: FragmentCatDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCatDetailBinding.bind(view)

        arguments?.let {
            val name = it.getString(ARG_NAME)
            val description = it.getString(ARG_DESCRIPTION)
            val imageUrl = it.getString(ARG_IMAGE_URL)

            Log.d(
                "CatDetailFragment",
                "Name: $name, Description: $description, ImageURL: $imageUrl"
            )

            binding?.tvName?.text = name ?: "Default Name"
            binding?.tvDesc?.text = description ?: "Default Description"

            Glide.with(this)
                .load(imageUrl)
                .error(R.drawable.image_not_found)
                .placeholder(R.drawable.image_loading)
                .into(binding!!.ivImage)
        }

        binding?.run {
            view.findViewById<Button>(R.id.backButton).setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_NAME = "name"
        private const val ARG_DESCRIPTION = "description"
        private const val ARG_IMAGE_URL = "imageUrl"

        fun bundle(name: String, description: String, imageUrl: String): Bundle = Bundle().apply {
            putString(ARG_NAME, name)
            putString(ARG_DESCRIPTION, description)
            putString(ARG_IMAGE_URL, imageUrl)
        }
    }
}