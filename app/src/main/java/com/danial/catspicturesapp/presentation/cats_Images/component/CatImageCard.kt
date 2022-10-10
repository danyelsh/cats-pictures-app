package com.danial.catspicturesapp.presentation.cats_Images.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.danial.catspicturesapp.domain.model.CatImage

@Composable
fun CatImageCard(
    catImage: CatImage,
    onCardClick: () -> Unit,
    onFavourClick: () -> Unit,
    isFavorable: Boolean
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp,
            )
            .fillMaxWidth()
            .clickable(onClick = onCardClick),
        elevation = 8.dp,
    ) {
        Column {
            AsyncImage(
                model = catImage.imageUrl,
                contentDescription = catImage.imageUrl,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(225.dp),
                contentScale = ContentScale.Crop,
            )

            if(isFavorable){
                Image(
                    modifier = Modifier
                        .size(32.dp)
                        .align(CenterHorizontally)
                        .clickable { onFavourClick() },
                    colorFilter = ColorFilter.tint(color = Color.Red),
                    imageVector = if (catImage.isFavour) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "",
                )
            }

        }
    }
}