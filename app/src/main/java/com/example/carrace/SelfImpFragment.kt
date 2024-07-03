package com.example.carrace

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrace.databinding.FragmentSelfImpBinding

class SelfImpFragment : Fragment(R.layout.fragment_self_imp) {

    private var binding: FragmentSelfImpBinding? = null
    private var adapter: CatAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSelfImpBinding.bind(view)

        binding?.run {
            adapter = CatAdapter(CatRepository.cats) { catId ->
                val cat = CatRepository.cats.find { it.id == catId }
                cat?.let {
                    val catDetailBundle =
                        CatDetailFragment.bundle(it.name, it.longDescription, it.imageUrl)
                    findNavController().navigate(R.id.action_selfimp_to_catDetail, catDetailBundle)
                }
            }

            rvCats.adapter = adapter
            rvCats.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
