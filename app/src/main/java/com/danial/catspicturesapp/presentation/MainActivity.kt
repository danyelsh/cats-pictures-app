package com.danial.catspicturesapp.presentation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danial.catspicturesapp.presentation.cats_Images.CatsImagesScreen
import com.danial.catspicturesapp.presentation.cats_Images.CatsImagesViewModel
import com.danial.catspicturesapp.presentation.favourites.FavouritesScreen
import com.danial.catspicturesapp.ui.theme.CatsPicturesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatsPicturesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    val viewModel: CatsImagesViewModel = viewModel()

                    NavHost(navController = navController, startDestination = "images") {

                        composable("images") {
                            CatsImagesScreen(
                                viewModel = viewModel,
                                onFavouriteIconClick = { navController.navigate("favourites") })
                        }
                        composable("favourites") { FavouritesScreen(viewModel) }

                    }

                }

            }
        }
    }
}


@Composable
fun Greeting(viewModel: CatsImagesViewModel = hiltViewModel()) {
    val catsImages = viewModel.catsImages.value
    Text(text = catsImages.toString())
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CatsPicturesAppTheme {
//        Greeting("Android")
    }
}