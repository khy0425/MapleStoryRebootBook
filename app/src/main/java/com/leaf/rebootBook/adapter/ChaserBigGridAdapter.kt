package com.leaf.rebootBook.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestListener
import com.leaf.rebootBook.dataClass.MidnightChaser
import com.leaf.rebootBook.databinding.ItemMidnightChaserBinding

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

                val deselectedImageId = selectedChaser?.smallResId

                selectedChaser?.state = MidnightChaser.State.UNSELECTED

                val alreadySelectedImages = bigGridItems.flatten().filter { it.state == MidnightChaser.State.SELECTED }.map { it.smallResId }.toSet()
                smallGridItems.forEach { chaser ->
                    if (chaser.smallResId == deselectedImageId) {
                        chaser.state = MidnightChaser.State.UNSELECTED
                    }
                }

                bigGridItems.forEachIndexed { idx, itemList ->
                    if (idx == adapterPosition) {
                        // 현재 셀이므로 이미 처리됨
                        return@forEachIndexed
                    }
                    itemList.forEach { chaser ->
                        if (alreadySelectedImages.contains(chaser.smallResId)) {
                            if (chaser.state != MidnightChaser.State.SELECTED) {
                                chaser.state = MidnightChaser.State.UNAVAILABLE
                            }
                        } else if (chaser.smallResId == deselectedImageId) {
                            chaser.state = MidnightChaser.State.UNSELECTED
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

                val alreadySelectedImages = bigGridItems.flatten().filter { it.state == MidnightChaser.State.SELECTED }.map { it.smallResId }.toSet()

                val filteredItems = smallGridItems.map { chaser ->
                    if (alreadySelectedImages.contains(chaser.smallResId)) {
                        chaser.copy(state = MidnightChaser.State.UNAVAILABLE)
                    } else {
                        chaser.copy(state = MidnightChaser.State.UNSELECTED)
                    }
                }
                smallGridAdapter.updateChasers(filteredItems)
            }
        }
    }
}