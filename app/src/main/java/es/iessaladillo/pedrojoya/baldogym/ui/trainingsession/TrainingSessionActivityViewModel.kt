package es.iessaladillo.pedrojoya.baldogym.ui.trainingsession

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.baldogym.data.LocalRepository
import es.iessaladillo.pedrojoya.baldogym.data.Repository
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession
import es.iessaladillo.pedrojoya.baldogym.data.entity.WeekDay
import es.iessaladillo.pedrojoya.baldogym.data.entity.getCurrentWeekDay

class TrainingSessionActivityViewModel(private val repository: Repository, private val application: Application,private val id:Long) : ViewModel() {


    var session: TrainingSession=repository.getSession(id)

    private val _joined: MutableLiveData<Boolean> = MutableLiveData(session.userJoined)
    val joined: LiveData<Boolean>
        get() = _joined


    fun joinSession(session:TrainingSession){
        LocalRepository.joinSession(session)
        querySession()
        _joined.value=session.userJoined

    }

    fun querySession() {
        session=LocalRepository.getList().filter { x->x.id==session.id }.last()
    }

}