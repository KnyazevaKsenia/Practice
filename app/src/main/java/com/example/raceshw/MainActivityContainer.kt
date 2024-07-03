package com.example.raceshw

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.raceshw.databinding.ActivityMainFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


@Suppress("DEPRECATION")
class MainActivityContainer : AppCompatActivity() {

    private var binding: ActivityMainFragmentBinding?=null
    private var controller: NavController? = null

    private fun handleBottomNavigationViewvisibility(destination: NavDestination){
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navButtom)

        val showBottomNav = when (destination.id) {
            R.id.subjectFragment -> false
            else -> true
        }

        bottomNavigationView.visibility = if (showBottomNav) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFragmentBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController

        controller?.let{navController->
            binding?.navButtom?.setupWithNavController(navController)
            navController.addOnDestinationChangedListener {_, destination, _ ->
                handleBottomNavigationViewvisibility(destination)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}