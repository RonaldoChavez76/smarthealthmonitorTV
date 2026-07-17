package mx.utng.srcp.smarthealthmonitor.tv.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import mx.utng.smarthealthmonitor.domain.model.LecturaFC
import mx.utng.smarthealthmonitor.domain.repository.SmartHealthRepository

class TvViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvViewModel::class.java)) {
            // Repositorio de prueba para que la app compile y funcione
            val mockRepository = object : SmartHealthRepository {
                override val fcActual = MutableStateFlow(75).asStateFlow()
                override fun obtenerHistorial() = flowOf(
                    listOf(
                        LecturaFC(bpm = 70, estado = "Normal", hora = "10:00"),
                        LecturaFC(bpm = 85, estado = "Elevado", hora = "10:15"),
                        LecturaFC(bpm = 72, estado = "Normal", hora = "10:30")
                    )
                )
            }
            return TvViewModel(mockRepository, context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
