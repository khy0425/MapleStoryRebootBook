package com.leaf.rebootBook.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.style.TextAppearanceSpan
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.leaf.rebootBook.BuildConfig
import com.leaf.rebootBook.EventCrawlerTask
import com.leaf.rebootBook.R
import com.leaf.rebootBook.adapter.EventAdapter
import com.leaf.rebootBook.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var eventCrawlerTask: EventCrawlerTask
    private lateinit var eventAdapter: EventAdapter
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        eventAdapter = EventAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = eventAdapter
        }

        eventCrawlerTask = EventCrawlerTask()
        eventCrawlerTask.execute { eventItems ->
            eventAdapter.submitList(eventItems)
            Log.d("MainActivity", "EventAdapter item count: ${eventAdapter.itemCount}")
        }

        swipeRefreshLayout = binding.swipeRefreshLayout

        refreshEvents()
        swipeRefreshLayout.setOnRefreshListener {
            refreshEvents()
        }

        binding.navigationView.itemIconTintList = null

        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            for (i in 0 until binding.navigationView.menu.size()) {
                val item = binding.navigationView.menu.getItem(i)
                val title = SpannableString(item.title)
                if (item.itemId == menuItem.itemId) {
                    title.setSpan(
//                        TextAppearanceSpan(this, R.style.NavigationItemTextSelected),
                        TextAppearanceSpan(this, R.style.NavigationItemText),
                        0,
                        title.length,
                        0
                    )
                } else {
                    title.setSpan(
                        TextAppearanceSpan(this, R.style.NavigationItemText),
                        0,
                        title.length,
                        0
                    )
                }
                item.title = title
            }
            when (menuItem.itemId) {
                R.id.nav_item1 -> {
                    val intent = Intent(this, UnionHuntingActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_item2 -> {
                    val intent = Intent(this, UnionEffectActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_item3 -> {
                    // TODO: 직업별 스킬 코어 우선 순위
                }

                R.id.nav_item4 -> {
                    val intent = Intent(this, CalculatorActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_item5 -> {
                    // TODO: 무기 추옵 정리
                    val intent = Intent(this, WeaponOptionActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_item6 -> {
                    // TODO: 주간 퀘스트 헬퍼
                    val intent = Intent(this, QuestHelperActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_item7 -> {
                    val intent = Intent(this, BossCrystalPriceActivity::class.java)
                    startActivity(intent)
                    // TODO: 보스 결정석 메소 정리
                }

                R.id.nav_item8 -> {
                    // TODO: 주요 레시피 정리
                    val intent = Intent(this, ItemRecipeActivity::class.java)
                    startActivity(intent)
                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // nav_3버튼을 숨김
        binding.navigationView.menu.findItem(R.id.nav_item3).isVisible = false

        // Initialize MobileAds with the Ad ID from BuildConfig
        MobileAds.initialize(this) {
            val adRequest = AdRequest.Builder().build()
            binding.adView.loadAd(adRequest)
            binding.adView.adListener = object : AdListener() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.e("AdView", adError.message)
                }
            }
        }

    }

    private fun refreshEvents() {
        eventCrawlerTask.cancel()
        eventCrawlerTask = EventCrawlerTask()
        eventCrawlerTask.execute { eventItems ->
            eventAdapter.submitList(eventItems)
            swipeRefreshLayout.isRefreshing = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        eventCrawlerTask.cancel()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
