package com.danial.catspicturesapp.presentation.favourites

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danial.catspicturesapp.presentation.cats_Images.CatsImagesViewModel
import com.danial.catspicturesapp.presentation.cats_Images.component.CatImageCard
import com.ehsanmsz.mszprogressindicator.progressindicator.LineSpinFadeLoaderProgressIndicator

@Composable
fun FavouritesScreen(viewModel: CatsImagesViewModel) {


    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        androidx.compose.material.TopAppBar(
            modifier = Modifier.fillMaxWidth()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Favourites")

            }


        }
    }) {
        Surface(Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                items(viewModel.catsImages.value.filter { it.isFavour }) { catImage ->
                    CatImageCard(
                        catImage = catImage,
                        onCardClick = {},
                        onFavourClick = { },
                        isFavorable = false
                    )
                }
            }
            if (viewModel.showLoading.value) {
                Box(contentAlignment = Alignment.Center) {
                    LineSpinFadeLoaderProgressIndicator(animationDuration = 1000)
                }
            }

        }


    }


}