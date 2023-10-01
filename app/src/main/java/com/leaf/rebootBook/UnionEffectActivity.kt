package com.leaf.rebootBook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.leaf.rebootBook.databinding.ActivityUnionEffectBinding
import com.leaf.rebootBook.fragment.LinkEffectFragment
import com.leaf.rebootBook.fragment.UnionEffectFragment
import com.google.android.material.tabs.TabLayoutMediator

class UnionEffectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUnionEffectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnionEffectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = 2

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> LinkEffectFragment()
                    else -> UnionEffectFragment()
                }
            }
        }

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "링크"
                else -> "유니온"
            }
        }.attach()
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
}
