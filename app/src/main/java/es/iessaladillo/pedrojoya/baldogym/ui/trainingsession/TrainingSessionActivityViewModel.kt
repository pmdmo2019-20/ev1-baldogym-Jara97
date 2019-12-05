package es.iessaladillo.pedrojoya.baldogym.ui.trainingsession

import android.app.Application
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.baldogym.data.Repository
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession

class TrainingSessionActivityViewModel(private val repository: Repository, private val application: Application,private val id:Long) : ViewModel() {


    private val session: TrainingSession=repository.getSession(id)

}