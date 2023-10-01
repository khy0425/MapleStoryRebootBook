package com.leaf.rebootBook.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.leaf.rebootBook.dataClass.BossMonster
import com.leaf.rebootBook.fragment.BossCrystalPriceFragment

class BossCrystalPricePagerAdapter(
    fragmentActivity: FragmentActivity,
    private val allBossList: List<BossMonster>
) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = mutableMapOf<Int, BossCrystalPriceFragment>()

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        val bossType = when (position) {
            0 -> BossMonster.BossType.DAILY
            1 -> BossMonster.BossType.WEEKLY
            2 -> BossMonster.BossType.MONTHLY
            else -> throw IllegalStateException("Invalid position")
        }
        val fragment = BossCrystalPriceFragment.newInstance(
            allBossList.filter { it.bossType == bossType },
            bossType
        )
        fragments[position] = fragment
        return fragment
    }

    fun getFragment(position: Int): BossCrystalPriceFragment? {
        return fragments[position]
    }
}