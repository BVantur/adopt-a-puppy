package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.dogs
import com.example.androiddevchallenge.ui.DogCard
import com.example.androiddevchallenge.ui.ROUTE_DETAILS

@Composable
fun DogList(navController: NavController?) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(Modifier.fillMaxWidth()) {
            items(dogs) { item ->
                DogCard(item) {
                    navController?.navigate("$ROUTE_DETAILS/${it.id}")
                }
            }
        }
    }
}