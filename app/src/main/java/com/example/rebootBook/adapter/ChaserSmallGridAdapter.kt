package com.example.rebootBook.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.example.rebootBook.dataClass.MidnightChaser
import com.example.rebootBook.databinding.ItemSmallImageBinding

class ChaserSmallGridAdapter(
    private val glide: RequestManager,
    private val onImageClicked: (Int) -> Unit,
    private val requestListener: RequestListener<Drawable>
) : RecyclerView.Adapter<ChaserSmallGridAdapter.ViewHolder>() {

    private var chasers: MutableList<MidnightChaser> = mutableListOf()

    fun updateChasers(newChasers: List<MidnightChaser>) {
        this.chasers = newChasers.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSmallImageBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chaser = chasers[position]
        holder.bind(chaser)
    }

    override fun getItemCount() = chasers.size

    inner class ViewHolder(private val binding: ItemSmallImageBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                val chaser = chasers[position]

                if (chaser.state == MidnightChaser.State.SELECTED) {
                    // 이미 선택된 상태의 이미지를 다시 클릭했을 때 처리
                    chaser.state = MidnightChaser.State.UNSELECTED
                    notifyDataSetChanged()
                }
                else if (chaser.state == MidnightChaser.State.UNSELECTED) {
                    // 새로운 이미지를 선택했을 때 처리
                    chasers.forEach {
                        if (it.state == MidnightChaser.State.SELECTED) {
                            it.state = MidnightChaser.State.UNSELECTABLE
                        } else {
                            it.state = MidnightChaser.State.UNSELECTED
                        }
                    }
                    chaser.state = MidnightChaser.State.SELECTED
                    notifyDataSetChanged()
                }
                onImageClicked(position)
            }
        }
        fun bind(chaser: MidnightChaser) {
            when (chaser.state) {
                MidnightChaser.State.UNSELECTED -> {
                    glide.load(chaser.smallResId)
                        .listener(requestListener)
                        .into(binding.imageView)
                    binding.imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                    binding.imageView.isEnabled = true
                    binding.imageView.visibility = View.VISIBLE
                }

                MidnightChaser.State.UNSELECTABLE -> {
                    glide.load(chaser.smallResId)
                        .listener(requestListener)
                        .into(binding.imageView)
                    binding.imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                    binding.imageView.isEnabled = false
                    binding.imageView.visibility = View.VISIBLE
                }

                MidnightChaser.State.SELECTED -> {
                    glide.load(chaser.bigResId)
                        .listener(requestListener)
                        .into(binding.imageView)
                    binding.imageView.scaleType = ImageView.ScaleType.FIT_CENTER
                    binding.imageView.isEnabled = true
                    binding.imageView.visibility = View.VISIBLE
                }

                MidnightChaser.State.UNAVAILABLE -> {
                    binding.imageView.visibility = View.INVISIBLE
                }
            }
        }
    }
}