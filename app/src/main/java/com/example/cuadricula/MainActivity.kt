package com.example.cuadricula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadricula.data.DataSource
import com.example.cuadricula.ui.theme.CuadriculaTheme
import com.example.cuadricula.model.Topic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadriculaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicsApp()
                }
            }
        }
    }
}


@Composable
fun TopicsApp() {
    TopicList(topicList = DataSource.topics)

}

@Composable
fun TopicsCard(topic:Topic, modifier: Modifier = Modifier) {

    Card(modifier = modifier) {
        Row {
            Image(painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
            modifier = modifier.size(68.dp))

            Column {
                Text(text = stringResource(id = topic.stringResourceId),
                modifier = modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp))

                Row {

                    Icon(painter = painterResource(R.drawable.ic_grain), contentDescription = null,
                        modifier = modifier.padding(start = 16.dp))
                    Text(text = topic.num.toString(),
                        modifier = modifier.padding(start = 8.dp))
                }

            }
        }
    }
}
@Composable
fun TopicList(topicList: List<Topic>, modifier: Modifier = Modifier){

    LazyColumn(modifier = modifier){
        items (topicList) {topic -> TopicsCard(topic, modifier = modifier)  }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CuadriculaTheme {
        val topic = Topic(R.string.architecture, 321, R.drawable.architecture)
        TopicsCard(topic = topic)
    }
}