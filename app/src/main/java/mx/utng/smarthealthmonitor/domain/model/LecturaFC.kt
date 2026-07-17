package mx.utng.smarthealthmonitor.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lecturas_fc")
data class LecturaFC(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val bpm: Int,
    val timestamp: Long = System.currentTimeMillis(),
    val patientName: String = "Paciente Desconocido",
    val estado: String = "Normal",
    val dispositivo: String = "app",
    val hora: String = "00:00",
    @ColumnInfo(name = "sincronizado")
    val sincronizado: Boolean = false
)
