package com.app.navigation.feature.list.dummy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataItem(
    val id: String,
    val content: String,
    val details: String
) : Parcelable