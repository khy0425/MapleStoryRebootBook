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
//import com.example.rebootbook.interfaces.BossCrystalPriceFilter
//
//class WeeklyBossCrystalPriceFragment : Fragment(), BossCrystalPriceFilter {
//
//    private lateinit var recyclerView: RecyclerView
//    var originalList: List<com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster> = listOf()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.weekly_boss_crystal_price, container, false)
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
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.cygnus_image,getString(R.string.cygnus_name), getString(R.string.diff_easy), getString(R.string.easy_cygnus_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.hilla_image,getString(R.string.hilla_name), getString(R.string.diff_hard), getString(R.string.hard_hilla_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.pink_bean_image,getString(R.string.pinkbean_name), getString(R.string.diff_chaos), getString(R.string.chaos_pinkbean_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.cygnus_image,getString(R.string.cygnus_name), getString(R.string.diff_normal), getString(R.string.normal_cygnus_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.zakum_image,getString(R.string.zakum_name), getString(R.string.diff_chaos), getString(R.string.chaos_zakum_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.bq_image,getString(R.string.bq_name), getString(R.string.diff_chaos), getString(R.string.chaos_bq_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.banban_image,getString(R.string.banban_name), getString(R.string.diff_chaos), getString(R.string.chaos_banban_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.pierre_image,getString(R.string.pierre_name), getString(R.string.diff_chaos), getString(R.string.chaos_pierre_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.magnus_image,getString(R.string.magnus_name), getString(R.string.diff_hard),getString(R.string.hard_magnus_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.vellum_image,getString(R.string.vellum_name), getString(R.string.diff_chaos),getString(R.string.chaos_vellum_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.papulatus_image,getString(R.string.papulatus_name), getString(R.string.diff_chaos),getString(R.string.chaos_papulatus_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.lotus_image,getString(R.string.lotus_name), getString(R.string.diff_normal), getString(R.string.normal_lotus_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.damien_image,getString(R.string.damien_name), getString(R.string.diff_normal), getString(R.string.normal_demien_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.gns_image,getString(R.string.gns_name), getString(R.string.diff_normal), getString(R.string.normal_gas_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.lucid_image,getString(R.string.lucid_name), getString(R.string.diff_easy), getString(R.string.easy_lucid_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.will_image,getString(R.string.will_name), getString(R.string.diff_easy), getString(R.string.easy_will_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.lucid_image,getString(R.string.lucid_name), getString(R.string.diff_normal), getString(R.string.normal_lucid_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.will_image,getString(R.string.will_name), getString(R.string.diff_normal), getString(R.string.normal_will_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.dusk_image,getString(R.string.dusk_name), getString(R.string.diff_normal), getString(R.string.normal_dusk_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.djunkel_image,getString(R.string.djunkel_name), getString(R.string.diff_normal), getString(R.string.normal_djunkel_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.damien_image,getString(R.string.damien_name), getString(R.string.diff_hard), getString(R.string.hard_demien_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.lotus_image,getString(R.string.lotus_name), getString(R.string.diff_hard), getString(R.string.hard_lotus_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.lucid_image,getString(R.string.lucid_name), getString(R.string.diff_hard), getString(R.string.hard_lucid_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.will_image,getString(R.string.will_name), getString(R.string.diff_hard), getString(R.string.hard_will_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.v_hilla_image,getString(R.string.v_hilla_name), getString(R.string.diff_normal), getString(R.string.normal_v_hilla_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.gns_image,getString(R.string.gns_name), getString(R.string.diff_chaos), getString(R.string.chaos_gas_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.dusk_image,getString(R.string.dusk_name), getString(R.string.diff_hard), getString(R.string.chaos_dusk_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.djunkel_image,getString(R.string.djunkel_name), getString(R.string.diff_hard), getString(R.string.hard_djunkel_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.v_hilla_image,getString(R.string.v_hilla_name), getString(R.string.diff_hard), getString(R.string.hard_v_hilla_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.serene_image,getString(R.string.serene_name), getString(R.string.diff_normal), getString(R.string.normal_serene_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.serene_image,getString(R.string.serene_name), getString(R.string.diff_hard), getString(R.string.hard_serene_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.kalos_image,getString(R.string.kalos_name), getString(R.string.diff_chaos), getString(R.string.chaos_kalos_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.kaling_image,getString(R.string.kaling_name), getString(R.string.diff_normal), getString(R.string.normal_kaling_price)),
//            com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster(R.drawable.serene_image,getString(R.string.serene_name), getString(R.string.diff_expert), getString(R.string.expert_serene_price))
//        )
//
//        // 데이터를 어댑터에 전달하고 UI를 갱신합니다.
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
//        fun newInstance(allBossList: List<com.example.rebootBook.dataClass.com.example.rebootBook.dataClass.BossMonster>): WeeklyBossCrystalPriceFragment {
//            val fragment = WeeklyBossCrystalPriceFragment()
//            fragment.originalList = allBossList
//            return fragment
//        }
//    }
//
//}