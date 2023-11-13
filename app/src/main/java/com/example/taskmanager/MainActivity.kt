package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) { 
                    TaskImage(text1 = getString(R.string.text1), text2 =  getString(R.string.text2), modifier = Modifier)


                }
            }
        }
    }
}
@Composable
fun TaskImage(text1: String, text2: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.ic_task_completed)
    Box(
        modifier = modifier
            .fillMaxSize(1f)
            .padding(6.dp),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop

        )
        TaskText(text1 = "Task Completed", text2 = "Nice Work!", modifier = Modifier.align(Alignment.BottomCenter ))

    }
    
}

@Composable
fun TaskText(text1: String, text2: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                .padding(bottom = 6.dp) // Add padding at the bottom

    ) {
        Text(
            text = text1,
            fontWeight = Bold,
            modifier = modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = text2,
            fontSize = 16.sp,
            modifier = modifier
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TaskImage(text1 = "Task Completed", text2 = "Nice Work!", modifier = Modifier)
    }
}


