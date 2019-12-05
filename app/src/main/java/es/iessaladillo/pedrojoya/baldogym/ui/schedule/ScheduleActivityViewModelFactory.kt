package es.iessaladillo.pedrojoya.baldogym.ui.schedule

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.baldogym.data.LocalRepository

class ScheduleActivityViewModelFactory(
    private val localRepository: LocalRepository,
    val application: Application
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ScheduleActivityViewModel(localRepository,application) as T
    }

}