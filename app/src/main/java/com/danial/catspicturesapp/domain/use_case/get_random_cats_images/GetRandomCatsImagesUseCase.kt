package com.danial.catspicturesapp.domain.use_case.get_random_cats_images

import com.danial.catspicturesapp.domain.model.CatImage
import com.danial.catspicturesapp.domain.repository.CatsImageRepository
import com.danial.catspicturesapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRandomCatsImagesUseCase @Inject constructor(private val repository: CatsImageRepository) {

    operator fun invoke(limit: Int): Flow<Resource<List<CatImage>>> = flow {
        try {
            emit(Resource.Loading(true))
            val catsImages = repository.getRandomCatsImages(limit)
            emit(Resource.Success(catsImages))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }finally {
            emit(Resource.Loading(false))
        }
    }
}