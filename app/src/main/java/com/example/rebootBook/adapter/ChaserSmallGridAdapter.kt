package com.example.rebootBook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.rebootBook.dataClass.MidnightChaser
import com.example.rebootBook.databinding.ItemSmallImageBinding

class ChaserSmallGridAdapter(
    private val glide: RequestManager,
    private val onImageClicked: (Int) -> Unit
) : RecyclerView.Adapter<ChaserSmallGridAdapter.ViewHolder>() {

    private var chasers: List<MidnightChaser> = listOf()

    fun updateChasers(newChasers: List<MidnightChaser>) {
        this.chasers = newChasers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSmallImageBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chaser = chasers[position]
        holder.bind(chaser, position)
    }

    override fun getItemCount() = chasers.size

    inner class ViewHolder(private val binding: ItemSmallImageBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onImageClicked(adapterPosition)
            }
        }

        fun bind(chaser: MidnightChaser, position: Int) {
            glide.load(
                when (chaser.state) {
                    MidnightChaser.State.UNSELECTED, MidnightChaser.State.UNSELECTABLE -> chaser.smallResId
                    MidnightChaser.State.SELECTED -> chaser.bigResId
                }
            ).into(binding.imageView)
            binding.imageView.isEnabled = chaser.state != MidnightChaser.State.UNSELECTABLE
        }
    }
}
