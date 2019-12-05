package es.iessaladillo.pedrojoya.baldogym.ui.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.baldogym.R
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.schedule_activity_item.*

class TasksActivityAdapter : RecyclerView.Adapter<TasksActivityAdapter.ViewHolder>() {

    private var data: List<TrainingSession> = emptyList()
    private var onItemClick:((Int)->Unit)?=null
    private var onItemCheck:((Int)->Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksActivityAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.schedule_activity_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setOnItemClick(listener:((Int)->Unit)){
        onItemClick=listener
    }


    fun setOnItemCheck(listener:((Int)->Unit)){
        onItemCheck=listener
    }


    override fun onBindViewHolder(holder: TasksActivityAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun submitList(tasks: List<TrainingSession>) {
        data=tasks
        notifyDataSetChanged()
    }

    fun getItem(position:Int): TrainingSession {
        return data[position]
    }


    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {


        init {
            containerView.setOnClickListener{
                onItemClick?.invoke(adapterPosition)
            }
            /*chkCompleted.setOnClickListener {
                onItemCheck?.invoke(adapterPosition)
            }*/

        }




        fun bind(session:TrainingSession) {
            lblParticipantes.text=session.participants.toString()
            lblHora.text=session.time
            lblActivity.text=session.name
            lblTrainer.text=session.trainer
            lblRoom.text=session.room
            imgActivity.setImageResource(session.photoResId)



        }

    }

}