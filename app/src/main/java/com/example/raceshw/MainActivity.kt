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
import kotlin.random.Random


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
                if (binding.amountOfCarsEntry.text!=null)
                {
                    var amount:Int=binding.amountOfCarsEntry.text.toInt()
                    val raceManager=RaceManager(amount)
                    raceManager.StartRace()
                }

            }
        }
    }
}

public enum class Marks{
    Porshe,
    Audi,
    BMW,
    Mercedes
}


open class Car(val mark: Marks, val year: Int, val horsePowers: Int)
{
    fun printInfo()
    {
        println("Mark: $mark, Year: $year")
    }
}

class Jeep(mark: Marks, model: Int, year: Int, horsePowers:Int, val wheelWidth:Int): Car(
    mark=mark,
    year=year,
    horsePowers=horsePowers
)
{}

class Crossover(mark: Marks, model: Int, year: Int, horsePowers:Int,  val driveUnit:String): Car(
    mark=mark,
    year=year,
    horsePowers=horsePowers
)


class Pickup(mark: Marks, model: Int, year: Int, horsePowers:Int, val liflingCapacity:Int ): Car(
    mark=mark,
    year=year,
    horsePowers=horsePowers
)
{}

class Minivan(mark: Marks, model: Int, year: Int, color: String, horsePowers:Int, val enginePower:Int): Car(
    mark=mark,
    year=year,
    horsePowers=horsePowers
)


class RaceManager(private val amountOfCars: Int) {
    private var cars: Array<Car> = arrayOf()
    private val random = Random

    fun CreateArray(amountOfCars: Int) {
        cars = Array(amountOfCars) { CreateCar() }
    }

    fun CreateCar(): Car {
        val mark = Marks.values()[random.nextInt(Marks.values().size)]
        val horsePowers = random.nextInt(200, 250)
        val year = random.nextInt(2000, 2024)
        return Car(mark, year, horsePowers)
    }

    fun GetCarPower(car: Car): Int {
        return car.year + car.horsePowers * 15
    }

    fun GetWnner(car1: Car, car2: Car): Car {
        return if (GetCarPower(car1) < GetCarPower(car2)) {
            car2
        } else {
            car1
        }
    }

    fun MakeRace() {
        var winners: Array<Car>
        if (cars.size % 2 == 0) {
            winners = Array(cars.size / 2) { Car(Marks.BMW, 0, 0) }
        } else {
            winners = Array(cars.size / 2 + 1) { Car(Marks.BMW, 0, 0) }
            winners[winners.size - 1] = cars[cars.size - 1]
        }

        for (i in 0 until cars.size - 1 step 2) {
            val winner = GetWnner(cars[i], cars[i + 1])
            winners[i / 2] = winner
            println("${cars[i].mark}${cars[i].year} VS ${cars[i + 1].mark}${cars[i + 1].year} : ${winner.mark} ${winner.year}")
        }
        println()
        cars = winners
    }

    fun PrintResults() {
        when (cars.size) {
            amountOfCars -> print("Members: ")
            1 -> print("Winner: ")
            else -> print("Winners: ")
        }
        cars.forEach {
            print("${it.mark} ${it.year} ; ")
        }
        println()
    }

    fun StartRace() {
        CreateArray(amountOfCars)
        PrintResults()
        while (cars.size != 1) {
            MakeRace()
            PrintResults()
        }
    }
}
