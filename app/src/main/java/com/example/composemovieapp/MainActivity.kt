package com.example.composemovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable ()-> Unit){
    ComposeMovieAppTheme {

        val systemUiController = rememberSystemUiController()

        if (isSystemInDarkTheme()){
            systemUiController.setStatusBarColor(color = Color.Transparent)
        }
        else{
            systemUiController.setStatusBarColor(color = Color.Magenta)

        }

        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Magenta,
                    elevation = 0.dp
                ) {
                    Text(text = "Movies")
                }
            }
        ) {
           content()
        }
    }
}

@Composable
fun MainContent(
    movieList: List<String> = listOf("Harry Potter","Avatar","300","Life","Happiness.."
    ,"Meet the Spartan","God Father","Interstellar","The Martin","Ice Age","Distance")
){
    Column() {
        LazyColumn(
            contentPadding = PaddingValues(12.dp)
        ){
            items(items = movieList){ item->
                MovieRow(movie = item)
            }
        }
    }
}

@Composable
fun MovieRow(movie: String){

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
              Icon(imageVector = Icons.Default.AccountBox, contentDescription = "icons")

            }
            Text(text = movie)

        }
    }

}

@Preview
@Composable
fun View(){
    MyApp {
        MainContent()
    }
}