package com.leaf.rebootBook.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import com.leaf.rebootBook.adapter.BossCrystalPricePagerAdapter
import com.leaf.rebootBook.dataClass.BossMonster
import com.leaf.rebootBook.dataClass.DropItem
import com.leaf.rebootBook.databinding.ActivityBossCrystalPriceBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.leaf.rebootBook.R

class BossCrystalPriceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBossCrystalPriceBinding
    private lateinit var allBossList: List<BossMonster>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_boss_crystal_price)
        setContentView(binding.root)

        allBossList = initAllBossList()

        val pagerAdapter = BossCrystalPricePagerAdapter(this, allBossList)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "일간"
                1 -> tab.text = "주간"
                2 -> tab.text = "월간"
            }
        }.attach()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                applyFilterToCurrentFragment(newText)
                return true
            }
        })

        initViews()
    }

    private fun applyFilterToCurrentFragment(query: String?) {
        val currentItem = binding.viewPager.currentItem
        val currentFragment = (binding.viewPager.adapter as? BossCrystalPricePagerAdapter)?.getFragment(currentItem)
        currentFragment?.applyFilter(query ?: "")
    }

    private fun initAllBossList(): MutableList<BossMonster> {
        return mutableListOf(
            BossMonster(
                imageResId = R.drawable.zakum_image,
                name = getString(R.string.zakum_name),
                diff = getString(R.string.diff_easy),
                price = getString(R.string.easy_zakum_price),
                bossType = BossMonster.BossType.DAILY,
                dropItems = listOf(
                    DropItem(name = getString(R.string.zakum_normal_hat), imageResId = R.drawable.zakum_hat),
                    DropItem(name = getString(R.string.zakum_eye), imageResId = R.drawable.zakum_eye),
                    DropItem(name = getString(R.string.zakum_face), imageResId = R.drawable.zakum_face)
                ),
                bossDesc = getString(R.string.zakum_easy_description),
                forceRequired = getString(R.string.force_noting),
                forceBoostRequired = getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.zakum_image,
                getString(R.string.zakum_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_zakum_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.zakum_eye), imageResId = R.drawable.zakum_eye),
                    DropItem(name = getString(R.string.zakum_face), imageResId = R.drawable.zakum_face),
                    DropItem(name = getString(R.string.zakum_weapon), imageResId = R.drawable.zakum_weapon)
                ),
                bossDesc = getString(R.string.zakum_normal_description),
                forceRequired = getString(R.string.force_noting),
                forceBoostRequired = getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.papulatus_image,
                getString(R.string.papulatus_name),
                getString(R.string.diff_easy),
                getString(R.string.easy_papulatus_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.meso), imageResId = R.drawable.boss_meso)
                ),
                getString(R.string.boss_quest),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),
            BossMonster(
                R.drawable.magnus_image,
                getString(R.string.magnus_name),
                getString(R.string.diff_easy),
                getString(R.string.easy_magnus_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.magnus_bedge), imageResId = R.drawable.magnus_bedge),
                    DropItem(name = getString(R.string.magnus_strap), imageResId = R.drawable.magnus_strap)
                ),
                getString(R.string.boss_quest) + getString(R.string.magnus_normal_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.hilla_image,
                getString(R.string.hilla_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_hilla_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.meso), imageResId = R.drawable.boss_meso)
                ),
                getString(R.string.boss_nothing),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.horntail_image,
                getString(R.string.horntail_name),
                getString(R.string.diff_easy),
                getString(R.string.easy_horntail_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.horntail_pendant), imageResId = R.drawable.horntail_pendant),
                    DropItem(name = getString(R.string.horntail_ring), imageResId = R.drawable.horntail_ring),
                    DropItem(name = getString(R.string.horntail_earring), imageResId = R.drawable.horntail_earling)
                ),
                getString(R.string.horntail_normal_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.banban_image,
                getString(R.string.banban_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_banban_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.meso), imageResId = R.drawable.boss_meso)
                ),
                getString(R.string.boss_nothing),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.bq_image,
                getString(R.string.bq_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_bq_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.meso), imageResId = R.drawable.boss_meso)
                ),
                getString(R.string.boss_nothing),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.pierre_image,
                getString(R.string.pierre_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_pierre_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.meso), imageResId = R.drawable.boss_meso)
                ),
                getString(R.string.boss_nothing),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.vellum_image,
                getString(R.string.vellum_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_vellum_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.meso), imageResId = R.drawable.boss_meso)
                ),
                getString(R.string.boss_nothing),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.horntail_image,
                getString(R.string.horntail_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_horntail_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.horntail_pendant), imageResId = R.drawable.horntail_pendant),
                    DropItem(name = getString(R.string.horntail_ring), imageResId = R.drawable.horntail_ring),
                    DropItem(name = getString(R.string.horntail_earring), imageResId = R.drawable.horntail_earling)
                ),
                getString(R.string.horntail_normal_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.leon_image,
                getString(R.string.leon_name),
                getString(R.string.diff_easy),
                getString(R.string.easy_leon_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.meso), imageResId = R.drawable.boss_meso)
                ),
                getString(R.string.boss_quest),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.akarum_image,
                getString(R.string.akarum_name),
                getString(R.string.diff_easy),
                getString(R.string.easy_akarum_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.akarum_pendant), imageResId = R.drawable.akarum_pendant),
                    DropItem(name = getString(R.string.akarum_stuff), imageResId = R.drawable.akarum_stuff)
                ),
                getString(R.string.akarum_easy_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.kaung_image,
                getString(R.string.kaung_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_kaung_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.meso), imageResId = R.drawable.boss_meso)
                ),
                getString(R.string.boss_quest),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.horntail_image,
                getString(R.string.horntail_name),
                getString(R.string.diff_normal),
                getString(R.string.chaos_horntail_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.horntail_pendant), imageResId = R.drawable.horntail_pendant),
                    DropItem(name = getString(R.string.horntail_ring), imageResId = R.drawable.horntail_ring),
                    DropItem(name = getString(R.string.horntail_earring), imageResId = R.drawable.horntail_earling)
                ),
                getString(R.string.horntail_normal_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.pink_bean_image,
                getString(R.string.pinkbean_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_pinkbean_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.pinkbean_belt), imageResId = R.drawable.pink_bean_belt),
                    DropItem(name = getString(R.string.pinkbean_cup), imageResId = R.drawable.pink_bean_cup),
                    DropItem(name = getString(R.string.pinkbean_mark), imageResId = R.drawable.pink_bean_mark)
                ),
                getString(R.string.boss_quest) + getString(R.string.pinkbean_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.leon_image,
                getString(R.string.leon_name),
                getString(R.string.diff_normal),
                getString(R.string.noraml_leon_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.meso), imageResId = R.drawable.boss_meso)
                ),
                getString(R.string.boss_quest),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.leon_image,
                getString(R.string.leon_name),
                getString(R.string.diff_hard),
                getString(R.string.hard_leon_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.leon_ring), imageResId = R.drawable.leon_ring),
                    DropItem(name = getString(R.string.leon_ring_plus), imageResId = R.drawable.leon_ring_plus)
                ),
                getString(R.string.boss_quest) + getString(R.string.leon_hard_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.akarum_image,
                getString(R.string.akarum_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_akarum_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.akarum_pendant), imageResId = R.drawable.akarum_pendant),
                    DropItem(name = getString(R.string.akarum_pendant_plus), imageResId = R.drawable.akarum_pendant_plus),
                    DropItem(name = getString(R.string.akarum_stuff), imageResId = R.drawable.akarum_stuff)
                ),
                getString(R.string.boss_quest) + getString(R.string.akarum_noraml_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.magnus_image,
                getString(R.string.magnus_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_magnus_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.magnus_bedge), imageResId = R.drawable.magnus_bedge),
                    DropItem(name = getString(R.string.magnus_strap), imageResId = R.drawable.magnus_strap)
                ),
                getString(R.string.boss_quest) + getString(R.string.magnus_normal_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),
            BossMonster(
                R.drawable.papulatus_image,
                getString(R.string.papulatus_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_papulatus_price),
                BossMonster.BossType.DAILY,
                listOf(
                    DropItem(name = getString(R.string.meso), imageResId = R.drawable.boss_meso)
                ),
                getString(R.string.boss_quest),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                imageResId = R.drawable.cygnus_image,
                name = getString(R.string.cygnus_name),
                diff = getString(R.string.diff_easy),
                price = getString(R.string.easy_cygnus_price),
                bossType = BossMonster.BossType.WEEKLY,
                dropItems = listOf(
                    DropItem(name = getString(R.string.meso), imageResId = R.drawable.boss_meso)
                ),
                bossDesc = getString(R.string.boss_nothing),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.hilla_image,
                getString(R.string.hilla_name),
                getString(R.string.diff_hard),
                getString(R.string.hard_hilla_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.hilla_earring), imageResId = R.drawable.hilla_earling)
                ),
                getString(R.string.hilla_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.pink_bean_image,
                getString(R.string.pinkbean_name),
                getString(R.string.diff_chaos),
                getString(R.string.chaos_pinkbean_price),
                BossMonster.BossType.WEEKLY,
                dropItems = listOf(
                    DropItem(name = getString(R.string.pinkbean_belt), imageResId = R.drawable.pink_bean_belt),
                    DropItem(name = getString(R.string.pinkbean_cup), imageResId = R.drawable.pink_bean_cup),
                    DropItem(name = getString(R.string.pinkbean_mark), imageResId = R.drawable.pink_bean_mark)
                ),
                getString(R.string.boss_quest) + getString(R.string.pinkbean_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.cygnus_image,
                getString(R.string.cygnus_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_cygnus_price),
                BossMonster.BossType.WEEKLY,
                dropItems = listOf(
                    DropItem(name = getString(R.string.meso), imageResId = R.drawable.boss_meso)
                ),
                getString(R.string.boss_quest) + getString(R.string.hilla_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.zakum_image,
                getString(R.string.zakum_name),
                getString(R.string.diff_chaos),
                getString(R.string.chaos_zakum_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.zakum_eye), imageResId = R.drawable.zakum_eye),
                    DropItem(name = getString(R.string.zakum_face), imageResId = R.drawable.zakum_face),
                    DropItem(name = getString(R.string.zakum_hat), imageResId = R.drawable.zakum_hat),
                    DropItem(name = getString(R.string.zakum_belt), imageResId = R.drawable.zakum_belt),
                    DropItem(name = getString(R.string.zakum_cloak), imageResId = R.drawable.zakum_cloak)
                ),
                getString(R.string.zakum_chaos_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.bq_image,
                getString(R.string.bq_name),
                getString(R.string.diff_chaos),
                getString(R.string.chaos_bq_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.bq_piece), imageResId = R.drawable.bq_piece)
                ),
                getString(R.string.bq_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.banban_image,
                getString(R.string.banban_name),
                getString(R.string.diff_chaos),
                getString(R.string.chaos_banban_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.banban_piece), imageResId = R.drawable.banban_piece)
                ),
                getString(R.string.banban_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.pierre_image,
                getString(R.string.pierre_name),
                getString(R.string.diff_chaos),
                getString(R.string.chaos_pierre_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.pierre_piece), imageResId = R.drawable.pierre_piece)
                ),
                getString(R.string.pierre_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.magnus_image,
                getString(R.string.magnus_name),
                getString(R.string.diff_hard),
                getString(R.string.hard_magnus_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.magnus_bedge), imageResId = R.drawable.magnus_bedge),
                    DropItem(name = getString(R.string.magnus_strap), imageResId = R.drawable.magnus_strap),
                    DropItem(name = getString(R.string.magnus_weapon), imageResId = R.drawable.magnus_weapon)
                ),
                getString(R.string.boss_quest) + getString(R.string.magnus_hard_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.vellum_image,
                getString(R.string.vellum_name),
                getString(R.string.diff_chaos),
                getString(R.string.chaos_vellum_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.vellum_piece), imageResId = R.drawable.vellum_piece)
                ),
                getString(R.string.vellum_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.papulatus_image,
                getString(R.string.papulatus_name),
                getString(R.string.diff_chaos),
                getString(R.string.chaos_papulatus_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.papulatus_mark), imageResId = R.drawable.papulatus_mark)
                ),
                getString(R.string.boss_quest) + getString(R.string.papulatus_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.lotus_image,
                getString(R.string.lotus_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_lotus_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.lotus_core), imageResId = R.drawable.lotus_core),
                    DropItem(name = getString(R.string.low_ring_box), imageResId = R.drawable.low_ring_box)
                ),
                getString(R.string.boss_quest) + getString(R.string.lotus_normal_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.damien_image,
                getString(R.string.damien_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_demien_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.damien_core), imageResId = R.drawable.damien_core),
                    DropItem(name = getString(R.string.damien_shield), imageResId = R.drawable.damien_shield),
                    DropItem(name = getString(R.string.low_ring_box), imageResId = R.drawable.low_ring_box)
                ),
                getString(R.string.boss_quest) + getString(R.string.damien_normal_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.gns_image,
                getString(R.string.gns_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_gas_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.gns_ring), imageResId = R.drawable.gns_ring),
                    DropItem(name = getString(R.string.low_ring_box), imageResId = R.drawable.low_ring_box)
                ),
                getString(R.string.boss_quest) + getString(R.string.gns_normal_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.lucid_image,
                getString(R.string.lucid_name),
                getString(R.string.diff_easy),
                getString(R.string.easy_lucid_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.low_ring_box), imageResId = R.drawable.low_ring_box)
                ),
                getString(R.string.lucid_easy_description),
                getString(R.string.lucid_easy_force),
                getString(R.string.lucid_easy_boost)
            ),

            BossMonster(
                R.drawable.will_image,
                getString(R.string.will_name),
                getString(R.string.diff_easy),
                getString(R.string.easy_will_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.low_ring_box), imageResId = R.drawable.low_ring_box)
                ),
                getString(R.string.will_easy_description),
                getString(R.string.will_easy_force),
                getString(R.string.will_easy_boost)
            ),

            BossMonster(
                R.drawable.lucid_image,
                getString(R.string.lucid_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_lucid_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.lucid_mark), imageResId = R.drawable.lucid_mark),
                    DropItem(name = getString(R.string.lucid_core), imageResId = R.drawable.lucid_core),
                    DropItem(name = getString(R.string.low_ring_box), imageResId = R.drawable.low_ring_box)
                ),
                getString(R.string.lucid_normal_description),
                getString(R.string.lucid_normal_force),
                getString(R.string.lucid_normal_boost)
            ),

            BossMonster(
                R.drawable.will_image,
                getString(R.string.will_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_will_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.will_mark), imageResId = R.drawable.lucid_mark),
                    DropItem(name = getString(R.string.will_core), imageResId = R.drawable.will_core),
                    DropItem(name = getString(R.string.low_ring_box), imageResId = R.drawable.low_ring_box)
                ),
                getString(R.string.will_normal_description),
                getString(R.string.will_normal_force),
                getString(R.string.will_normal_boost)
            ),

            BossMonster(
                R.drawable.dusk_image,
                getString(R.string.dusk_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_dusk_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.dusk_earring), imageResId = R.drawable.dusk_earring),
                    DropItem(name = getString(R.string.dusk_fire), imageResId = R.drawable.dusk_fire),
                    DropItem(name = getString(R.string.low_ring_box), imageResId = R.drawable.low_ring_box)
                ),
                getString(R.string.dusk_normal_description),
                getString(R.string.dusk_normal_force),
                getString(R.string.dusk_normal_boost)
            ),

            BossMonster(
                R.drawable.djunkel_image,
                getString(R.string.djunkel_name), getString(R.string.diff_normal),
                getString(R.string.normal_djunkel_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.dusk_earring), imageResId = R.drawable.dusk_earring),
                    DropItem(name = getString(R.string.dusk_fire), imageResId = R.drawable.dusk_fire),
                    DropItem(name = getString(R.string.low_ring_box), imageResId = R.drawable.low_ring_box)
                ),
                getString(R.string.djunkel_normal_description),
                getString(R.string.djunkel_normal_force),
                getString(R.string.djunkel_normal_boost)
            ),

            BossMonster(
                R.drawable.lotus_image,
                getString(R.string.lotus_name),
                getString(R.string.diff_hard),
                getString(R.string.hard_lotus_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.lotus_core), imageResId = R.drawable.lotus_core),
                    DropItem(name = getString(R.string.lotus_box), imageResId = R.drawable.lotus_box),
                    DropItem(name = getString(R.string.lotus_mark), imageResId = R.drawable.lotus_mark),
                    DropItem(name = getString(R.string.lotus_heart), imageResId = R.drawable.lotus_heart),
                    DropItem(name = getString(R.string.lotus_android), imageResId = R.drawable.lotus_android),
                    DropItem(name = getString(R.string.middle_ring_box), imageResId = R.drawable.middle_ring_box)
                ),
                getString(R.string.boss_quest) + getString(R.string.lotus_hard_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.damien_image,
                getString(R.string.damien_name),
                getString(R.string.diff_hard),
                getString(R.string.hard_demien_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.damien_core), imageResId = R.drawable.damien_core),
                    DropItem(name = getString(R.string.lotus_box), imageResId = R.drawable.lotus_box),
                    DropItem(name = getString(R.string.damien_face), imageResId = R.drawable.damien_face),
                    DropItem(name = getString(R.string.damien_shield), imageResId = R.drawable.damien_shield),
                    DropItem(name = getString(R.string.damien_android), imageResId = R.drawable.damien_android),
                    DropItem(name = getString(R.string.middle_ring_box), imageResId = R.drawable.middle_ring_box)
                ),
                getString(R.string.boss_quest) + getString(R.string.damien_hard_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.lucid_image,
                getString(R.string.lucid_name),
                getString(R.string.diff_hard),
                getString(R.string.hard_lucid_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.lucid_box), imageResId = R.drawable.lucid_box),
                    DropItem(name = getString(R.string.lucid_belt), imageResId = R.drawable.lucid_belt),
                    DropItem(name = getString(R.string.lucid_mark), imageResId = R.drawable.lucid_mark),
                    DropItem(name = getString(R.string.lucid_android), imageResId = R.drawable.lucid_android),
                    DropItem(name = getString(R.string.lucid_core), imageResId = R.drawable.lucid_core),
                    DropItem(name = getString(R.string.middle_ring_box), imageResId = R.drawable.middle_ring_box)
                ),
                getString(R.string.lucid_hard_description),
                getString(R.string.lucid_hard_force),
                getString(R.string.lucid_hard_boost)
            ),

            BossMonster(
                R.drawable.will_image,
                getString(R.string.will_name),
                getString(R.string.diff_hard),
                getString(R.string.hard_will_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.will_box), imageResId = R.drawable.lucid_box),
                    DropItem(name = getString(R.string.will_mark), imageResId = R.drawable.lucid_mark),
                    DropItem(name = getString(R.string.will_book), imageResId = R.drawable.will_book),
                    DropItem(name = getString(R.string.will_mirror), imageResId = R.drawable.will_mirror),
                    DropItem(name = getString(R.string.will_core), imageResId = R.drawable.will_core),
                    DropItem(name = getString(R.string.middle_ring_box), imageResId = R.drawable.middle_ring_box)
                ),
                getString(R.string.will_hard_description),
                getString(R.string.will_hard_force),
                getString(R.string.will_hard_boost)
            ),

            BossMonster(
                R.drawable.v_hilla_image,
                getString(R.string.v_hilla_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_v_hilla_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.seren_pendant), imageResId = R.drawable.seren_pendant),
                    DropItem(name = getString(R.string.lucid_box), imageResId = R.drawable.lucid_box),
                    DropItem(name = getString(R.string.middle_ring_box), imageResId = R.drawable.middle_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda)
                ),
                getString(R.string.verus_hilla_normal_description),
                getString(R.string.hilla_normal_force),
                getString(R.string.hilla_normal_boost)
            ),

            BossMonster(
                R.drawable.gns_image,
                getString(R.string.gns_name),
                getString(R.string.diff_chaos),
                getString(R.string.chaos_gas_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.gns_ring), imageResId = R.drawable.gns_ring),
                    DropItem(name = getString(R.string.high_ring_box), imageResId = R.drawable.high_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda)
                ),
                getString(R.string.boss_quest) + getString(R.string.gns_chaos_description),
                getString(R.string.force_noting),
                getString(R.string.force_boost_noting)
            ),

            BossMonster(
                R.drawable.dusk_image,
                getString(R.string.dusk_name),
                getString(R.string.diff_chaos),
                getString(R.string.chaos_dusk_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.lucid_box), imageResId = R.drawable.lucid_box),
                    DropItem(name = getString(R.string.dusk_earring), imageResId = R.drawable.dusk_earring),
                    DropItem(name = getString(R.string.dusk_ring), imageResId = R.drawable.dusk_ring),
                    DropItem(name = getString(R.string.dusk_fire), imageResId = R.drawable.dusk_fire),
                    DropItem(name = getString(R.string.high_ring_box), imageResId = R.drawable.high_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda)
                ),
                getString(R.string.dusk_chaos_description),
                getString(R.string.dusk_hard_force),
                getString(R.string.dusk_hard_boost)
            ),

            BossMonster(
                R.drawable.djunkel_image,
                getString(R.string.djunkel_name),
                getString(R.string.diff_hard),
                getString(R.string.hard_djunkel_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.lucid_box), imageResId = R.drawable.lucid_box),
                    DropItem(name = getString(R.string.dusk_earring), imageResId = R.drawable.dusk_earring),
                    DropItem(name = getString(R.string.djunkel_earring_plus), imageResId = R.drawable.djunkel_earring_plus),
                    DropItem(name = getString(R.string.djunkel_fire), imageResId = R.drawable.dusk_fire),
                    DropItem(name = getString(R.string.high_ring_box), imageResId = R.drawable.high_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda)
                ),
                getString(R.string.djunkel_hard_description),
                getString(R.string.djunkel_hard_force),
                getString(R.string.djunkel_hard_boost)
            ),

            BossMonster(
                R.drawable.v_hilla_image,
                getString(R.string.v_hilla_name),
                getString(R.string.diff_hard),
                getString(R.string.hard_v_hilla_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.seren_pendant), imageResId = R.drawable.seren_pendant),
                    DropItem(name = getString(R.string.hilla_pendant), imageResId = R.drawable.hilla_pendant),
                    DropItem(name = getString(R.string.lucid_box), imageResId = R.drawable.lucid_box),
                    DropItem(name = getString(R.string.hilla_strength), imageResId = R.drawable.hilla_strength),
                    DropItem(name = getString(R.string.high_ring_box), imageResId = R.drawable.high_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda)
                ),
                getString(R.string.verus_hilla_normal_description),
                getString(R.string.hilla_hard_force),
                getString(R.string.hilla_hard_boost)
            ),


            BossMonster(
                R.drawable.serene_image,
                getString(R.string.serene_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_serene_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.seren_pendant), imageResId = R.drawable.seren_pendant),
                    DropItem(name = getString(R.string.high_ring_box), imageResId = R.drawable.high_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda)
                ),
                getString(R.string.seren_normal_description),
                getString(R.string.seren_normal_force),
                getString(R.string.seren_normal_boost)
            ),

            BossMonster(
                R.drawable.serene_image,
                getString(R.string.serene_name),
                getString(R.string.diff_hard),
                getString(R.string.hard_serene_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.seren_pendant), imageResId = R.drawable.seren_pendant),
                    DropItem(name = getString(R.string.mittra_box), imageResId = R.drawable.mittra_box),
                    DropItem(name = getString(R.string.mittra_core_jam), imageResId = R.drawable.mittra_core_jam),
                    DropItem(name = getString(R.string.best_ring_box), imageResId = R.drawable.best_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda),
                    DropItem(name = getString(R.string.middle_sol_elda), imageResId = R.drawable.middle_sol_elda)
                ),
                getString(R.string.seren_hard_description),
                getString(R.string.seren_hard_force),
                getString(R.string.seren_hard_boost)
            ),
            BossMonster(
                R.drawable.serene_image,
                getString(R.string.serene_name),
                getString(R.string.diff_expert),
                getString(R.string.expert_serene_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.gravity_module), imageResId = R.drawable.gravity_module),
                    DropItem(name = getString(R.string.seren_pendant), imageResId = R.drawable.seren_pendant),
                    DropItem(name = getString(R.string.mittra_box), imageResId = R.drawable.mittra_box),
                    DropItem(name = getString(R.string.mittra_core_jam), imageResId = R.drawable.mittra_core_jam),
                    DropItem(name = getString(R.string.best_ring_box), imageResId = R.drawable.best_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda),
                    DropItem(name = getString(R.string.high_sol_elda), imageResId = R.drawable.high_sol_elda)
                ),
                getString(R.string.seren_extream_description),
                getString(R.string.seren_extream_force),
                getString(R.string.seren_extream_boost)
            ),

            BossMonster(
                R.drawable.kalos_image,
                getString(R.string.kalos_name),
                getString(R.string.diff_easy),
                getString(R.string.easy_kalos_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.kalos_piece), imageResId = R.drawable.kalos_piece),
                    DropItem(name = getString(R.string.best_ring_box), imageResId = R.drawable.best_ring_box),
                    DropItem(name = getString(R.string.middle_sol_elda), imageResId = R.drawable.middle_sol_elda),
                    DropItem(name = getString(R.string.ring_upgrade), imageResId = R.drawable.kalos_ring_upgrade),
                ),
                getString(R.string.kalos_easy_description),
                getString(R.string.kalos_easy_force),
                getString(R.string.kalos_easy_boost)
            ),

            BossMonster(
                R.drawable.kalos_image,
                getString(R.string.kalos_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_kalos_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.kalos_box), imageResId = R.drawable.kalos_box),
                    DropItem(name = getString(R.string.kalos_android), imageResId = R.drawable.kalos_android),
                    DropItem(name = getString(R.string.best_ring_box), imageResId = R.drawable.best_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda),
                    DropItem(name = getString(R.string.middle_sol_elda), imageResId = R.drawable.middle_sol_elda),
                    DropItem(name = getString(R.string.ring_upgrade), imageResId = R.drawable.kalos_ring_upgrade),
                ),
                getString(R.string.kalos_normal_description),
                getString(R.string.kalos_normal_force),
                getString(R.string.kalos_normal_boost)
            ),

            BossMonster(
                R.drawable.kalos_image,
                getString(R.string.kalos_name),
                getString(R.string.diff_chaos),
                getString(R.string.chaos_kalos_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.kalos_box), imageResId = R.drawable.kalos_box),
                    DropItem(name = getString(R.string.kalos_android), imageResId = R.drawable.kalos_android),
                    DropItem(name = getString(R.string.best_ring_box), imageResId = R.drawable.best_ring_box),
                    DropItem(name = getString(R.string.middle_sol_elda), imageResId = R.drawable.middle_sol_elda),
                    DropItem(name = getString(R.string.ring_upgrade), imageResId = R.drawable.kalos_ring_upgrade),
                ),
                getString(R.string.kalos_chaos_description),
                getString(R.string.kalos_chaos_force),
                getString(R.string.kalos_chaos_boost)
            ),

            BossMonster(
                R.drawable.kalos_image,
                getString(R.string.kalos_name),
                getString(R.string.diff_expert),
                getString(R.string.expert_kalos_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.kalos_upgrade), imageResId = R.drawable.kalos_upgrade),
                    DropItem(name = getString(R.string.kalos_box), imageResId = R.drawable.kalos_box),
                    DropItem(name = getString(R.string.kalos_android), imageResId = R.drawable.kalos_android),
                    DropItem(name = getString(R.string.best_ring_box), imageResId = R.drawable.best_ring_box),
                    DropItem(name = getString(R.string.middle_sol_elda), imageResId = R.drawable.middle_sol_elda),
                    DropItem(name = getString(R.string.high_sol_elda), imageResId = R.drawable.high_sol_elda),
                    DropItem(name = getString(R.string.ring_upgrade), imageResId = R.drawable.kalos_ring_upgrade),
                ),
                getString(R.string.kalos_expert_description),
                getString(R.string.kalos_extream_force),
                getString(R.string.kalos_extream_boost)
            ),

            BossMonster(
                R.drawable.kaling_image,
                getString(R.string.kaling_name),
                getString(R.string.diff_easy),
                getString(R.string.easy_kaling_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.kalling_piece), imageResId = R.drawable.kalling_piece),
                    DropItem(name = getString(R.string.best_ring_box), imageResId = R.drawable.best_ring_box),
                    DropItem(name = getString(R.string.middle_sol_elda), imageResId = R.drawable.middle_sol_elda),
                    DropItem(name = getString(R.string.ring_upgrade), imageResId = R.drawable.kalos_ring_upgrade),
                ),
                getString(R.string.kaling_easy_description),
                getString(R.string.kaling_easy_force),
                getString(R.string.kaling_easy_boost)
            ),

            BossMonster(
                R.drawable.kaling_image,
                getString(R.string.kaling_name),
                getString(R.string.diff_normal),
                getString(R.string.normal_kaling_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.kalling_box), imageResId = R.drawable.kaling_box),
                    DropItem(name = getString(R.string.kalling_droid), imageResId = R.drawable.kalling_droid),
                    DropItem(name = getString(R.string.best_ring_box), imageResId = R.drawable.best_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda),
                    DropItem(name = getString(R.string.middle_sol_elda), imageResId = R.drawable.middle_sol_elda),
                    DropItem(name = getString(R.string.ring_upgrade), imageResId = R.drawable.kalos_ring_upgrade),
                ),
                getString(R.string.kaling_normal_description),
                getString(R.string.kaling_normal_force),
                getString(R.string.kaling_normal_boost)
            ),


            BossMonster(
                R.drawable.kaling_image,
                getString(R.string.kaling_name),
                getString(R.string.diff_hard),
                getString(R.string.hard_kaling_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.kalling_box), imageResId = R.drawable.kaling_box),
                    DropItem(name = getString(R.string.kalling_droid), imageResId = R.drawable.kalling_droid),
                    DropItem(name = getString(R.string.best_ring_box), imageResId = R.drawable.best_ring_box),
                    DropItem(name = getString(R.string.high_sol_elda), imageResId = R.drawable.high_sol_elda),
                    DropItem(name = getString(R.string.ring_upgrade), imageResId = R.drawable.kalos_ring_upgrade),
                ),
                getString(R.string.kaling_hard_description),
                getString(R.string.kaling_hard_force),
                getString(R.string.kaling_hard_boost)
            ),

            BossMonster(
                R.drawable.kaling_image,
                getString(R.string.kaling_name),
                getString(R.string.diff_expert),
                getString(R.string.expert_kaling_price),
                BossMonster.BossType.WEEKLY,
                listOf(
                    DropItem(name = getString(R.string.kalling_upgrade), imageResId = R.drawable.kalling_upgrade),
                    DropItem(name = getString(R.string.kalling_box), imageResId = R.drawable.kaling_box),
                    DropItem(name = getString(R.string.kalling_droid), imageResId = R.drawable.kalling_droid),
                    DropItem(name = getString(R.string.best_ring_box), imageResId = R.drawable.best_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda),
                    DropItem(name = getString(R.string.middle_sol_elda), imageResId = R.drawable.middle_sol_elda),
                    DropItem(name = getString(R.string.high_sol_elda), imageResId = R.drawable.high_sol_elda),
                    DropItem(name = getString(R.string.ring_upgrade), imageResId = R.drawable.kalos_ring_upgrade),
                ),
                getString(R.string.kaling_expert_desciption),
                getString(R.string.kaling_extream_force),
                getString(R.string.kaling_extream_boost)
            ),


            BossMonster(
                R.drawable.bm_image,
                getString(R.string.bm_name),
                getString(R.string.diff_hard),
                getString(R.string.hard_bm_price),
                BossMonster.BossType.MONTHLY,
                listOf(
                    DropItem(name = getString(R.string.lucid_box), imageResId = R.drawable.lucid_box),
                    DropItem(name = getString(R.string.genesis_box), imageResId = R.drawable.genesis_box),
                    DropItem(name = getString(R.string.bm_bedge), imageResId = R.drawable.bm_bedge),
                    DropItem(name = getString(R.string.high_ring_box), imageResId = R.drawable.high_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda),
                    DropItem(name = getString(R.string.middle_sol_elda), imageResId = R.drawable.middle_sol_elda)
                ),
                getString(R.string.dark_load_hard_description),
                getString(R.string.bm_hard_force),
                getString(R.string.bm_hard_boost)
            ),

            BossMonster(
                R.drawable.bm_image,
                getString(R.string.bm_name),
                getString(R.string.diff_expert),
                getString(R.string.expert_bm_price),
                BossMonster.BossType.MONTHLY,
                listOf(
                    DropItem(name = getString(R.string.nightmare_piece), imageResId = R.drawable.nightmare_piece),
                    DropItem(name = getString(R.string.lucid_box), imageResId = R.drawable.lucid_box),
                    DropItem(name = getString(R.string.bm_bedge), imageResId = R.drawable.bm_bedge),
                    DropItem(name = getString(R.string.high_ring_box), imageResId = R.drawable.high_ring_box),
                    DropItem(name = getString(R.string.low_sol_elda), imageResId = R.drawable.low_sol_elda),
                    DropItem(name = getString(R.string.high_sol_elda), imageResId = R.drawable.high_sol_elda)
                ),
                getString(R.string.dark_load_extream_description),
                getString(R.string.bm_extream_force),
                getString(R.string.bm_extream_boost)
            )
        )
    }

    private fun initViews() {
        // Set up toolbar with back button
        setSupportActionBar(binding.toolbarWithBackButton.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbarWithBackButton.toolbar.setNavigationOnClickListener {
            // Navigate back to MainActivity
            onBackPressed()
        }
        binding.searchView.setIconifiedByDefault(false)
    }
}