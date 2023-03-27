package com.example.rebootBook.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rebootBook.R
import com.example.rebootBook.dataClass.HuntingLocation

class HuntingViewModel(context: Context) : ViewModel() {

    private val _unionZeroHuntingLocations = MutableLiveData<List<HuntingLocation>>()
    val unionZeroHuntingLocations: LiveData<List<HuntingLocation>>
        get() = _unionZeroHuntingLocations

    private val _unionBaseHuntingLocations = MutableLiveData<List<HuntingLocation>>()
    val unionBaseHuntingLocations: LiveData<List<HuntingLocation>>
        get() = _unionBaseHuntingLocations

    init {
        _unionZeroHuntingLocations.value = listOf(
            HuntingLocation(
                name = "0 ~ ?(있는 경우) 직업별 튜토리얼 퀘스트",
                description = "\n" + context.getString(R.string.union_hunting_zero_1_description)
            ),
            HuntingLocation(
                name = "10 ~ 30 헤네시스 골렘의 사원 or 엘리니아 솟아오른 나무",
                description = "\n" + context.getString(R.string.union_hunting_zero_2_description)
            ),
            HuntingLocation(
                name = "30 ~ 60 테마던전 골드비치",
                description = "\n" + context.getString(R.string.union_hunting_zero_3_description)
            ),
            HuntingLocation(
                name = "60 ~ 70 슬리피우드 조용한 or 축축한 습지",
                description = "\n" + context.getString(R.string.union_hunting_zero_4_description)
            ),
            HuntingLocation(
                name = "70 ~ 80 오르비스 하늘계단1",
                description = "\n" + context.getString(R.string.union_hunting_zero_5_description)
            ),
            HuntingLocation(
                name = "80 ~ 90 에델슈타인 갱도 경비로봇",
                description = "\n" + context.getString(R.string.union_hunting_zero_6_description)
            ),
            HuntingLocation(
                name = "90 ~ 100 마가티아 사헬지대2 or 관계자 외 출입금지",
                description = "\n" + context.getString(R.string.union_hunting_zero_7_description)
            ),
            HuntingLocation(
                name = "100 ~ 110 리프레 미나르숲 동쪽 경계 or 서쪽 경계 or 가파른 언덕",
                description = "\n" + context.getString(R.string.union_hunting_zero_8_description)
            ),
            HuntingLocation(
                name = "100 ~ 120 루디브리엄 장난감공장<1공정> 3구역",
                description = "\n" + context.getString(R.string.union_hunting_zero_9_description)
            ),
            HuntingLocation(
                name = "120 ~ 130 엘나스 날카로운절별3 예티와페페",
                description = "\n" + context.getString(R.string.union_hunting_zero_10_description)
            ),
            HuntingLocation(
                name = "130 ~ 140 엘나스 폐광4 or 시련의동굴1 or 아랫마을 월묘",
                description = "\n" + context.getString(R.string.union_hunting_zero_11_description)
            ),
            HuntingLocation(
                name = "140 ~ 150 커닝타워 2층<2> ~ <3>",
                description = "\n" + context.getString(R.string.union_hunting_zero_12_description)
            ),
            HuntingLocation(
                name = "150 ~ 170 커닝타워 2층 <5>",
                description = "\n" + context.getString(R.string.union_hunting_zero_13_description)
            ),
            HuntingLocation(
                name = "170 ~ 180 크리티아스 빙점의 숲 1 ~ 2 or 작열의 숲 2",
                description = "\n" + context.getString(R.string.union_hunting_zero_14_description)
            ),
            HuntingLocation(
                name = "180 ~ 190 크리티아스 암흑의 숲 2 or 그란디스 새비지터미널 위험한 파이트클럽 3",
                description = "\n" + context.getString(R.string.union_hunting_zero_15_description)
            ),
            HuntingLocation(
                name = "190 ~ 199 황혼의 페리온 적막한 바위길 or 풍화된 바위지대, 버려진 발굴지역 4",
                description = "\n" + context.getString(R.string.union_hunting_zero_16_description)
            ),
            HuntingLocation(
                name = "199 ~ ☆200☆ 헤이븐 퀘스트",
                description = "\n" + context.getString(R.string.union_hunting_zero_17_description)
            )
        )

        _unionBaseHuntingLocations.value = listOf(
            HuntingLocation(
                name = "0 ~ ?(있는 경우) 직업별 튜토리얼 퀘스트",
                description = "\n" + context.getString(R.string.union_hunting_base_1_description)
            ),
            HuntingLocation(
                name = "10 ~ 20 엘리니아 솟아오른나무",
                description = "\n" + context.getString(R.string.union_hunting_base_2_description)
            ),
            HuntingLocation(
                name = "20 ~ 30 테마던전 엘로딘 내부 깊어지는숲1 or 새비지터미널 들개들의싸움터",
                description ="\n" + context.getString(R.string.union_hunting_base_3_description)
            ),
            HuntingLocation(
                name = "30 ~ 60 테마던전 엘리넬 → 리에나 → 골드비치 도입부",
                description = "\n" + context.getString(R.string.union_hunting_base_4_description)
            ),
            HuntingLocation(
                name = "60~80 오르비스 하늘계단1 ",
                description = "\n" + context.getString(R.string.union_hunting_base_5_description)
            ),
            HuntingLocation(
                name = "80~85 마가티아 사헬지대 스콜피언 or 잠자는사막 ",
                description = "\n" + context.getString(R.string.union_hunting_base_6_description)
            ),
            HuntingLocation(
                name = "85~95 마가티아 알카드노연구소 관출",
                description = "\n" + context.getString(R.string.union_hunting_base_7_description)
            ),
            HuntingLocation(
                name = "95~110 리프레 미나르숲 동쪽경계, 미나르숲 서쪽경계, 미나르숲 가파른언덕",
                description = "\n" + context.getString(R.string.union_hunting_base_8_description)
            ),
            HuntingLocation(
                name = "110~130 엘나스 날카로운절벽3",
                description = "\n" + context.getString(R.string.union_hunting_base_9_description)
            ),
            HuntingLocation(
                name = "130~150 폐광4,시련의동굴1,아랫마을 → 커닝타워2층 <2>~<3> ",
                description = "\n" + context.getString(R.string.union_hunting_base_10_description)
            ),
            HuntingLocation(
                name = "150~160 커닝타워2층 <5>",
                description = "\n" + context.getString(R.string.union_hunting_base_11_description)
            ),
            HuntingLocation(
                name = "160~175 시간의신전 미래의문 제1연무장 (스타포스120)",
                description = "\n" + context.getString(R.string.union_hunting_base_12_description)
            ),
            HuntingLocation(
                name = "175~185 크리티아스 암흑의숲 2 or 그란디스 새비지터미널 위험한파이트클럽3",
                description = "\n" + context.getString(R.string.union_hunting_base_13_description)
            ),
            HuntingLocation(
                name = "185~199 황혼의페리온 적막한바위길, 풍화된바위지대, 버려진발굴지역4, 거친황야, 전사들의결전지",
                description = "\n" + context.getString(R.string.union_hunting_base_14_description)
            ),
            HuntingLocation(
                name = "199~200 ☆킹갓☆ 헤이븐 퀘스트",
                description = "\n" + context.getString(R.string.union_hunting_base_15_description)
            )
        )
    }
}
