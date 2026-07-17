package mx.utng.srcp.smarthealthmonitor.tv.domain.model

import mx.utng.smarthealthmonitor.domain.model.LecturaFC

data class TvUiState(
    val lecturas: List<LecturaFC> = emptyList(),
    val fcActual: Int = 0,
    val fcEstado: String = "Normal",
    val ultimaHora: String = "",
    val estadisticas: List<LecturaFC> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null,
)
