package es.iessaladillo.pedrojoya.baldogym.ui.trainingsession

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.baldogym.R
import es.iessaladillo.pedrojoya.baldogym.ui.schedule.ScheduleActivityViewModel
import es.iessaladillo.pedrojoya.baldogym.ui.schedule.ScheduleActivityViewModelFactory
import androidx.activity.viewModels
import androidx.lifecycle.observe
import es.iessaladillo.pedrojoya.baldogym.data.LocalRepository
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession
import kotlinx.android.synthetic.main.schedule_activity_item.*
import kotlinx.android.synthetic.main.training_session_activity.*


class TrainingSessionActivity : AppCompatActivity() {

    private val localRepository= LocalRepository

    private val viewModel: TrainingSessionActivityViewModel by viewModels{
        TrainingSessionActivityViewModelFactory(localRepository,application,intent.getLongExtra("ID",3))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.training_session_activity)
        setUpViews()
        setListeners()
    }

    private fun setListeners() {
        btnJoin2.setOnClickListener { viewModel.joinSession(viewModel.session) }
    }

    private fun setUpViews() {
        imgActivity2.setImageResource(viewModel.session.photoResId)
        lblSession2.text=viewModel.session.name
        lblDay2.text=viewModel.session.weekDay.name
        lblTrainer2.text=viewModel.session.trainer
        lblHour2.text=viewModel.session.time
        lblRoom2.text=viewModel.session.room
        lblDescription2.text=viewModel.session.description
        lblParticipants2.text=viewModel.session.participants.toString()+" Participants"
        viewModel.joined.observe(this){
            if(it){
                btnJoin2.background=btnJoin2.resources.getDrawable(R.drawable.session_btn_quit_background)
                btnJoin2.setTextColor(Color.BLACK)
                btnJoin2.text=btnJoin2.resources.getString(R.string.schedule_item_quit)
            }
            else{
                btnJoin2.background=btnJoin2.resources.getDrawable(R.drawable.session_btn_join_background)
                btnJoin2.setTextColor(Color.WHITE)
                btnJoin2.text=btnJoin2.resources.getString(R.string.schedule_item_join)
            }
        }


    }


}
