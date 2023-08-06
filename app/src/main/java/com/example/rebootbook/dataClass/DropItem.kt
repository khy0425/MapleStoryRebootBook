package com.example.rebootBook.dataClass

import android.os.Parcel
import android.os.Parcelable

data class DropItem(
    val imageResId: Int,
    val name: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResId)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DropItem> {
        override fun createFromParcel(parcel: Parcel): DropItem {
            return DropItem(parcel)
        }

        override fun newArray(size: Int): Array<DropItem?> {
            return arrayOfNulls(size)
        }
    }
}
