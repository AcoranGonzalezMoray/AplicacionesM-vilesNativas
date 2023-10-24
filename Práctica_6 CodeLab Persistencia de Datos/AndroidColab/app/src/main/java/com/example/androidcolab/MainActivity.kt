package com.example.androidcolab

import android.content.Context
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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.example.androidcolab.data.SettingsRepository
import com.example.androidcolab.ui.theme.AndroidColabTheme
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private val Context.dataStore by preferencesDataStore(name = "SETTINGS")

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewComponent()
        }

    }

    fun SaveData(textValue: String) {
        val settings = SettingsRepository(dataStore = dataStore)

        lifecycleScope.launch(Dispatchers.IO){
            settings.saveValues(textValue, true)
        }
    }

    suspend fun LoadData(): String {
        val settings = SettingsRepository(dataStore = dataStore)
        val nameDeferred = CompletableDeferred<String>()


        lifecycleScope.launch(Dispatchers.IO){
            settings.getValues().collect{
                withContext(Dispatchers.Main){
                    val name = it.name
                    nameDeferred.complete(name)
                }
            }
        }
        return nameDeferred.await()
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyButton(
    text: TextFieldValue,
    onTextChanged: (TextFieldValue) -> Unit,
    onButtonClick: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = text,
            onValueChange = { newTextFieldValue ->
                onTextChanged(newTextFieldValue)
            },
            modifier = Modifier
                .weight(0.65f)
                .padding(8.dp)
        )

        Button(
            onClick = {
                // Llamar a la lambda onButtonClick y pasar el texto actual
                val textValue = text.text
                onButtonClick(textValue)
            },
            modifier = Modifier
                .weight(0.35f)
                .padding(8.dp)
        ) {
            Text("Guardar")
        }
    }
}

@Composable
fun Body() {
    var textValue by remember { mutableStateOf(TextFieldValue()) }
    val context = LocalContext.current // Obtén el contexto actual
    val activity = context as MainActivity

    LaunchedEffect(Unit) {
        val loadedString = activity.LoadData()
        textValue = TextFieldValue(loadedString)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = R.drawable.ic_launcher_foreground),
            modifier = Modifier
                .background(Color.Blue)
                .size(90.dp),
            alignment = Alignment.Center,
            contentDescription = "Mi imagen de prueba 2"
        )
        Spacer(modifier = Modifier.height(16.dp))

        MyButton(
            text = textValue,
            onTextChanged = {
                textValue = it
            },
            onButtonClick = { textValue ->
                activity.SaveData(textValue)
                println("Texto del campo de entrada: $textValue")
            }
        )
    }
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
            Row(
                modifier = Modifier
                    .fillMaxHeight(0.15f)
                    .align(Alignment.TopCenter)
            ) {
                Header()
            }
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
            ) {
                Body()
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight(0.15f)
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Footer()
            }
        }
    }
}