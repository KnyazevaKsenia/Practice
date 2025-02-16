import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.raceshw.Subject
import com.example.raceshw.databinding.ItemSubjectBinding

class SubjectAdapter(
    private val list:List<Subject>,
    private val glide: RequestManager,
    private val onClick: (Int) -> Unit
):RecyclerView.Adapter<SubjectHolder>(

) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): SubjectHolder{
        return SubjectHolder(
            binding=ItemSubjectBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            ),
            glide=glide,
            onClick=onClick
        )
    }

    override fun onBindViewHolder(holder: SubjectHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int =list.size
}