package com.example.rebootBook.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.rebootBook.adapter.ChaserBigGridAdapter
import com.example.rebootBook.databinding.FragmentMidnightChaserHelperBinding
import com.example.rebootBook.viewModel.MidnightChaserViewModel

class MidnightChaserHelperFragment : Fragment() {

    private lateinit var binding: FragmentMidnightChaserHelperBinding
    private lateinit var viewModel: MidnightChaserViewModel
    private lateinit var adapter: ChaserBigGridAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMidnightChaserHelperBinding.inflate(inflater, container, false)

        val glide = Glide.with(this)
        viewModel = ViewModelProvider(this)[MidnightChaserViewModel::class.java]

        // 어댑터 초기화
        adapter = ChaserBigGridAdapter(glide) { bigIndex, smallIndex ->
            viewModel.onChaserClicked(bigIndex, smallIndex)
        }

        // binding 설정
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // 리사이클러뷰 어댑터 및 레이아웃 매니저 설정
        binding.recyclerView.adapter = adapter

        // ViewModel의 LiveData를 관찰하여 데이터 변경 시 어댑터에 전달
        viewModel.bigGridItems.observe(viewLifecycleOwner) { newItems ->
            adapter.updateBigGridItems(newItems)
        }

        return binding.root
    }
}
