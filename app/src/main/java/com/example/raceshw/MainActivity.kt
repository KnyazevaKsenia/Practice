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
    private var viewBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)
        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewBinding=null
    }
    private fun initViews()
    {
        viewBinding?.let{ binding->
            binding.startButton.setOnClickListener(){
                if (binding.amountOfCarsEntry.text!=null)
                {
                    val amount:String= binding.amountOfCarsEntry.text.toString()
                    val intAmount=amount.toInt()
                    val raceManager=RaceManager(intAmount)
                    raceManager.startRace()
                }

            }
        }
    }
}

public enum class Marks{
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


class Minivan(mark: Marks, model: Int, year: Int, horsePowers:Int, val enginePower:Int): Car(
    mark=mark,
    year=year,
    horsePowers=horsePowers
)


class RaceManager(private val amountOfCars: Int) {
    private var cars: Array<Car> = arrayOf()
    private val random = Random

    private fun createArray(amountOfCars: Int) {
        cars = Array(amountOfCars) { createCar() }
    }

    private fun createCar(): Car {
        val mark = Marks.entries[random.nextInt(Marks.entries.size)]
        val horsePowers = random.nextInt(200, 250)
        val year = random.nextInt(2000, 2024)
        return Car(mark, year, horsePowers)
    }

    private fun getCarPower(car: Car): Int {
        return car.year + car.horsePowers * 15
    }

    private fun getWinner(car1: Car, car2: Car): Car {
        return if (getCarPower(car1) < getCarPower(car2)) {
            car2
        } else {
            car1
        }
    }

    private fun makeRace() {
        var winners: Array<Car>
        if (cars.size % 2 == 0) {
            winners = Array(cars.size / 2) { Car(Marks.BMW, 0, 0) }
        } else {
            winners = Array(cars.size / 2 + 1) { Car(Marks.BMW, 0, 0) }
            winners[winners.size - 1] = cars[cars.size - 1]
        }

        for (i in 0 until cars.size - 1 step 2) {
            val winner = getWinner(cars[i], cars[i + 1])
            winners[i / 2] = winner
            println("${cars[i].mark}${cars[i].year} VS ${cars[i + 1].mark}${cars[i + 1].year} : ${winner.mark} ${winner.year}")
        }
        println()
        cars = winners
    }

    private fun printResults() {
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

    fun startRace() {
        createArray(amountOfCars)
        printResults()
        while (cars.size != 1) {
            makeRace()
            printResults()
        }
    }
}
