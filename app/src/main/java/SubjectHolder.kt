import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.raceshw.R
import com.example.raceshw.Subject
import com.example.raceshw.databinding.ItemSubjectBinding

class SubjectHolder(
    private val binding:ItemSubjectBinding,
    private val glide: RequestManager,
    private val onClick: (Int) -> Unit
):ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    fun onBind(subjectId: Int){

        val subject: Subject = SubjectRepozitory.subjects[subjectId]

        binding.run{
            binding.subName.text=subject.Name
            binding.discription.text=subject.Info

            glide
                .load(subject.url)
                .error(R.drawable.baseline_info_24)
                .placeholder(R.drawable.baseline_info_24)
                .apply(requestOptions)
                .into(subIcon)

            cardView.setOnClickListener{
                onClick(subjectId)
            }
        }


    }
}
