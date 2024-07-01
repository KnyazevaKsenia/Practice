package com.example.raceshw

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.raceshw.databinding.ActivityMainFragmentBinding


class MainFragmentActivity : AppCompatActivity() {
    private var binding: ActivityMainFragmentBinding?=null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding=ActivityMainFragmentBinding.inflate(layoutInflater).also{
            setContentView(it.root)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding=null

    }


}