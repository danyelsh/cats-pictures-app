package com.danial.catspicturesapp.data.mapper

import com.danial.catspicturesapp.data.remote.dto.CatImageDto
import com.danial.catspicturesapp.domain.model.CatImage


    fun CatImageDto.toCatImage(): CatImage = CatImage(id = id, imageUrl = url)
