package com.example.raceshw

import SubjectRepozitory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.raceshw.databinding.FragmentSettingsBinding
import com.example.raceshw.databinding.FragmentSubjectBinding


class SubjectFragment : Fragment(R.layout.fragment_subject) {

    private var binding: FragmentSubjectBinding? = null
    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private fun init(subject: Subject)
    {
        val glide: RequestManager = Glide.with(this@SubjectFragment)

        binding?.run{
            tvSubject.text = subject.Name
            mainDiscription.text=subject.Info
            longDiscription.text=subject.longDiscription

            glide
                .load(subject.url)
                .error(R.drawable.baseline_info_24)
                .placeholder(R.drawable.baseline_info_24)
                .apply(requestOptions)
                .into(subjectFragmentPicture)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val id: Int = arguments?.getInt(ARG_ID) ?: 0
        val subject: Subject = SubjectRepozitory.subjects[id]

        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubjectBinding.bind(view)
        init(subject)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


    companion object{

        private val ARG_ID = "ARG_IG"

        fun bundle(subjectId: Int): Bundle = Bundle().apply{
            putInt(ARG_ID, subjectId)
        }
    }
}