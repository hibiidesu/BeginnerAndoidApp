package com.dicoding.beginnerandoidapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// TODO: Put artist on a different data class 
// TODO: Put tracks into a music data class 
@Parcelize
data class Albums(
    val name: String,
    val description: String,
    val photo: String,
    val tracks: String,
    val artistName: String,
    val artistPhoto: String,
    val artistDesc: String
): Parcelable
