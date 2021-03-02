package com.example.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dog
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogCard(dog: Dog, onClick: (Dog) -> Unit) {
    Card(
        Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(16.dp)
            .clickable {
                onClick(dog)
            }, shape = RoundedCornerShape(8.dp)
    ) {
        Box {
            CoilImage(
                data = dog.image,
                contentDescription = "Dog image",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(Modifier.matchParentSize()) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                }
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(
                        Color.White.copy(alpha = 0.6f)
                    )
            )
            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 32.dp, start = 16.dp),
                text = dog.name,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 16.dp, start = 16.dp),
                text = dog.shortDescription,
                style = TextStyle(fontWeight = FontWeight.Light)
            )
        }
    }
}