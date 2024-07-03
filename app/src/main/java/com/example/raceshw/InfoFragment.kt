package com.example.raceshw

import SubjectAdapter
import SubjectRepozitory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.raceshw.databinding.FragmentInfoBinding


class InfoFragment : Fragment(R.layout.fragment_info) {
    private var binding:FragmentInfoBinding?=null
    private var adapter: SubjectAdapter? = null

    private fun initAdapter() {
        binding?.run {
            adapter = SubjectAdapter(
                list = SubjectRepozitory.subjects,
                glide = Glide.with(this@InfoFragment))


            rvSubject.adapter = adapter

            rvSubject.layoutManager = LinearLayoutManager(requireContext())
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)
        initAdapter()
    }
    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}