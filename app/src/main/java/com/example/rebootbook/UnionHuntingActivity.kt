package com.example.rebootBook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.rebootBook.fragment.UnionBaseHuntingFragment
import com.example.rebootBook.fragment.UnionZeroHuntingFragment
import com.example.rebootBook.viewModel.HuntingViewModel
import com.example.rebootBook.viewModel.HuntingViewModelFactory
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class UnionHuntingActivity : AppCompatActivity() {

    private lateinit var viewModel: HuntingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hunting)

        initViews()
    }

    private fun initViews() {
        // ViewModel 초기화
        viewModel = ViewModelProvider(this, HuntingViewModelFactory(applicationContext))[HuntingViewModel::class.java]

        // Set up toolbar with back button
        val toolbar = findViewById<Toolbar>(R.id.toolbar_with_back_button)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener {
            // Navigate back to MainActivity
            onBackPressed()
        }

        // ViewPager2 설정
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        viewPager.adapter = UnionHuntingPagerAdapter(this)

        // 탭 레이아웃 설정
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "0 ~ 4000 유니온 뉴비"
                1 -> tab.text = "4000~8000 유니온 고인물"
            }
        }.attach()
    }
}

class UnionHuntingPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> UnionZeroHuntingFragment()
            1 -> UnionBaseHuntingFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}
