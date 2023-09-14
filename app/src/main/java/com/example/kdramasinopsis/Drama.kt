package com.example.kdramasinopsis

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Drama(
    val title: String,
    val cast: String,
    val episodes: String,
    val network: String,
    val sinopsis: String,
    val photo: Int,
) : Parcelable
