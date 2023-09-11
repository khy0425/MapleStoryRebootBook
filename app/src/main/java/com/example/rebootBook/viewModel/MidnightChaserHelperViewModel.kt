package com.example.rebootBook.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rebootBook.R
import com.example.rebootBook.dataClass.MidnightChaser

class MidnightChaserViewModel : ViewModel() {

    val bigGridItems = MutableLiveData<List<List<MidnightChaser>>>().apply {
        val initialSmallGrid = listOf(
            MidnightChaser(R.drawable.small_mirror, R.drawable.big_mirror, MidnightChaser.State.UNSELECTED),
            MidnightChaser(R.drawable.small_box, R.drawable.big_box, MidnightChaser.State.UNSELECTED),
            MidnightChaser(R.drawable.small_bed, R.drawable.big_bed, MidnightChaser.State.UNSELECTED),
            MidnightChaser(R.drawable.small_angle, R.drawable.big_angle, MidnightChaser.State.UNSELECTED),
            MidnightChaser(R.drawable.small_clock, R.drawable.big_clock, MidnightChaser.State.UNSELECTED),
            MidnightChaser(R.drawable.small_closet, R.drawable.big_closet, MidnightChaser.State.UNSELECTED),
            MidnightChaser(R.drawable.small_music_box, R.drawable.big_music_box ,MidnightChaser.State.UNSELECTED),
            MidnightChaser(R.drawable.small_piano, R.drawable.big_piano, MidnightChaser.State.UNSELECTED),
            MidnightChaser(R.drawable.small_sofa, R.drawable.big_sofa, MidnightChaser.State.UNSELECTED),
        )
        value = List(9) { initialSmallGrid }
    }

    fun onChaserClicked(bigIndex: Int, smallIndex: Int) {
        val updatedBigGridItems = bigGridItems.value?.mapIndexed { i, smallGrid ->
            if (i == bigIndex) {
                smallGrid.mapIndexed { j, chaser ->
                    if (j == smallIndex) {
                        chaser.copy(state = MidnightChaser.State.SELECTED)
                    } else {
                        chaser.copy(state = MidnightChaser.State.UNAVAILABLE)
                    }
                }
            } else {
                smallGrid.map {
                    if (it.smallResId == smallGrid[smallIndex].smallResId) {
                        it.copy(state = MidnightChaser.State.UNAVAILABLE)
                    } else {
                        it
                    }
                }
            }
        }
        bigGridItems.value = updatedBigGridItems
    }

    fun onResetButtonClick() {
        bigGridItems.value = bigGridItems.value?.map { smallGrid ->
            smallGrid.map {
                it.copy(state = MidnightChaser.State.UNSELECTED)
            }
        }
    }
}