package com.danial.catspicturesapp.data.repository

import com.danial.catspicturesapp.data.mapper.toCatImage
import com.danial.catspicturesapp.data.remote.CatsApi
import com.danial.catspicturesapp.domain.model.CatImage
import com.danial.catspicturesapp.domain.repository.CatsImageRepository
import javax.inject.Inject

class CatsImageRepositoryImpl @Inject constructor(
    private val catsApi: CatsApi
) :
    CatsImageRepository {
    override suspend fun getRandomCatsImages(limit: Int): List<CatImage> {
        return catsApi.getRandomCatsImages(limit).map { it.toCatImage() }
    }
}