package com.example.raceshw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.raceshw.databinding.FragmentAccountBinding
import com.example.raceshw.databinding.FragmentInfoBinding


class AccountFragment : Fragment(R.layout.fragment_account) {
    var binding:FragmentAccountBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAccountBinding.bind(view)
    }
    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }

}