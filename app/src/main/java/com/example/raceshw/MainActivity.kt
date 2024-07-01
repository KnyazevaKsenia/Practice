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

    }

    override fun onDestroy() {
        super.onDestroy()

    }
}


