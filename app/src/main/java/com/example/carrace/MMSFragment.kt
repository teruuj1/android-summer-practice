package com.example.carrace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.carrace.databinding.FragmentMmsBinding

class MMSFragment : Fragment(R.layout.fragment_mms) {

    private var binding: FragmentMmsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMmsBinding.bind(view)

        binding?.run {
            heading.setOnClickListener {
                findNavController().navigate(R.id.action_mms_to_sport)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
