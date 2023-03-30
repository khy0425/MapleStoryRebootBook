package com.example.rebootBook.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.rebootBook.R
import com.example.rebootBook.dataClass.BossMonster
import com.example.rebootBook.viewModel.BossCrystalPriceViewHolder

class BossMonsterAdapter : ListAdapter<BossMonster, BossCrystalPriceViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<BossMonster>() {
            override fun areItemsTheSame(oldItem: BossMonster, newItem: BossMonster): Boolean {
                return oldItem.name == newItem.name && oldItem.price == newItem.price
            }

            override fun areContentsTheSame(oldItem: BossMonster, newItem: BossMonster): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BossCrystalPriceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_boss_monster, parent, false)
        return BossCrystalPriceViewHolder(view)
    }

    override fun onBindViewHolder(holder: BossCrystalPriceViewHolder, position: Int) {
        val bossMonster = getItem(position)
        holder.imageView.setImageResource(bossMonster.imageResId)
        holder.nameTextView.text = bossMonster.name
        holder.diffTextView.text = bossMonster.diff
        holder.priceTextView.text = bossMonster.price

        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"))
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#F0F0F0"))
        }
    }
}
