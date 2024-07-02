package com.example.raceshw

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.raceshw.databinding.FragmentAccountBinding
import com.example.raceshw.databinding.FragmentEntryBinding
import com.google.android.material.snackbar.Snackbar


class EntryFragment : Fragment(R.layout.fragment_entry) {
    var binding:FragmentEntryBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEntryBinding.bind(view)
        binding?.run{
            button.setOnClickListener{
                if (entry.text.length==0){
                    Snackbar.make(view, "Для отправки текста требуется заполнить поле", Snackbar.LENGTH_LONG).show()
                    }
                else{
                    val text= entry.text.toString()
                    val bundle=Bundle()
                    bundle.putString("Message", text)

                    findNavController().navigate(R.id.action_entryFragment_to_showingFragment,
                        args=bundle)
                }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }



}