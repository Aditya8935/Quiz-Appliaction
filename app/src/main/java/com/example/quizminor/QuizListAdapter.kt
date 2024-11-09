import android.content.Context
import android.content.Intent
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizminor.DetailActivity
import com.example.quizminor.databinding.RecyclerItemBinding



class QuizListAdapter(
    private val quizList: ArrayList<QuizList>,
    private val context: Context
) : RecyclerView.Adapter<QuizListAdapter.QuizViewModel>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewModel {
        val binding =
            RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuizViewModel(binding)
    }

    override fun getItemCount(): Int = quizList.size

    override fun onBindViewHolder(holder: QuizViewModel, position: Int) {
        val currentItem = quizList[position]

        holder.titleName.text = currentItem.title.toString()
        holder.subtitleName.text = currentItem.subtitle.toString()

        // Convert timer duration from String to Long
        val timerDuration = currentItem.timer.toLong()

        // Start the timer for this quiz item
        holder.startTimer(timerDuration)
    }

    inner class QuizViewModel(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val titleName: TextView = binding.quizTitleText
        val subtitleName: TextView = binding.quizSubtitleText
        val time: TextView = binding.quizTimeText

        private var timer: CountDownTimer? = null

        fun startTimer(timerDuration: Long) {
            timer = object : CountDownTimer(timerDuration, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    // Update the time text view
                    time.text = "Time: ${millisUntilFinished / 1000}"
                }

                override fun onFinish() {
                    // Handle timer finish event (e.g., submit quiz)
                    time.text = "Time's up!"
                }
            }
            timer?.start()
        }

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                openDetailActivity(position)
            }
        }

        private fun openDetailActivity(position: Int) {
            val quizItem: QuizList = quizList[position]

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("SECTION", position + 1) // Assuming section numbers start from 1
            context.startActivity(intent)
        }

    }
}

