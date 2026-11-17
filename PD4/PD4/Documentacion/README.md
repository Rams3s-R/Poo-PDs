# PD4: Stands de la Filey con MVC + Base de datos (JDBC)

Base: ejercicio PD2 de Stands. En esta versión `Expositor` pasa a ser `Editorial` y los datos se leen de MySQL con JDBC.

## Capas (MVC + BD)
| Capa | Paquete | Responsabilidad |
|---|---|---|
| Modelo | `filey.modelo` | Entidades: `Stand` (abstracta y 3 subtipos), `Editorial`, `Reserva` y enums |
| Vista | `filey.vista` | `VistaConsola`: solo imprime, no sabe de la BD |
| Controlador | `filey.controlador` | `ControladorFiley`: pide datos a los DAO y los pasa a la vista |
| BD | `filey.bd` y `filey.dao` | `ConexionBD` (conexión JDBC) y DAO por tabla: `StandDAO`, `EditorialDAO`, `ReservaDAO` |

## Flujo
`Main` → `ControladorFiley.iniciar()` → abre conexión con `ConexionBD` → cada DAO ejecuta su `SELECT` con `PreparedStatement` y convierte las filas en objetos del modelo → el controlador manda las listas a `VistaConsola`.

## Cómo ejecutar
1. Ejecutar `BaseDatos/filey_bd.sql` en MySQL Workbench (crea la BD, el usuario `filey_user` / `filey123` y los datos de ejemplo).
2. Descargar el conector **MySQL Connector/J** (`mysql-connector-j-x.x.x.jar`).
3. En VS Code: panel *Java Projects* → *Referenced Libraries* → **+** y seleccionar el `.jar`.
4. Ejecutar `Codigo/filey/Main.java`.

Si usas otras credenciales, cámbialas en `filey/bd/ConexionBD.java`.

## Contenido del repo
- `BaseDatos/`: script SQL y diagrama Entidad-Relación
- `DiagramaClases/`: diagrama de clases
- `Codigo/`: código fuente
- Video de máximo 5 min: pega aquí el enlace (con acceso abierto) → `link_video.md`
