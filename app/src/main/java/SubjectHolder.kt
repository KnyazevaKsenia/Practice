import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.raceshw.Subject
import com.example.raceshw.databinding.ItemSubjectBinding

class SubjectHolder(
    private val binding:ItemSubjectBinding,
    private val glide: RequestManager,
):ViewHolder(binding.root) {
    fun onBind(subject: Subject){
        binding.run{
            binding.subName.text=subject.Name
            binding.discription.text=subject.Info
        }
    }
}
