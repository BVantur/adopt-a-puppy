/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.DogCard
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    private val dogs = arrayOf(
        Dog(
            "Chips",
            "https://www.rd.com/wp-content/uploads/2020/06/GettyImages-185330333-edit.jpg",
            "Description1"
        ),
        Dog(
            "Puffy",
            "https://www.rd.com/wp-content/uploads/2021/01/GettyImages-131188311.jpg",
            "Description2"
        ),
        Dog(
            "Speck",
            "https://www.rd.com/wp-content/uploads/2019/01/shutterstock_115329475.jpg",
            "Description3"
        ),
        Dog(
            "Max",
            "https://www.rd.com/wp-content/uploads/2021/01/GettyImages-588935825.jpg",
            "Description4"
        ),
        Dog(
            "Hooch",
            "https://www.rd.com/wp-content/uploads/2019/01/shutterstock_589686617.jpg",
            "Description5"
        ),
        Dog(
            "Chopper",
            "https://www.rd.com/wp-content/uploads/2019/01/shutterstock_123087826-e1548785863702.jpg",
            "Description6"
        ),
        Dog(
            "Buddy",
            "https://www.rd.com/wp-content/uploads/2019/01/shutterstock_673465372.jpg",
            "Description7"
        ),
        Dog(
            "Bolt",
            "https://www.rd.com/wp-content/uploads/2019/01/shutterstock_493937641.jpg",
            "Description8"
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(dogs)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(items: Array<Dog>) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(Modifier.fillMaxWidth()) {
            items(items) { item ->
                DogCard(item) {

                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(arrayOf())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(arrayOf())
    }
}
