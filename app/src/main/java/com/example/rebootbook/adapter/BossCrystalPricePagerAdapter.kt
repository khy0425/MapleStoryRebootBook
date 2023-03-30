package com.example.rebootBook.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rebootBook.fragment.DailyBossCrystalPriceFragment
import com.example.rebootBook.fragment.MonthlyBossCrystalPriceFragment
import com.example.rebootBook.fragment.WeeklyBossCrystalPriceFragment

class BossCrystalPricePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    private val fragments: MutableList<Fragment> = ArrayList()

    init {
        fragments.add(DailyBossCrystalPriceFragment.newInstance("일간"))
        fragments.add(WeeklyBossCrystalPriceFragment.newInstance("주간"))
        fragments.add(MonthlyBossCrystalPriceFragment.newInstance("월간"))
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun getFragment(position: Int): Fragment {
        return fragments[position]
    }
}