package com.example.rebootBook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rebootBook.adapter.HuntingLocationAdapter
import com.example.rebootBook.viewModel.HuntingViewModel
import com.example.rebootBook.viewModel.HuntingViewModelFactory
import com.google.android.material.tabs.TabLayout

class UnionHuntingActivity : AppCompatActivity() {

    private lateinit var viewModel: HuntingViewModel
    private lateinit var adapter: HuntingLocationAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hunting)

        initViews()
    }

    private fun initViews() {
        // ViewModel 초기화
        viewModel = ViewModelProvider(this, HuntingViewModelFactory(applicationContext))[HuntingViewModel::class.java]

        // RecyclerView 설정
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = HuntingLocationAdapter()
        recyclerView.adapter = adapter

        // 탭 레이아웃 설정
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val tabZero = tabLayout.newTab().setText("0 ~ 4000 유니온 뉴비")
        val tabBase = tabLayout.newTab().setText("4000~8000 유니온 고인물")
        tabLayout.addTab(tabZero)
        tabLayout.addTab(tabBase)

        // 탭 클릭 이벤트 처리
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // 선택한 탭에 따라서 RecyclerView에 보여줄 데이터를 변경한다.
                if (tab.position == 0) {
                    adapter.submitList(viewModel.getUnionZeroHuntingLocations(this@UnionHuntingActivity))
                }
                if (tab.position == 1) {
                    adapter.submitList(viewModel.getUnionBaseHuntingLocations(this@UnionHuntingActivity))
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}
