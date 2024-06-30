package com.example.raceshw

import android.os.Bundle
import android.webkit.ConsoleMessage
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.raceshw.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private var button:Button?= null
    private var text: TextView?=null
    private var viewBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(viewBinding?.root)
        viewBinding=ActivityMainBinding.inflate(layoutInflater)
        initViews()
    }
    override fun onDestroy() {
        super.onDestroy()
    }
    private fun initViews()
    {
        viewBinding?.let{ binding->
            binding.startButton.setOnClickListener(){
                startRace()
            }
        }
    }
}

fun startRace(){}


open class Car(
    val mark: String,
    val model:Int,
    val year: Int,
    val color:String)
{
    fun printInfo()
    {
        println("Model: $model, Mark: $mark, Year: $year, Color: $color")
    }
}

class Jeep(mark: String, model: Int, year: Int, color: String, val wheelWidth:Int): Car(
    mark=mark,
    model=model,
    year=year,
    color=color
)
{

}

class Crossover(mark: String, model: Int, year: Int, color: String, val driveUnit:String): Car(
    mark=mark,
    model=model,
    year=year,
    color=color
)
{

}

class Pickup(mark: String, model: Int, year: Int, color: String, val liflingCapacity:Int ): Car(
    mark=mark,
    model=model,
    year=year,
    color=color
)
{


}

class Minivan(mark: String, model: Int, year: Int, color: String, val enginePower:Int): Car(
    mark=mark,
    model=model,
    year=year,
    color=color
)
{

}