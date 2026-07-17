package mx.utng.smarthealthmonitor.tv.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mx.utng.smarthealthmonitor.data.remote.LecturaFcDto
import mx.utng.smarthealthmonitor.data.remote.NeonClient
import mx.utng.smarthealthmonitor.data.remote.NeonRequest

class TvNeonRepository {
    /** Obtener historial completo de los 3 dispositivos */
    suspend fun obtenerHistorialCompleto(limite: Int = 50): List<LecturaFcDto> =
        withContext(Dispatchers.IO) {
            NeonClient.api.executeQuery(
                auth = NeonClient.AUTH_HEADER,
                connStr = NeonClient.CONN_STRING,
                request = NeonRequest(
                    query = """SELECT id,bpm,estado,dispositivo,hora,created_at
                               FROM lecturas_fc
                               ORDER BY created_at DESC
                               LIMIT $1""".trimIndent(),
                    params = listOf(limite)
                )
            ).rows
        }

    /** Estadísticas por dispositivo */
    suspend fun obtenerEstadisticas(): List<LecturaFcDto> =
        withContext(Dispatchers.IO) {
            NeonClient.api.executeQuery(
                auth = NeonClient.AUTH_HEADER,
                connStr = NeonClient.CONN_STRING,
                request = NeonRequest(
                    query = """SELECT 0 as id, dispositivo,
                               ROUND(AVG(bpm)) AS bpm,
                               'Promedio' AS estado,
                               MAX(hora) AS hora,
                               '' as fecha, '' as created_at
                               FROM lecturas_fc
                               GROUP BY dispositivo""".trimIndent()
                )
            ).rows
        }

    // -- Consultas SQL avanzadas (Reto Extra) --

    suspend fun obtenerAlertas(horas: Int = 24): List<LecturaFcDto> =
        withContext(Dispatchers.IO) {
            NeonClient.api.executeQuery(
                auth = NeonClient.AUTH_HEADER,
                connStr = NeonClient.CONN_STRING,
                request = NeonRequest(
                    query = """SELECT * FROM lecturas_fc
                               WHERE (bpm < 60 OR bpm > 100)
                               AND created_at > NOW() - INTERVAL '$horas hours'
                               ORDER BY created_at DESC""".trimIndent()
                )
            ).rows
        }

    suspend fun obtenerLecturaMasReciente(): List<LecturaFcDto> =
        withContext(Dispatchers.IO) {
            NeonClient.api.executeQuery(
                auth = NeonClient.AUTH_HEADER,
                connStr = NeonClient.CONN_STRING,
                request = NeonRequest(
                    query = """SELECT DISTINCT ON (dispositivo)
                               id, dispositivo, bpm, estado, hora, fecha, created_at
                               FROM lecturas_fc
                               ORDER BY dispositivo, created_at DESC""".trimIndent()
                )
            ).rows
        }
}
