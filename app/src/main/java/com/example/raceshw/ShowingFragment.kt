package com.example.raceshw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.raceshw.databinding.FragmentShowingBinding


class ShowingFragment : Fragment(R.layout.fragment_showing) {
    private var binding:FragmentShowingBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShowingBinding.bind(view)
        val arg=arguments?.getString("Message")
        binding?.run{
            message.text=arg
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}