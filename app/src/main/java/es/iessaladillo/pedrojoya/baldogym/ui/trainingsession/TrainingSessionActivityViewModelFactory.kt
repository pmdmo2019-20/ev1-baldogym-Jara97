package es.iessaladillo.pedrojoya.baldogym.ui.trainingsession

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.baldogym.data.LocalRepository
import es.iessaladillo.pedrojoya.baldogym.ui.schedule.ScheduleActivityViewModel

class TrainingSessionActivityViewModelFactory(private val localRepository: LocalRepository, val application: Application, private val id:Long) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TrainingSessionActivityViewModel(localRepository,application,id) as T
    }

}