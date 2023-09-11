package com.example.rebootBook.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.rebootBook.adapter.ChaserBigGridAdapter
import com.example.rebootBook.databinding.FragmentMidnightChaserHelperBinding
import com.example.rebootBook.viewModel.MidnightChaserViewModel

class MidnightChaserHelperFragment : Fragment() {

    private lateinit var binding: FragmentMidnightChaserHelperBinding
    private lateinit var viewModel: MidnightChaserViewModel
    private lateinit var adapter: ChaserBigGridAdapter

    val requestListener = object : RequestListener<Drawable> {
        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: com.bumptech.glide.request.target.Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {
            Log.e("GlideLog", "Load failed", e)
            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: com.bumptech.glide.request.target.Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {
            Log.d("GlideLog", "Resource ready")
            return false
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMidnightChaserHelperBinding.inflate(inflater, container, false)

        val glide = Glide.with(this)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MidnightChaserViewModel::class.java]

        // 어댑터 초기화
        adapter = ChaserBigGridAdapter(glide, { bigIndex, smallIndex ->
            viewModel.onChaserClicked(bigIndex, smallIndex)
        }, requestListener)

        // binding 설정
        binding.viewModel = viewModel
        binding.adapter = adapter
        binding.lifecycleOwner = this

        val layoutManager = GridLayoutManager(context, 3) // 3x3 그리드 설정
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter  // 어댑터를 recyclerView에 연결

        // ViewModel의 LiveData를 관찰하여 데이터 변경 시 어댑터에 전달
        viewModel.bigGridItems.observe(viewLifecycleOwner) { newItems ->
            adapter.updateBigGridItems(newItems)
        }
        binding.resetButton.setOnClickListener {
            viewModel.onResetButtonClick()
        }

        return binding.root
    }
}