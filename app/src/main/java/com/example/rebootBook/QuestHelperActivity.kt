package com.example.rebootBook

import com.example.rebootBook.fragment.MidnightChaserHelperFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.rebootBook.databinding.ActivityQuestHelperBinding
import com.example.rebootBook.fragment.MutoRecipeFragment
import com.google.android.material.tabs.TabLayoutMediator

class QuestHelperActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestHelperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestHelperBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewPager(binding.viewPager)

        binding.tabs.let { tabLayout ->
            binding.viewPager.let { viewPager ->
                TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                    tab.text = when (position) {
                        0 -> "무토 레시피"
                        1 -> "미드나잇 체이서 헬퍼"
                        else -> throw IllegalArgumentException("Invalid position: $position")
                    }
                }.attach()
            }
        }
        initViews()
    }

    private fun setupViewPager(viewPager: ViewPager2) {
        viewPager.adapter = QuestHelperPagerAdapter(this)
    }

    private fun initViews() {
        // Set up toolbar with back button
        setSupportActionBar(binding.toolbarWithBackButton.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbarWithBackButton.toolbar.setNavigationOnClickListener {
            // Navigate back to MainActivity
            onBackPressed()
        }
    }
}

class QuestHelperPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MutoRecipeFragment()
            1 -> MidnightChaserHelperFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}
