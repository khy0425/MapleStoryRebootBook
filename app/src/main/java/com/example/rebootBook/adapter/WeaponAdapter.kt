package com.example.rebootBook.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rebootBook.dataClass.Weapon
import com.example.rebootBook.databinding.ItemWeaponOptionBinding

class WeaponAdapter(private var weapons: List<Weapon>) : RecyclerView.Adapter<WeaponAdapter.WeaponViewHolder>() {

    // ViewHolder 클래스 정의
    class WeaponViewHolder(private val binding: ItemWeaponOptionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(weapon: Weapon) {
            Glide.with(binding.root)
                .load(weapon.imageResId)
                .into(binding.weaponImageView)

            binding.weaponTypeTextView.text = weapon.type.getDisPlay()
            binding.weaponNameTextView.text = weapon.name

            // 옵션 바인딩
            val optionLabels = listOf(binding.option1Label, binding.option2Label, binding.option3Label, binding.option4Label, binding.option5Label)
            val optionValues = listOf(binding.option1TextView, binding.option2TextView, binding.option3TextView, binding.option4TextView, binding.option5TextView)

            weapon.options.entries.forEachIndexed { index, entry ->
                if (index < optionLabels.size) {
                    optionLabels[index].text = entry.key
                    optionValues[index].text = entry.value.toString()
                }
            }
        }
    }

    // 아이템 뷰를 위한 레이아웃을 인플레이트하고 ViewHolder를 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeaponViewHolder {
        val binding = ItemWeaponOptionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeaponViewHolder(binding)
    }

    fun submitList(newWeapons: List<Weapon>) {
        weapons = newWeapons
        notifyDataSetChanged()
    }

    // 데이터와 뷰를 바인딩
    override fun onBindViewHolder(holder: WeaponViewHolder, position: Int) {
        holder.bind(weapons[position])
    }

    // 아이템 개수 반환
    override fun getItemCount(): Int {
        return weapons.size
    }
}