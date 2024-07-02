package com.example.raceshw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.raceshw.databinding.FragmentEntryBinding
import com.example.raceshw.databinding.FragmentShowingBinding


class ShowingFragment : Fragment(R.layout.fragment_showing) {
    var binding:FragmentShowingBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShowingBinding.bind(view)
        var arg=arguments?.getString("Message")
        binding?.run{
            message.text=arg
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}