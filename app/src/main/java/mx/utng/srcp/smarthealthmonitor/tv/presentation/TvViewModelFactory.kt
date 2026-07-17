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
            return TvViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
