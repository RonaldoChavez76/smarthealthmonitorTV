# SmartHealth Monitor

Este proyecto es un sistema de monitoreo de salud que integra Wear OS, Android App y Android TV para el seguimiento de la frecuencia cardíaca (FC).

## Arquitectura - SmartHealth Monitor

```
Sensor PPG (Wear OS)
   |__ Health Services API
   ▼
PassiveListenerService (wear)
   |__ MessageClient (BLE)
   ▼
WearListenerService (app)
   |__ SmartHealthRepository
   ▼
StateFlow<Int> (fcActual) ──────────┐
   |                                │
   ▼                                ▼
DashboardViewModel (app)           TvViewModel (tv)
   |__ collectAsState()               |__ collectAsState()
   ▼                                  ▼
DashboardScreen (Compose)          TvCatalogScreen (Compose TV)
   └─ CastButton ──▶ Chromecast (Remote Playback)

Room DB (LecturaFC) ◀── Repository ──▶ Flow<List<LecturaFC>>
                              │
              ┌───────────────┴───────────────┐
              ▼                               ▼
        HistorialScreen (app)          TvCatalogScreen (tv)
```
