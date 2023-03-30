package com.example.rebootBook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.rebootBook.adapter.BossCrystalPricePagerAdapter
import com.example.rebootBook.interfaces.BossCrystalPriceFilter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class BossCrystalPriceActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_boss_crystal_price)

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        val searchView: SearchView = findViewById(R.id.searchView)

        val pagerAdapter = BossCrystalPricePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "일간"
                1 -> tab.text = "주간"
                2 -> tab.text = "월간"
            }
        }.attach()

        searchView.setOnQueryTextListener(this)
        initViews()
    }

    private fun initViews() {
        // Set up toolbar with back button
        val toolbar = findViewById<Toolbar>(R.id.toolbar_with_back_button)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener {
            // Navigate back to MainActivity
            onBackPressed()
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        // 쿼리를 제출했을 때 동작합니다. 이 경우 필요하지 않으므로 아무것도 하지 않습니다.
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        // 쿼리가 변경될 때마다 동작합니다.
        val adapter = viewPager.adapter as BossCrystalPricePagerAdapter

        // 모든 탭에 있는 프래그먼트에 대해 필터를 적용합니다.
        for (i in 0 until adapter.itemCount) {
            val currentFragment = adapter.getFragment(i)

            if (currentFragment is BossCrystalPriceFilter) {
                currentFragment.applyFilter(newText ?: "")
            }
        }
        return true
    }
}
