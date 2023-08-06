//package com.example.rebootBook.fragment
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.RecyclerView
//import com.example.rebootBook.R
//import com.example.rebootBook.adapter.BossMonsterAdapter
//import com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster
//import com.example.rebootBook.interfaces.BossCrystalPriceFilter
//
//class MonthlyBossCrystalPriceFragment :Fragment(), BossCrystalPriceFilter{
//
//    private lateinit var recyclerView: RecyclerView
//    var originalList: List<com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster> = listOf()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.monthly_boss_crystal_price, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        recyclerView = view.findViewById(R.id.recyclerView)
//
//        // BossMonsterAdapter를 초기화합니다.
//        val bossMonsterAdapter = BossMonsterAdapter()
//
//        // RecyclerView에 BossMonsterAdapter를 설정합니다.
//        recyclerView.adapter = bossMonsterAdapter
//
//        // 데이터를 로드하고 UI를 갱신하는 코드를 여기에 작성하세요.
//        originalList = listOf(
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.bm_image, getString(R.string.bm_name), getString(R.string.diff_hard), getString(R.string.hard_bm_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.bm_image, getString(R.string.bm_name), getString(R.string.diff_expert), getString(R.string.expert_bm_price))
//        )
//        bossMonsterAdapter.submitList(originalList)
//    }
//
//    override fun applyFilter(query: String) {
//        // originalList가 초기화되었는지 확인
//        if (originalList != null) {
//            // 1. 검색 쿼리를 기반으로 몬스터 이름, 난이도, 가격에서 필터링된 목록을 생성합니다.
//            val filteredList = originalList!!.filter { bossMonster ->
//                bossMonster.name.contains(query, ignoreCase = true) ||
//                        bossMonster.diff.contains(query, ignoreCase = true) ||
//                        bossMonster.price.contains(query)
//            }
//
//            // 2. 필터링된 결과를 사용하여 UI를 갱신합니다. 이 예제에서는 RecyclerView를 사용한다고 가정합니다.
//            val recyclerViewAdapter = recyclerView.adapter as BossMonsterAdapter
//            recyclerViewAdapter.submitList(filteredList)
//        }
//    }
//
//
//    companion object {
//        fun newInstance(allBossList: List<com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster>): MonthlyBossCrystalPriceFragment {
//            val fragment = MonthlyBossCrystalPriceFragment()
//            fragment.originalList = allBossList
//            return fragment
//        }
//    }
//}