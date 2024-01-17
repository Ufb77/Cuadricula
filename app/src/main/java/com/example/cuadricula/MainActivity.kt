package com.example.cuadricula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
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

    Card() {
        Row {
            Image(painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
            modifier = modifier.size(dimensionResource(id = R.dimen.image_size))
               )

            Column {
                Text(text = stringResource(id = topic.stringResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.padding(
                        start = dimensionResource(id =R.dimen.padding_medium),
                        top = dimensionResource(id =R.dimen.padding_medium),
                        end = dimensionResource(id =R.dimen.padding_medium),
                        bottom = dimensionResource(id =R.dimen.padding_small)
                    )
                )

                Row {

                    Icon(painter = painterResource(R.drawable.ic_grain), contentDescription = null,
                        modifier = modifier.padding(start = dimensionResource(id =R.dimen.padding_medium)))
                    Text(text = topic.num.toString(),
                        modifier = modifier.padding(start = dimensionResource(id =R.dimen.padding_small)),
                    style = MaterialTheme.typography.labelMedium)
                }

            }
        }
    }
}
@Composable
fun TopicList(topicList: List<Topic>, modifier: Modifier = Modifier){

    LazyVerticalGrid(columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id =R.dimen.padding_small)),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small)),
        modifier = modifier.fillMaxSize()
    ){
        items (topicList) {topic -> TopicsCard(topic, modifier = modifier)  }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CuadriculaTheme {
        TopicsApp()
    }
}