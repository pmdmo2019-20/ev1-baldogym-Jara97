package es.iessaladillo.pedrojoya.baldogym.ui.schedule

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.baldogym.data.LocalRepository
import es.iessaladillo.pedrojoya.baldogym.data.Repository
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession
import es.iessaladillo.pedrojoya.baldogym.data.entity.WeekDay
import es.iessaladillo.pedrojoya.baldogym.data.entity.getCurrentWeekDay

class ScheduleActivityViewModel(private val repository: Repository, private val application: Application) : ViewModel() {


    private val _sessions: MutableLiveData<List<TrainingSession>> = MutableLiveData()
    val sessions: LiveData<List<TrainingSession>>
        get() = _sessions

    private val _day: MutableLiveData<WeekDay> = MutableLiveData(getCurrentWeekDay())
    val day: LiveData<WeekDay>
        get() = _day


    fun querySessions() {
        if(day.value==WeekDay.MONDAY){
            _sessions.value=LocalRepository.getList().filter { x->x.weekDay==WeekDay.MONDAY }.sortedBy { x->x.time }
        }
        else if(day.value==WeekDay.TUESDAY){
            _sessions.value=LocalRepository.getList().filter { x->x.weekDay==WeekDay.TUESDAY }.sortedBy { x->x.time }
        }
        else if(day.value==WeekDay.WEDNESDAY){
            _sessions.value=LocalRepository.getList().filter { x->x.weekDay==WeekDay.WEDNESDAY }.sortedBy { x->x.time }
        }
        else if(day.value==WeekDay.THURSDAY){
            _sessions.value=LocalRepository.getList().filter { x->x.weekDay==WeekDay.THURSDAY }.sortedBy { x->x.time }
        }
        else if(day.value==WeekDay.FRIDAY){
            _sessions.value=LocalRepository.getList().filter { x->x.weekDay==WeekDay.FRIDAY }.sortedBy { x->x.time }
        }
        else if(day.value==WeekDay.SATURDAY){
            _sessions.value=LocalRepository.getList().filter { x->x.weekDay==WeekDay.SATURDAY }.sortedBy { x->x.time }
        }
        else if(day.value==WeekDay.SUNDAY){
            _sessions.value=LocalRepository.getList().filter { x->x.weekDay==WeekDay.SUNDAY }.sortedBy { x->x.time }
        }

    }

    fun setDay(day: WeekDay) {
        _day.value=day
        querySessions()
    }

    fun joinSession(session:TrainingSession,isJoined: Boolean){
            LocalRepository.joinSession()
    }


}