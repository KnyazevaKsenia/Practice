package com.example.raceshw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.raceshw.databinding.MainFragmentBinding


class MainFragment:Fragment(R.layout.main_fragment){
    private var binding:MainFragmentBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

