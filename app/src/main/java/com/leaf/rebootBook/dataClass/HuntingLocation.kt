package com.leaf.rebootBook.dataClass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HuntingLocation(
    val name: String,
    val description: String
) : Parcelable
