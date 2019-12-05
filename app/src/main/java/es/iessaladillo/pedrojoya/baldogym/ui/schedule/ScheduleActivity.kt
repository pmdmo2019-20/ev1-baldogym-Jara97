package es.iessaladillo.pedrojoya.baldogym.ui.schedule

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.annotation.MenuRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import es.iessaladillo.pedrojoya.baldogym.R
import es.iessaladillo.pedrojoya.baldogym.data.LocalRepository
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession
import es.iessaladillo.pedrojoya.baldogym.data.entity.WeekDay
import es.iessaladillo.pedrojoya.baldogym.ui.trainingsession.TrainingSessionActivity
import kotlinx.android.synthetic.main.schedule_activity.*
import kotlinx.android.synthetic.main.schedule_activity_item.*

class ScheduleActivity : AppCompatActivity() {

    private val localRepository= LocalRepository

    private val listAdapter:TasksActivityAdapter=TasksActivityAdapter().apply {

            this.setOnItemClick { position->
                val session:TrainingSession=this.getItem(position)
                viewModel.joinSession(session)


        }
        this.setOnImgClick {
             position->
                val session:TrainingSession=this.getItem(position)
                startActivity(Intent(this@ScheduleActivity,TrainingSessionActivity::class.java)
                    .putExtra("ID",session.id))

        }
    }

    private val viewModel: ScheduleActivityViewModel by viewModels{
        ScheduleActivityViewModelFactory(localRepository,application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_activity)
        setupRecyclerView()
        observe()
        setListener()
        viewModel.querySessions()
    }


    private fun setupRecyclerView(){
        lstTasks.run{
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(
                DividerItemDecoration(context,
                    RecyclerView.VERTICAL)
            )
            adapter = listAdapter
        }
    }

    private fun setListener() {
        lblMon.setOnClickListener {
            viewModel.setDay(WeekDay.MONDAY)
            lblMon.setTextColor(resources.getColor(R.color.white))
            lblTues.setTextColor(resources.getColor(R.color.white_semi))
            lblWed.setTextColor(resources.getColor(R.color.white_semi))
            lblThu.setTextColor(resources.getColor(R.color.white_semi))
            lblFri.setTextColor(resources.getColor(R.color.white_semi))
            lblSat.setTextColor(resources.getColor(R.color.white_semi))
            lblSun.setTextColor(resources.getColor(R.color.white_semi))
        }
        lblTues.setOnClickListener {
            viewModel.setDay(WeekDay.TUESDAY)
            lblMon.setTextColor(resources.getColor(R.color.white_semi))
            lblTues.setTextColor(resources.getColor(R.color.white))
            lblWed.setTextColor(resources.getColor(R.color.white_semi))
            lblThu.setTextColor(resources.getColor(R.color.white_semi))
            lblFri.setTextColor(resources.getColor(R.color.white_semi))
            lblSat.setTextColor(resources.getColor(R.color.white_semi))
            lblSun.setTextColor(resources.getColor(R.color.white_semi))
        }
        lblWed.setOnClickListener {
            viewModel.setDay(WeekDay.WEDNESDAY)
            lblMon.setTextColor(resources.getColor(R.color.white_semi))
            lblTues.setTextColor(resources.getColor(R.color.white_semi))
            lblWed.setTextColor(resources.getColor(R.color.white))
            lblThu.setTextColor(resources.getColor(R.color.white_semi))
            lblFri.setTextColor(resources.getColor(R.color.white_semi))
            lblSat.setTextColor(resources.getColor(R.color.white_semi))
            lblSun.setTextColor(resources.getColor(R.color.white_semi))
        }
        lblThu.setOnClickListener {
            viewModel.setDay(WeekDay.THURSDAY)
            lblMon.setTextColor(resources.getColor(R.color.white_semi))
            lblTues.setTextColor(resources.getColor(R.color.white_semi))
            lblWed.setTextColor(resources.getColor(R.color.white_semi))
            lblThu.setTextColor(resources.getColor(R.color.white))
            lblFri.setTextColor(resources.getColor(R.color.white_semi))
            lblSat.setTextColor(resources.getColor(R.color.white_semi))
            lblSun.setTextColor(resources.getColor(R.color.white_semi))
        }
        lblFri.setOnClickListener {
            viewModel.setDay(WeekDay.FRIDAY)
            lblMon.setTextColor(resources.getColor(R.color.white_semi))
            lblTues.setTextColor(resources.getColor(R.color.white_semi))
            lblWed.setTextColor(resources.getColor(R.color.white_semi))
            lblThu.setTextColor(resources.getColor(R.color.white_semi))
            lblFri.setTextColor(resources.getColor(R.color.white))
            lblSat.setTextColor(resources.getColor(R.color.white_semi))
            lblSun.setTextColor(resources.getColor(R.color.white_semi))
        }
        lblSat.setOnClickListener {
            viewModel.setDay(WeekDay.SATURDAY)
            lblMon.setTextColor(resources.getColor(R.color.white_semi))
            lblTues.setTextColor(resources.getColor(R.color.white_semi))
            lblWed.setTextColor(resources.getColor(R.color.white_semi))
            lblThu.setTextColor(resources.getColor(R.color.white_semi))
            lblFri.setTextColor(resources.getColor(R.color.white_semi))
            lblSat.setTextColor(resources.getColor(R.color.white))
            lblSun.setTextColor(resources.getColor(R.color.white_semi))
        }
        lblSun.setOnClickListener {
            viewModel.setDay(WeekDay.SUNDAY)
            lblMon.setTextColor(resources.getColor(R.color.white_semi))
            lblTues.setTextColor(resources.getColor(R.color.white_semi))
            lblWed.setTextColor(resources.getColor(R.color.white_semi))
            lblThu.setTextColor(resources.getColor(R.color.white_semi))
            lblFri.setTextColor(resources.getColor(R.color.white_semi))
            lblSat.setTextColor(resources.getColor(R.color.white_semi))
            lblSun.setTextColor(resources.getColor(R.color.white))
        }


    }

    private fun observe() {
        viewModel.sessions.observe(this){
            showSchedule(it)

        }
        viewModel.day.observe(this){
            if(it==WeekDay.MONDAY){
                lblMon.setTextColor(resources.getColor(R.color.white))
            }
            else if(it==WeekDay.TUESDAY){
                lblTues.setTextColor(resources.getColor(R.color.white))
            }
            else if(it==WeekDay.WEDNESDAY){
                lblWed.setTextColor(resources.getColor(R.color.white))
            }
            else if(it==WeekDay.THURSDAY){
                lblThu.setTextColor(resources.getColor(R.color.white))
            }
            else if(it==WeekDay.FRIDAY){
                lblFri.setTextColor(resources.getColor(R.color.white))
            }
            else if(it==WeekDay.SATURDAY){
                lblSat.setTextColor(resources.getColor(R.color.white))
            }
            else if(it==WeekDay.SUNDAY){
                lblSun.setTextColor(resources.getColor(R.color.white))
            }
        }

    }

    private fun showSchedule(session: List<TrainingSession>) {
        lstTasks.post {
            listAdapter.submitList(session)
            listAdapter.notifyDataSetChanged()
            lblEmptyView.invisibleUnless(session.isEmpty())
        }
    }

    private fun View.invisibleUnless(condition: Boolean) {
        visibility = if (condition) View.VISIBLE else View.INVISIBLE
    }












    // TODO

}
