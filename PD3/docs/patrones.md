[← Volver al README de PD3](../README.md)

# Estrategia y patrones de diseño

## Estrategia para incrementar las operaciones (manteniendo MVC)

1. **Modelo:** reemplazar `multiplyBy()` por `apply(Operation op, String operand)`. Cada operación se define en un `enum Operation` (suma, resta, multiplicación, división) con su símbolo y su función `BigDecimal → BigDecimal`.
2. **Vista:** crear un botón por cada valor de `Operation.values()` en un ciclo, para que agregar una operación no obligue a escribir más código de interfaz.
3. **Controlador:** un solo `OperationListener` parametrizado con la operación, en lugar de un listener por botón.
4. **Errores:** capturar también `ArithmeticException` (división entre cero) y mostrarla con `view.showError()`.

La vista sigue sin conocer la lógica, el modelo sigue sin conocer Swing y el controlador sigue siendo el único que los conecta.

## ¿Conviene el patrón Command?

El patrón Command encapsula cada acción como un objeto (`interface Command { void execute(); }`) con sus propias clases `AddCommand`, `SubtractCommand`, etc.

**Ventajas**
- Cada operación vive en su propia clase y se agrega sin tocar el controlador (principio abierto/cerrado).
- Permite **deshacer/rehacer** y mantener un **historial** (`undo()`), porque cada comando guarda su estado.
- Facilita registrar, encolar o repetir operaciones (macros).
- Desacopla quien invoca (botón) de quien ejecuta (modelo).

**Desventajas**
- Para operaciones de una sola línea y sin estado, crea muchas clases casi vacías (una por operación) → **sobreingeniería**.
- Aumenta el número de archivos y la complejidad del diagrama.
- Sin requisito de deshacer o historial, no se aprovecha su principal ventaja.

**Conclusión:** para esta calculadora, donde cada operación es solo una función de dos números, Command no es la mejor opción. Se recomienda el `enum Operation` (variante de **Strategy**), que logra la misma extensibilidad con mucho menos código:

| Criterio | Command | `enum` / Strategy |
|---|---|---|
| Agregar operación | Nueva clase + registro en la vista | Nueva constante en el `enum` |
| Clases nuevas | 1 por operación | 0 |
| Undo/redo | Natural | Requiere pila de estados aparte |
| Complejidad | Alta | Baja |

Command pasaría a ser la mejor opción **si se pide historial o deshacer**.

**Otros patrones a considerar**
- **Strategy:** el elegido; cada operación es un algoritmo intercambiable.
- **Observer:** el modelo notifica a la vista cuando cambia el total, en lugar de que el controlador llame a `setTotal()`; es el MVC "completo" y reduce el acoplamiento.
- **Factory / Registro de operaciones:** útil si las operaciones se cargan dinámicamente.

Los diagramas del diseño final están en [diagrama-clases.md](diagrama-clases.md).
