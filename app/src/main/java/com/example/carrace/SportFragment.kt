package com.example.carrace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.carrace.databinding.FragmentSportBinding

class SportFragment : Fragment(R.layout.fragment_sport) {

    private var binding: FragmentSportBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSportBinding.bind(view)

        binding?.run {
            heading.setOnClickListener {
                findNavController().navigate(R.id.action_sport_to_selfimp)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
