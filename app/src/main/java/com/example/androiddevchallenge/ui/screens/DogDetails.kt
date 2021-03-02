package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.model.dogs
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogDetails(dogId: Int, navController: NavController?) {
    val dog = dogs.find {
        it.id == dogId
    } ?: return
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        Icons.Default.ArrowBack, "",
                        Modifier
                            .padding(8.dp)
                            .clickable {
                                navController?.navigateUp()
                            }
                    )
                },
                title = { Text(dog.name) })
        }
    ) {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                CoilImage(
                    data = dog.image,
                    contentDescription = "Dog image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentScale = ContentScale.FillBounds,
                    loading = {
                        Box(Modifier.matchParentSize()) {
                            CircularProgressIndicator(Modifier.align(Alignment.Center))
                        }
                    }
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                    text = dog.name
                )
                Text(
                    modifier = Modifier.padding(
                        top = 8.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    ), text = dog.description
                )
            }
        }
    }
}

object DogDetailsArguments {
    const val DOG_ID ="dog_id"
}
