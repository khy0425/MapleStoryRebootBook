package com.leaf.rebootBook.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leaf.rebootBook.R
import com.leaf.rebootBook.dataClass.HuntingLocation

class HuntingViewModel(context: Context) : ViewModel() {

    private val _unionZeroHuntingLocations = MutableLiveData<List<HuntingLocation>>()
    val unionZeroHuntingLocations: LiveData<List<HuntingLocation>>
        get() = _unionZeroHuntingLocations

    private val _unionBaseHuntingLocations = MutableLiveData<List<HuntingLocation>>()
    val unionBaseHuntingLocations: LiveData<List<HuntingLocation>>
        get() = _unionBaseHuntingLocations

    private val _unionBurningLocations = MutableLiveData<List<HuntingLocation>>()
    val unionBurningLocations : LiveData<List<HuntingLocation>>
        get() = _unionBurningLocations

    init {
        _unionZeroHuntingLocations.value = listOf(
            HuntingLocation(
                name = "0 ~ ?(있는 경우) 직업별 튜토리얼 퀘스트",
                description = "\n" + context.getString(R.string.union_hunting_zero_1_description)
            ),
            HuntingLocation(
                name = "10 ~ 30 들개들의 싸움터 1, 2",
                description = "\n" + context.getString(R.string.union_hunting_zero_2_description)
            ),
            HuntingLocation(
                name = "30 ~ 45 테마던전 리에나 해협 등",
                description = "\n" + context.getString(R.string.union_hunting_zero_3_description)
            ),
            HuntingLocation(
                name = "45 ~ 53 와일드보어의 땅",
                description = "\n" + context.getString(R.string.union_hunting_zero_4_description)
            ),
            HuntingLocation(
                name = "53 ~ 58 조용한 습지 or 동굴 낭떠러지",
                description = "\n" + context.getString(R.string.union_hunting_zero_5_description)
            ),
            HuntingLocation(
                name = "58 ~ 65 하늘계단1 or 구름공원4 or 구름공원6",
                description = "\n" + context.getString(R.string.union_hunting_zero_6_description)
            ),
            HuntingLocation(
                name = "65 ~ 73 갱도 2 or 1,3",
                description = "\n" + context.getString(R.string.union_hunting_zero_7_description)
            ),
            HuntingLocation(
                name = "73 ~ 85 사헬지대 2 or 흰 바위 사막",
                description = "\n" + context.getString(R.string.union_hunting_zero_8_description)
            ),
            HuntingLocation(
                name = "85 ~ 95 마가티아 B-1, B-3, C-1, C-2",
                description = "\n" + context.getString(R.string.union_hunting_zero_9_description)
            ),
            HuntingLocation(
                name = "95 ~ 105 하늘 둥지2 (★5)",
                description = "\n" + context.getString(R.string.union_hunting_zero_10_description)
            ),
            HuntingLocation(
                name = "105 ~ 120 꼬여버린 시간 (★27)",
                description = "\n" + context.getString(R.string.union_hunting_zero_11_description)
            ),
            HuntingLocation(
                name = "120 ~ 130 날카로운절벽4",
                description = "\n" + context.getString(R.string.union_hunting_zero_12_description)
            ),
            HuntingLocation(
                name = "130 ~ 141 야생곰의 영토1",
                description = "\n" + context.getString(R.string.union_hunting_zero_13_description)
            ),
            HuntingLocation(
                name = "140 ~ 150 남겨진 용의 둥지 or 커닝 타워 (★70, ★80)",
                description = "\n" + context.getString(R.string.union_hunting_zero_14_description)
            ),
            HuntingLocation(
                name = "150 ~ 170 암석거인 콜로서스 (★80)",
                description = "\n" + context.getString(R.string.union_hunting_zero_15_description)
            ),
            HuntingLocation(
                name = "170 ~ 175 크리티아스 작열의 숲 1",
                description = "\n" + context.getString(R.string.union_hunting_zero_16_description)
            ),
            HuntingLocation(
                name = "175 ~ 185 기사의 전당2",
                description = "\n" + context.getString(R.string.union_hunting_zero_16_description)
            ),
            HuntingLocation(
                name = "185 ~ 192 황혼의 페리온 쓸쓸한 바위길",
                description = "\n" + context.getString(R.string.union_hunting_zero_17_description)
            ),
            HuntingLocation(
                name = "192 ~ 194 황혼의 페리온 고열의 땅",
                description = "\n" + context.getString(R.string.union_hunting_zero_18_description)
            ),
            HuntingLocation(
                name = "194 ~ 200 황혼의 페리온 버려진 발굴지역 3",
                description = "\n" + context.getString(R.string.union_hunting_zero_19_description)
            ),
            HuntingLocation(
                name = "196 ~ 200 황혼의 페리온 발굴 중단지역 (★160)",
                description = "\n" + context.getString(R.string.union_hunting_zero_20_description)
            ),
        )

        _unionBaseHuntingLocations.value = listOf(
            HuntingLocation(
                name = "0 ~ ?(있는 경우) 직업별 튜토리얼 퀘스트",
                description = "\n" + context.getString(R.string.union_hunting_base_1_description)
            ),
            HuntingLocation(
                name = "10 ~ 30 들개들의 싸움터",
                description ="\n" + context.getString(R.string.union_hunting_base_2_description)
            ),
            HuntingLocation(
                name = "30 ~ 45 테마던전 리에나 해협 등",
                description = "\n" + context.getString(R.string.union_hunting_base_3_description)
            ),
            HuntingLocation(
                name = "45 ~ 53 와일드보어의 땅",
                description = "\n" + context.getString(R.string.union_hunting_base_4_description)
            ),
            HuntingLocation(
                name = "53 ~ 58 조용한 습지 or 동굴 낭떠러지",
                description = "\n" + context.getString(R.string.union_hunting_base_5_description)
            ),
            HuntingLocation(
                name = "58 ~ 65 하늘계단1 or 구름공원4 or 구름공원6",
                description = "\n" + context.getString(R.string.union_hunting_zero_6_description)
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
                name = "80 ~ 85 사헬지대 2 or 흰 바위 사막",
                description = "\n" + context.getString(R.string.union_hunting_base_8_description)
            ),
            HuntingLocation(
                name = "85 ~ 95 마가티아 B-1, B-3, C-1, C-2",
                description = "\n" + context.getString(R.string.union_hunting_zero_9_description)
            ),
            HuntingLocation(
                name = "90 ~ 100 하늘 둥지 입구",
                description = "\n" + context.getString(R.string.union_hunting_base_9_description)
            ),
            HuntingLocation(
                name = "100 ~ 120 꼬여버린 시간 or 잊시길 (★25, 27)",
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
                name = "180 ~ 185 기사의 전당 2",
                description = "\n" + context.getString(R.string.union_hunting_zero_16_description)
            ),
            HuntingLocation(
                name = "185 ~ 192 황혼의 페리온 쓸쓸한 바위길",
                description = "\n" + context.getString(R.string.union_hunting_zero_17_description)
            ),
            HuntingLocation(
                name = "192 ~ 194 황혼의 페리온 고열의 땅",
                description = "\n" + context.getString(R.string.union_hunting_zero_18_description)
            ),
            HuntingLocation(
                name = "194 ~ 200 황혼의 페리온 버려진 발굴지역 3",
                description = "\n" + context.getString(R.string.union_hunting_zero_19_description)
            ),
            HuntingLocation(
                name = "196 ~ 200 황혼의 페리온 발굴 중단지역 (★160)",
                description = "\n" + context.getString(R.string.union_hunting_zero_20_description)
            ),
        )

        _unionBurningLocations.value = listOf(
            HuntingLocation(
                name = "0 ~ ?(있는 경우) 직업별 튜토리얼 퀘스트",
                description = "\n" + context.getString(R.string.union_hunting_zero_1_description)
            ),
            HuntingLocation(
                name = "10 ~ 30 들개들의 싸움터 1, 2",
                description = "\n" + context.getString(R.string.union_hunting_zero_2_description)
            ),
            HuntingLocation(
                name = "30 ~ 45 테마던전 리에나 해협 등",
                description = "\n" + context.getString(R.string.union_hunting_zero_3_description)
            ),
            HuntingLocation(
                name = "45 ~ 53 와일드보어의 땅",
                description = "\n" + context.getString(R.string.union_hunting_zero_4_description)
            ),
            HuntingLocation(
                name = "53 ~ 58 조용한 습지 or 동굴 낭떠러지",
                description = "\n" + context.getString(R.string.union_hunting_zero_5_description)
            ),
            HuntingLocation(
                name = "58 ~ 65 하늘계단1 or 구름공원4 or 구름공원6",
                description = "\n" + context.getString(R.string.union_hunting_zero_6_description)
            ),
            HuntingLocation(
                name = "65 ~ 73 갱도 2 or 1,3",
                description = "\n" + context.getString(R.string.union_hunting_zero_7_description)
            ),
            HuntingLocation(
                name = "73 ~ 85 사헬지대 2 or 흰 바위 사막",
                description = "\n" + context.getString(R.string.union_hunting_zero_8_description)
            ),
            HuntingLocation(
                name = "85 ~ 95 마가티아 B-1, B-3, C-1, C-2",
                description = "\n" + context.getString(R.string.union_hunting_zero_9_description)
            ),
            HuntingLocation(
                name = "95 ~ 105 하늘 둥지2 (★5)",
                description = "\n" + context.getString(R.string.union_hunting_zero_10_description)
            ),
            HuntingLocation(
                name = "105 ~ 120 꼬여버린 시간 (★27)",
                description = "\n" + context.getString(R.string.union_hunting_zero_11_description)
            ),
            HuntingLocation(
                name = "120 ~ 130 날카로운절벽4",
                description = "\n" + context.getString(R.string.union_hunting_zero_12_description)
            ),
            HuntingLocation(
                name = "130 ~ 141 야생곰의 영토1",
                description = "\n" + context.getString(R.string.union_hunting_zero_13_description)
            ),
            HuntingLocation(
                name = "140 ~ 150 남겨진 용의 둥지 (★70)",
                description = "\n" + context.getString(R.string.union_hunting_zero_14_description)
            ),
            HuntingLocation(
                name = "150 ~ 170 암석거인 콜로서스 (★80)",
                description = "\n" + context.getString(R.string.union_hunting_zero_15_description)
            ),
            HuntingLocation(
                name = "170 ~ 175 크리티아스 작열의 숲 1",
                description = "\n" + context.getString(R.string.union_hunting_zero_16_description)
            ),
            HuntingLocation(
                name = "175 ~ 185 기사의 전당2",
                description = "\n" + context.getString(R.string.union_hunting_zero_16_description)
            ),
            HuntingLocation(
                name = "185 ~ 192 황혼의 페리온 쓸쓸한 바위길",
                description = "\n" + context.getString(R.string.union_hunting_zero_17_description)
            ),
            HuntingLocation(
                name = "192 ~ 194 황혼의 페리온 고열의 땅",
                description = "\n" + context.getString(R.string.union_hunting_zero_18_description)
            ),
            HuntingLocation(
                name = "194 ~ 196 황혼의 페리온 버려진 발굴지역 3",
                description = "\n" + context.getString(R.string.union_hunting_zero_19_description)
            ),
            HuntingLocation(
                name = "196 ~ 200 황혼의 페리온 발굴 중단지역 (★160)",
                description = "\n" + context.getString(R.string.union_hunting_zero_20_description)
            ),
        )

    }
}
