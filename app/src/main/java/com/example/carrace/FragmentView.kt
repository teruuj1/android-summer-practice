package com.example.carrace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.carrace.databinding.FragmentViewBinding

class FragmentView : Fragment(R.layout.fragment_view) {
    private var binding: FragmentViewBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentViewBinding.bind(view)

        val text = arguments?.getString(ARG_TEXT) ?: "ERROR"
        binding?.textView?.text = "your mood today : $text"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_TEXT = "ARG_TEXT"

        fun bundle(text: String): Bundle = Bundle().apply {
            putString(ARG_TEXT, text)
        }
    }
}