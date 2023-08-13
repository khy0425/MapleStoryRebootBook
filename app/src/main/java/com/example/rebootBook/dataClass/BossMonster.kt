package com.example.rebootBook.dataClass

import android.os.Parcel
import android.os.Parcelable

data class BossMonster(
    val imageResId: Int,
    val name: String,
    val diff: String,
    val price: String,
    val bossType: BossType,
    val dropItems: List<DropItem>,
    val bossDesc: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        BossType.valueOf(parcel.readString() ?: "DAILY"),
        parcel.createTypedArrayList(DropItem.CREATOR) ?: emptyList(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResId)
        parcel.writeString(name)
        parcel.writeString(diff)
        parcel.writeString(price)
        parcel.writeString(bossType.name)
        parcel.writeTypedList(dropItems)
        parcel.writeString(bossDesc)
    }

    override fun describeContents(): Int {
        return 0
    }

    enum class BossType { DAILY, WEEKLY, MONTHLY }

    companion object CREATOR : Parcelable.Creator<BossMonster> {
        override fun createFromParcel(parcel: Parcel): BossMonster {
            return BossMonster(parcel)
        }

        override fun newArray(size: Int): Array<BossMonster?> {
            return arrayOfNulls(size)
        }
    }
}