package com.danial.catspicturesapp.data.remote.dto

import com.squareup.moshi.Json

data class CatImageDto(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "url") val url: String,
    @field:Json(name = "width") val width: Int,
    @field:Json(name = "height") val height: Int,

    )
