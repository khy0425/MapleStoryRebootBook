package com.example.rebootBook

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.rebootBook.adapter.EventAdapter
import com.example.rebootBook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var eventCrawlerTask: EventCrawlerTask
    private lateinit var eventAdapter: EventAdapter
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

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
            when (menuItem.itemId) {
                R.id.nav_item1 -> {
                    val intent = Intent(this, UnionHuntingActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_item2 -> {

                }
                R.id.nav_item3 -> {

                }

                R.id.nav_item4 -> {
                    val intent = Intent(this, CalculatorActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_item5 -> {

                }

                R.id.nav_item6 -> {

                }

                R.id.nav_item7 -> {

                }

                R.id.nav_item8 -> {

                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
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
