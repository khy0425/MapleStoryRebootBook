package com.example.rebootBook.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestListener
import com.example.rebootBook.dataClass.MidnightChaser
import com.example.rebootBook.databinding.ItemMidnightChaserBinding

class ChaserBigGridAdapter(
    private val glide: RequestManager,
    private val onChaserClicked: (Int, Int) -> Unit,
    private val requestListener: RequestListener<Drawable>
) : RecyclerView.Adapter<ChaserBigGridAdapter.ViewHolder>() {

    private var bigGridItems: List<List<MidnightChaser>> = listOf()

    fun updateBigGridItems(newItems: List<List<MidnightChaser>>) {
        this.bigGridItems = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMidnightChaserBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val smallGridItems = bigGridItems[position]
        holder.bind(smallGridItems, position)
    }

    override fun getItemCount() = bigGridItems.size

    inner class ViewHolder(private val binding: ItemMidnightChaserBinding) : RecyclerView.ViewHolder(binding.root) {
        private val smallGridAdapter = ChaserSmallGridAdapter(glide, { smallIndex ->
            onChaserClicked(adapterPosition, smallIndex)
        }, requestListener)

        init {
            binding.smallGrid.layoutManager = GridLayoutManager(binding.root.context, 3)
            binding.smallGrid.adapter = smallGridAdapter

            binding.bigImageView.setOnClickListener {
                val smallGridItems = bigGridItems[adapterPosition]
                val selectedChaser = smallGridItems.firstOrNull { it.state == MidnightChaser.State.SELECTED }
                selectedChaser?.state = MidnightChaser.State.UNSELECTED

                // 현재 선택된 모든 이미지를 찾기
                val currentlySelectedImages = mutableSetOf<Int>()
                bigGridItems.forEach { itemList ->
                    itemList.forEach {
                        if (it.state == MidnightChaser.State.SELECTED) {
                            currentlySelectedImages.add(it.smallResId)
                        }
                    }
                }

                // 선택한 셀을 제외한 모든 셀을 업데이트
                bigGridItems.forEachIndexed { idx, itemList ->
                    if (idx != adapterPosition) {
                        itemList.forEach {
                            if (it.smallResId == selectedChaser?.smallResId) {
                                it.state = MidnightChaser.State.UNSELECTED
                            }
                            // 이미 선택된 이미지는 다른 셀에서 숨김
                            if (currentlySelectedImages.contains(it.smallResId)) {
                                it.state = MidnightChaser.State.UNSELECTABLE
                            }
                        }
                    } else {
                        itemList.forEach {
                            if (!currentlySelectedImages.contains(it.smallResId) || it.smallResId == selectedChaser?.smallResId) {
                                it.state = MidnightChaser.State.UNSELECTED
                            }
                        }
                    }
                }

                binding.smallGrid.visibility = View.VISIBLE
                binding.bigImageView.visibility = View.INVISIBLE
                notifyDataSetChanged()
            }
        }
        fun bind(smallGridItems: List<MidnightChaser>, position: Int) {
            val isSelected = smallGridItems.any { it.state == MidnightChaser.State.SELECTED }

            if (isSelected) {
                val selectedChaser = smallGridItems.first { it.state == MidnightChaser.State.SELECTED }
                glide.load(selectedChaser.bigResId).into(binding.bigImageView)
                binding.bigImageView.visibility = View.VISIBLE
                binding.smallGrid.visibility = View.INVISIBLE
            } else {
                binding.bigImageView.visibility = View.INVISIBLE
                binding.smallGrid.visibility = View.VISIBLE
                // 이미 선택된 이미지는 다른 셀에서 표시되지 않도록 필터링합니다.
                val filteredItems = smallGridItems.filter {
                    it.state != MidnightChaser.State.SELECTED
                }
                smallGridAdapter.updateChasers(filteredItems)
            }
        }

    }
}