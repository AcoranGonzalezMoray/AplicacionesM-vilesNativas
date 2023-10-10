package com.example.androidcolab

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidcolab.ui.theme.AndroidColabTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidColabTheme {
                Header()
            }
        }

    }
}
@Composable
fun MyImage(){
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.Gray)
            .size(56.dp),
        contentDescription = "Mi imagen de prueba"
    )
}

@Composable
fun MyTexts(){
    Column(){
        MyText(text = "Codelab Android - PAMN", Color.Black, MaterialTheme.typography.titleLarge)
        MyText(text = "Acorán González Moray", Color.Blue ,MaterialTheme.typography.titleSmall)
    }

}

@Composable
fun MyText(text:String, color:Color, style: TextStyle){
    Text(text, color = color, style= style)
}



@Composable
fun IconText(text:String, icon:ImageVector){
    Row(){
        Icon(
            imageVector = icon,
            contentDescription = "Icono llamada"
        )
        MyText(text = text, color = Color.Black , style =MaterialTheme.typography.bodyMedium)
    }
}


@Composable
fun Header() {
    Row(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically, // Alinea los elementos verticalmente al centro
        horizontalArrangement = Arrangement.Center
    ) {
        MyImage()
        Spacer(modifier = Modifier.width(5.dp))
        MyTexts()
    }
}

@Composable
fun Body() {
    Image(
        painterResource(id = R.drawable.ic_launcher_foreground),
        modifier = Modifier
            .background(Color.Blue)
            .size(90.dp),
        alignment = Alignment.Center,
        contentDescription = "Mi imagen de prueba 2"
    )
}


@Composable
fun Footer() {
    Column(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom // Alinea los elementos en la parte inferior
    ) {
        IconText("600622680", Icons.Rounded.Call)
        IconText("acorangonzalezmoray@gmail.com", Icons.Rounded.Email)
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponent(){
    AndroidColabTheme {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopCenter)
            ) {
                Header()
            }
            Column(
                modifier = Modifier.align(Alignment.Center)
            ) {
                Body()
            }
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Footer()
            }
        }
    }
}