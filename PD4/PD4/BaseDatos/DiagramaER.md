# Diagrama Entidad-Relación

```mermaid
erDiagram
    EDITORIAL ||--o{ RESERVA : realiza
    STAND ||--o{ RESERVA : "es reservado en"

    EDITORIAL {
        int id_editorial PK
        varchar nombre
        varchar correo UK
        varchar telefono
        varchar giro
    }
    STAND {
        varchar codigo PK
        enum tipo
        enum zona
        decimal largo
        decimal ancho
        enum estado
    }
    RESERVA {
        int id_reserva PK
        varchar codigo_stand FK
        int id_editorial FK
        date fecha
        enum estado
    }
```

## Relaciones
- Una **editorial** puede hacer muchas **reservas** (1:N).
- Un **stand** puede aparecer en muchas **reservas** a lo largo del tiempo (1:N), por ejemplo una cancelada y luego otra confirmada.
- **Reserva** es la tabla intermedia que une Editorial y Stand.
