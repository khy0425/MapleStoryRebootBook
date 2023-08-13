package com.example.rebootBook.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rebootBook.R
import com.example.rebootBook.adapter.HuntingLocationAdapter
import com.example.rebootBook.viewModel.HuntingViewModel

class UnionBaseHuntingFragment : Fragment() {
    private lateinit var viewModel: HuntingViewModel
    private lateinit var adapter: HuntingLocationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hunting, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = HuntingLocationAdapter()
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(requireActivity())[HuntingViewModel::class.java]
        viewModel.unionBaseHuntingLocations.observe(viewLifecycleOwner) { data ->
            adapter.submitList(data)
        }

        val divider = ContextCompat.getDrawable(requireContext(), R.drawable.divider)
        if (divider != null) {
            val itemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            itemDecoration.setDrawable(divider)
            recyclerView.addItemDecoration(itemDecoration)
        }


        return view
    }
}
