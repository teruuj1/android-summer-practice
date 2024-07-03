package com.example.carrace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.carrace.databinding.FragmentSelfImpBinding

class SelfImpFragment : Fragment(R.layout.fragment_self_imp) {

    private var binding: FragmentSelfImpBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSelfImpBinding.bind(view)

        binding?.run {
            heading.setOnClickListener {
                findNavController().navigate(R.id.action_selfimp_to_mood)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
