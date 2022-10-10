package com.danial.catspicturesapp.data.remote

import com.danial.catspicturesapp.data.remote.dto.CatImageDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CatsApi {

    @GET("images/search")
    suspend fun getRandomCatsImages(@Query("limit") limit: Int): List<CatImageDto>
}