package es.iessaladillo.pedrojoya.baldogym.ui.trainingsession

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.baldogym.R
import es.iessaladillo.pedrojoya.baldogym.ui.schedule.ScheduleActivityViewModel
import es.iessaladillo.pedrojoya.baldogym.ui.schedule.ScheduleActivityViewModelFactory
import androidx.activity.viewModels
import es.iessaladillo.pedrojoya.baldogym.data.LocalRepository


class TrainingSessionActivity : AppCompatActivity() {

    private val localRepository= LocalRepository

    private val viewModel: TrainingSessionActivityViewModel by viewModels{
        TrainingSessionActivityViewModelFactory(localRepository,application,)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.training_session_activity)
    }



}
