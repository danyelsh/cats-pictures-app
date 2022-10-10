package com.danial.catspicturesapp.domain.repository

import com.danial.catspicturesapp.domain.model.CatImage
import kotlinx.coroutines.flow.Flow

interface CatsImageRepository {
    suspend fun getRandomCatsImages(limit: Int): List<CatImage>
}