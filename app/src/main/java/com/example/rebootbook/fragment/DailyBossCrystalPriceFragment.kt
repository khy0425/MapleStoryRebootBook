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
//class DailyBossCrystalPriceFragment : Fragment(), BossCrystalPriceFilter {
//
//    // RecyclerView를 선언하세요
//    private lateinit var recyclerView: RecyclerView
//
//    var originalList: List<com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster> = listOf()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.daily_boss_crystal_price, container, false)
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
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.zakum_image, getString(R.string.zakum_name), getString(R.string.diff_easy) ,getString(R.string.easy_zakum_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.zakum_image, getString(R.string.zakum_name), getString(R.string.diff_normal), getString(R.string.normal_zakum_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.papulatus_image, getString(R.string.papulatus_name),  getString(R.string.diff_easy),getString(R.string.easy_papulatus_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.magnus_image, getString(R.string.magnus_name), getString(R.string.diff_easy), getString(R.string.easy_magnus_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.hilla_image, getString(R.string.hilla_name), getString(R.string.diff_normal),  getString(R.string.normal_hilla_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.horntail_image, getString(R.string.horntail_name),getString(R.string.diff_easy),  getString(R.string.easy_horntail_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.banban_image, getString(R.string.banban_name), getString(R.string.diff_normal), getString(R.string.normal_banban_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.bq_image, getString(R.string.bq_name), getString(R.string.diff_normal),  getString(R.string.normal_bq_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.pierre_image, getString(R.string.pierre_name), getString(R.string.diff_normal), getString(R.string.normal_pierre_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.vellum_image, getString(R.string.vellum_name), getString(R.string.diff_normal), getString(R.string.normal_vellum_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.horntail_image, getString(R.string.horntail_name), getString(R.string.diff_normal), getString(R.string.normal_horntail_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.leon_image, getString(R.string.leon_name), getString(R.string.diff_easy), getString(R.string.easy_leon_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.akarum_image, getString(R.string.akarum_name), getString(R.string.diff_easy), getString(R.string.easy_akarum_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.kaung_image, getString(R.string.kaung_name), getString(R.string.diff_normal), getString(R.string.normal_kaung_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.horntail_image, getString(R.string.horntail_name), getString(R.string.diff_normal), getString(R.string.chaos_horntail_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.pink_bean_image, getString(R.string.pinkbean_name), getString(R.string.diff_normal), getString(R.string.normal_pinkbean_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.leon_image, getString(R.string.leon_name), getString(R.string.diff_normal), getString(R.string.noraml_leon_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.leon_image, getString(R.string.leon_name), getString(R.string.diff_hard), getString(R.string.hard_leon_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.akarum_image, getString(R.string.akarum_name), getString(R.string.diff_normal), getString(R.string.normal_akarum_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.magnus_image, getString(R.string.magnus_name), getString(R.string.diff_normal), getString(R.string.normal_magnus_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.papulatus_image, getString(R.string.papulatus_name), getString(R.string.diff_normal), getString(R.string.normal_papulatus_price))
//        )
//
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
//        fun newInstance(allBossList: List<com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster>): DailyBossCrystalPriceFragment {
//            val fragment = DailyBossCrystalPriceFragment()
//            fragment.originalList = allBossList
//            return fragment
//        }
//    }
//}
