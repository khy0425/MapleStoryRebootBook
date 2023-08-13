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
                name = "10 ~ 30 엘로딘 위습",
                description = "\n" + context.getString(R.string.union_hunting_zero_2_description)
            ),
            HuntingLocation(
                name = "30 ~ 50 테마던전 골드비치 등",
                description = "\n" + context.getString(R.string.union_hunting_zero_3_description)
            ),
            HuntingLocation(
                name = "50 ~ 60 슬리피우드 조용한 or 축축한 습지 or 하늘계단",
                description = "\n" + context.getString(R.string.union_hunting_zero_4_description)
            ),
            HuntingLocation(
                name = "60 ~ 70 갱도4",
                description = "\n" + context.getString(R.string.union_hunting_zero_5_description)
            ),
            HuntingLocation(
                name = "70 ~ 80 사헬지대 or 잠자는 사막 or 버섯언덕 입구",
                description = "\n" + context.getString(R.string.union_hunting_zero_6_description)
            ),
            HuntingLocation(
                name = "80 ~ 90 관계자 외 출입금지",
                description = "\n" + context.getString(R.string.union_hunting_zero_7_description)
            ),
            HuntingLocation(
                name = "90 ~ 100 하늘둥지2 or 3",
                description = "\n" + context.getString(R.string.union_hunting_zero_8_description)
            ),
            HuntingLocation(
                name = "100 ~ 120 삐뚤어진 시간 or 잊혀진 회랑",
                description = "\n" + context.getString(R.string.union_hunting_zero_9_description)
            ),
            HuntingLocation(
                name = "120 ~ 140 폐광 4 or 시련의동굴2 or 시련의동굴 3 or 아랫마을 현상금 퀘스트",
                description = "\n" + context.getString(R.string.union_hunting_zero_10_description)
            ),
            HuntingLocation(
                name = "140 ~ 160 커닝타워 2층 카페 4 or 5 or ",
                description = "\n" + context.getString(R.string.union_hunting_zero_11_description)
            ),
            HuntingLocation(
                name = "160 ~ 185 복도 H01 ~ 03",
                description = "\n" + context.getString(R.string.union_hunting_zero_12_description)
            ),
            HuntingLocation(
                name = "185 ~ 200 여우골짜기",
                description = "\n" + context.getString(R.string.union_hunting_zero_13_description)
            ),
            HuntingLocation(
                name = "190 ~ 200 헤이븐, 버려진 야영지 스토리 or 기계무덤 언덕 1, 3, 4",
                description = "\n" + context.getString(R.string.union_hunting_zero_14_description)
            ),
        )

        _unionBaseHuntingLocations.value = listOf(
            HuntingLocation(
                name = "0 ~ ?(있는 경우) 직업별 튜토리얼 퀘스트",
                description = "\n" + context.getString(R.string.union_hunting_base_1_description)
            ),
            HuntingLocation(
                name = "10 ~ 30 테마던전 엘로딘 내부 깊어지는숲1 or 새비지터미널 들개들의싸움터",
                description ="\n" + context.getString(R.string.union_hunting_base_2_description)
            ),
            HuntingLocation(
                name = "30 ~ 50 테마던전 엘리넬 → 리에나 → 골드비치 도입부",
                description = "\n" + context.getString(R.string.union_hunting_base_4_description)
            ),
            HuntingLocation(
                name = "50 ~ 65 오르비스 하늘계단1 or 조용한 습지",
                description = "\n" + context.getString(R.string.union_hunting_base_5_description)
            ),
            HuntingLocation(
                name = "65 ~ 70 깊은 갱도 ",
                description = "\n" + context.getString(R.string.union_hunting_base_6_description)
            ),
            HuntingLocation(
                name = "70 ~ 80 버섯언덕 입구",
                description = "\n" + context.getString(R.string.union_hunting_base_7_description)
            ),
            HuntingLocation(
                name = "80 ~ 90 관계자 외 출입금지",
                description = "\n" + context.getString(R.string.union_hunting_base_8_description)
            ),
            HuntingLocation(
                name = "90 ~ 100 하늘 둥지 입구",
                description = "\n" + context.getString(R.string.union_hunting_base_9_description)
            ),
            HuntingLocation(
                name = "100 ~ 120 꼬여버린 시간",
                description = "\n" + context.getString(R.string.union_hunting_base_10_description)
            ),
            HuntingLocation(
                name = "120 ~ 140 블루 와이번의 둥지",
                description = "\n" + context.getString(R.string.union_hunting_base_11_description)
            ),
            HuntingLocation(
                name = "140 ~ 155 추억의 길 3",
                description = "\n" + context.getString(R.string.union_hunting_base_12_description)
            ),
            HuntingLocation(
                name = "150 ~ 160 탐사 현장 서쪽 길1",
                description = "\n" + context.getString(R.string.union_hunting_base_13_description)
            ),
            HuntingLocation(
                name = "160 ~ 180 기사의 전당1 or 복도 202",
                description = "\n" + context.getString(R.string.union_hunting_base_13_description)
            ),
            HuntingLocation(
                name = "180 ~ 200 여우골짜기 테마던전 or 여우나무 중턱 3",
                description = "\n" + context.getString(R.string.union_hunting_base_14_description)
            ),
            HuntingLocation(
                name = "190 ~ 200 헤이븐, 버려진 야영지 퀘스트",
                description = "\n" + context.getString(R.string.union_hunting_base_15_description)
            )
        )
    }
}
