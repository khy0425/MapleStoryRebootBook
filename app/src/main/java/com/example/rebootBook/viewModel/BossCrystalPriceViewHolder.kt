package com.example.rebootBook.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rebootBook.R
import com.example.rebootBook.dataClass.BossMonster

//class BossCrystalPriceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    val imageView: ImageView = itemView.findViewById(R.id.iv_boss_image)
//    val nameTextView: TextView = itemView.findViewById(R.id.tv_boss_name)
//    val diffTextView: TextView = itemView.findViewById(R.id.tv_boss_difficulty)
//    val priceTextView: TextView = itemView.findViewById(R.id.tv_boss_price)
//
//    fun bind(bossMonster: com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster) {
//        imageView.setImageResource(bossMonster.imageResId)
//        nameTextView.text = bossMonster.name
//        diffTextView.text = bossMonster.diff
//        priceTextView.text = bossMonster.price
//    }
//
//    companion object {
//        fun from(parent: ViewGroup): BossCrystalPriceViewHolder {
//            val inflater = LayoutInflater.from(parent.context)
//            val view = inflater.inflate(R.layout.item_boss_monster, parent, false)
//            return BossCrystalPriceViewHolder(view)
//        }
//    }
//}