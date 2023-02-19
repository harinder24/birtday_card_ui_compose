package com.example.birthdaycard

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthDayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthDayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImageAndText("Android",from = "~Harinder")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImageAndText(message: String, from:String){
    val image = painterResource(id = R.drawable.androidparty)
    Box{
        Image(painter = image, contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)
        BirthDayGreeting(message= message, from=from)
    }
}



@Composable
fun BirthDayGreeting(message: String, from:String) {
    Column() {

        Text(text = message, fontSize = 36.sp, modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.Start).padding(top = 10.dp, start = 10.dp))
        Text(text = from, fontSize = 24.sp, modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.End).padding(top = 10.dp, end = 10.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BirthDayCardTheme {
        BirthdayGreetingWithImageAndText(message = stringResource(R.string.happy_bday_txt) ,from = stringResource(
                    R.string.happy_bday_from)
                )
    }
}