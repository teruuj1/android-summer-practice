package com.example.carrace

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.carrace.databinding.FragmentMoodBinding
import com.google.android.material.snackbar.Snackbar

class MoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_mood, container, false)
    }

    private var binding: FragmentMoodBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoodBinding.bind(view)

        binding?.run {
            buttonSend.setOnClickListener {
                val emailText = email.text.toString()
                if (emailText.isNotEmpty()) {
                    findNavController().navigate(
                        R.id.action_moodFragment_to_viewFragment,
                        FragmentView.bundle(emailText)
                    )
                } else {
                    Snackbar.make(
                        it, R.string.empty_field, Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
