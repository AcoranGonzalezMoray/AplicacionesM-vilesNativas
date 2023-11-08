package com.example.artspaceacoran

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceacoran.ui.theme.ArtSpaceAcoranTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAcoranTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
    val firstArtwork = R.drawable.cuadro_1
    val secondArtwork = R.drawable.cuadro_2
    val thirdArtwork = R.drawable.cuadro_4
    val fourthArtwork = R.drawable.cuadro_3

    var title by remember {
        mutableStateOf(R.string.cuadro1)
    }

    var year by remember {
        mutableStateOf(R.string.cuadro1_info)
    }

    var currentArtwork by remember {
        mutableStateOf(firstArtwork)
    }

    var imageResource by remember {
        mutableStateOf(currentArtwork)
    }


    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ArtworkDisplay(currentArtwork = currentArtwork)
            Spacer(modifier = modifier.size(16.dp))
            ArtworkTitle(title = title, year = year)
            Spacer(modifier = modifier.size(25.dp))
            Row(
                modifier = modifier.padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
            ) {
                // Previous Button
                Button(
                    onClick = {
                        when (currentArtwork) {
                            firstArtwork -> {
                                currentArtwork = fourthArtwork
                                title = R.string.cuadro4
                                year = R.string.cuadro4_info
                            }
                            secondArtwork -> {
                                currentArtwork = firstArtwork
                                title = R.string.cuadro1
                                year = R.string.cuadro1_info
                            }
                            thirdArtwork -> {
                                currentArtwork = secondArtwork
                                title = R.string.cuadro2
                                year = R.string.cuadro2_info
                            }
                            else -> {
                                currentArtwork = thirdArtwork
                                title = R.string.cuadro3
                                year = R.string.cuadro3_info
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.gray_900)
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 1.dp,
                        pressedElevation = 0.dp,
                        focusedElevation = 0.dp
                    )
                ) {
                    Text(
                        text = "Previous",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.blue_300)
                    )
                }

                // Next Button
                Button(
                    onClick = {
                        when (currentArtwork) {
                            firstArtwork -> {
                                currentArtwork = secondArtwork
                                title = R.string.cuadro2
                                year = R.string.cuadro2_info
                            }
                            secondArtwork -> {
                                currentArtwork = thirdArtwork
                                title = R.string.cuadro3
                                year = R.string.cuadro3_info
                            }
                            thirdArtwork -> {
                                currentArtwork = fourthArtwork
                                title = R.string.cuadro4
                                year = R.string.cuadro4_info
                            }
                            else -> {
                                currentArtwork = firstArtwork
                                title = R.string.cuadro1
                                year = R.string.cuadro1_info
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.blue_300)
                    ),
                    elevation = ButtonDefaults.elevatedButtonElevation(
                        defaultElevation = 1.dp,
                        pressedElevation = 0.dp,
                        focusedElevation = 0.dp
                    )
                ) {
                    Text(
                        text = "Next",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.gray_900)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtworkDisplay(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Image(
        painter = painterResource(currentArtwork),
        contentDescription = stringResource(id = R.string.cuadro2),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(max = 580.dp),
        contentScale = ContentScale.FillWidth
    )
    Text(text = "by Acoran Gonzalez Moray")
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .background(Color(R.color.gray_300))
    ) {

        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue_100),
            fontSize = 32.sp
        )


        Text(
            text = "- ${stringResource(id = year)} -",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.black)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAcoranTheme {
        ArtSpaceScreen()
    }
}