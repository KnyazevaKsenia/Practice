package com.example.raceshw

import android.os.Bundle
import android.webkit.ConsoleMessage
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}

open class Car(
    val mark: String,
    val model:Int,
    val year: Int,
    val colour:String)
{
    fun printInfo()
    {

    }

}

class Jeep(mark: String,
           model: Int,
           year: Int,
           colour: String
            ): Car(
    mark=mark,
    model=model,
    year=year,
    colour=colour
)
{

}