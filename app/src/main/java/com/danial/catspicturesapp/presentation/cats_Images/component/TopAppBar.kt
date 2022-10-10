package com.danial.catspicturesapp.presentation.cats_Images.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.Navigator

@Composable
fun TopAppBar(onNavigateToFavouritesClick: () -> Unit) {

    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Random Cats Images")
            Card(modifier = Modifier
                .align(Alignment.CenterVertically)
                .clip(shape = RectangleShape)
                .clickable { onNavigateToFavouritesClick() }
            ) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(4.dp),
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Navigate to Favourites",
                    colorFilter = ColorFilter.tint(color = Color.Red),
                )
            }

        }


    }

}