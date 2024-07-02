package com.example.raceshw

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.raceshw.databinding.ActivityMainFragmentBinding


@Suppress("DEPRECATION")
class MainFragmentActivity : AppCompatActivity() {
    private var binding: ActivityMainFragmentBinding?=null
    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainFragmentBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController

        controller?.let{navController->
            binding?.navButtom?.setupWithNavController(navController)


        }

    }


    override fun onBackPressed() {
        super.onBackPressed()
        controller?.navigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding=null

    }


}