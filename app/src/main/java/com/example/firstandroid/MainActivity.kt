package com.example.firstandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.firstandroid.ui.theme.FirstAndroidTheme


private lateinit var db: database

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }

        db = Room.databaseBuilder(
            applicationContext,
            database::class.java, "database"
        ).build()

        val thread1 = Thread {
            var movie = MovieEntity(1, "spurderman", 8)
            db.movieDAO().insertMovie(movie)

            db.movieDAO().getAll().forEach(){
                Log.d("Fetch records", "id: : ${it.id}")
                Log.d("Fetch records", "title: : ${it.title}")
                Log.d("Fetch records", "rating: : ${it.rating}")
                Log.d("Fetch records", "poster: : ${it.poster}")
            }
        }
        thread1.start()


    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstAndroidTheme {
        Greeting("Android")
    }

    val thread = Thread {
        var movie = MovieEntity(2, "spurderman", 8)
        db.movieDAO().insertMovie(movie)

        db.movieDAO().getAll().forEach(){
            Log.i("Fetch records", "id: : ${it.id}")
            Log.i("Fetch records", "title: : ${it.title}")
            Log.i("Fetch records", "rating: : ${it.rating}")
            Log.i("Fetch records", "poster: : ${it.poster}")
        }
    }
    thread.start()

}