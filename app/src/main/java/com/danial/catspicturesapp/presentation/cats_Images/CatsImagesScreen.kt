package com.danial.catspicturesapp.presentation.cats_Images

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danial.catspicturesapp.presentation.cats_Images.component.CatImageCard
import com.danial.catspicturesapp.presentation.cats_Images.component.TopAppBar
import com.ehsanmsz.mszprogressindicator.progressindicator.LineSpinFadeLoaderProgressIndicator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun CatsImagesScreen(
    viewModel: CatsImagesViewModel,
    onFavouriteIconClick: () -> Unit
) {

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope: CoroutineScope = rememberCoroutineScope()




    Scaffold(scaffoldState = scaffoldState, modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(onNavigateToFavouritesClick = {
            onFavouriteIconClick()
        })

        viewModel.errorMessage.value?.let {

            LaunchedEffect("key1") {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(viewModel.errorMessage.value!!)
                }
            }


        }

    }) {
        Surface(Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
                items(viewModel.catsImages.value) { catImage ->
                    CatImageCard(
                        catImage = catImage,
                        onCardClick = {},
                        onFavourClick = { viewModel.toggleFavourite(catImage.id) },
                        isFavorable = true
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

