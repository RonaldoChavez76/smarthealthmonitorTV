package mx.utng.smarthealthmonitor.domain.model

data class LecturaFC(
    val id: Int = 0,
    val bpm: Int,
    val timestamp: Long = System.currentTimeMillis(),
    val patientName: String = "Paciente Desconocido"
)
