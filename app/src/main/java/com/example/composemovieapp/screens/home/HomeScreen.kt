package com.example.composemovieapp.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composemovieapp.model.Movie
import com.example.composemovieapp.model.getMovies
import com.example.composemovieapp.navigation.MovieScreens
import com.example.composemovieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            ) {
                Text(text = "Movies")
            }
        }
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    movieList: List<Movie> = getMovies(),
    navController: NavController
){
    Column() {
        LazyColumn(
            contentPadding = PaddingValues(12.dp)
        ){
            items(items = movieList){ item->
                MovieRow(movie = item){
                   navController.navigate(MovieScreens.DetailsScreen.name+"/${it.id}")
                }
            }
        }
    }
}

