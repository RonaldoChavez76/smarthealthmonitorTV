package mx.utng.smarthealthmonitor.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import mx.utng.smarthealthmonitor.domain.model.LecturaFC

interface SmartHealthRepository {
    val fcActual: StateFlow<Int>
    fun obtenerHistorial(): Flow<List<LecturaFC>>
}
