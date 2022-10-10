package com.danial.catspicturesapp.presentation.cats_Images

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danial.catspicturesapp.domain.model.CatImage
import com.danial.catspicturesapp.domain.use_case.get_random_cats_images.GetRandomCatsImagesUseCase
import com.danial.catspicturesapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsImagesViewModel @Inject constructor(private val getRandomCatsImagesUseCase: GetRandomCatsImagesUseCase) :
    ViewModel() {


    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    private val _catsImages = mutableStateOf<List<CatImage>>(emptyList())
    val catsImages: State<List<CatImage>> = _catsImages

    private val _showLoading = mutableStateOf(false)
    val showLoading: State<Boolean> = _showLoading


    init {
        getRandomCatsImages(10)
    }


    private fun getRandomCatsImages(limit: Int) {
        viewModelScope.launch {
            getRandomCatsImagesUseCase(limit).collect { result ->

                when (result) {
                    is Resource.Error -> _errorMessage.value = result.message
                    is Resource.Loading -> _showLoading.value = result.isLoading
                    is Resource.Success -> _catsImages.value = result.data!!
                }
            }
        }

    }

    fun toggleFavourite(id: String) {
        val catsImages = _catsImages.value.toMutableList()
        val itemIndex = catsImages.indexOfFirst { it.id == id }
        val item = catsImages[itemIndex]
        catsImages[itemIndex] = item.copy(isFavour = !item.isFavour)
        _catsImages.value = catsImages

    }




}