package es.iessaladillo.pedrojoya.baldogym.data

import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession

interface Repository {

    abstract fun getSession(id:Long): TrainingSession

    abstract fun joinSession(session: TrainingSession)

}