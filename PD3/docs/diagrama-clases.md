[← Volver al README de PD3](../README.md)

# Diagrama de clases

Los diagramas están escritos en [Mermaid](https://mermaid.js.org/), por lo que GitHub los dibuja automáticamente al abrir este archivo.

## Punto de partida (ejemplo original, solo multiplicación)

```mermaid
classDiagram
    class ClcMVC {
        +main(String[] args)$
    }
    class ClcModel {
        -String INITIAL_VALUE$
        -BigDecimal m_total
        +reset()
        +multiplyBy(String operand)
        +setValue(String value)
        +getValue() String
    }
    class ClcView {
        -String INITIAL_VALUE$
        -JTextField m_userInputTf
        -JTextField m_totalTf
        -JButton m_multiplyBtn
        -JButton m_clearBtn
        +reset()
        +getUserInput() String
        +setTotal(String newTotal)
        +showError(String errMessage)
        +addMultiplyListener(ActionListener mal)
        +addClearListener(ActionListener cal)
    }
    class ClcController {
        -ClcModel m_model
        -ClcView m_view
    }
    class MultiplyListener {
        +actionPerformed(ActionEvent e)
    }
    class ClearListener {
        +actionPerformed(ActionEvent e)
    }
    class JFrame
    class ActionListener {
        <<interface>>
    }

    ClcView --|> JFrame
    MultiplyListener ..|> ActionListener
    ClearListener ..|> ActionListener
    ClcController *-- MultiplyListener : clase interna
    ClcController *-- ClearListener : clase interna
    ClcController --> ClcModel
    ClcController --> ClcView
    ClcView --> ClcModel
    ClcMVC ..> ClcModel : crea
    ClcMVC ..> ClcView : crea
    ClcMVC ..> ClcController : crea
```

## Diseño final (Strategy con `enum`, implementado)

```mermaid
classDiagram
    class Operation {
        <<enumeration>>
        ADD
        SUBTRACT
        MULTIPLY
        DIVIDE
        +getSymbol() String
        +apply(BigDecimal a, BigDecimal b) BigDecimal
    }
    class ClcModel {
        -BigDecimal m_total
        +reset()
        +apply(Operation op, String operand)
        +getValue() String
    }
    class ClcView {
        +addOperationListener(Operation op, ActionListener l)
        +addClearListener(ActionListener l)
        +getUserInput() String
        +setTotal(String)
        +showError(String)
    }
    class ClcController {
        -ClcModel m_model
        -ClcView m_view
    }
    class OperationListener {
        -Operation op
        +actionPerformed(ActionEvent e)
    }

    ClcModel ..> Operation
    ClcView ..> Operation
    ClcController *-- OperationListener
    OperationListener --> Operation
    ClcController --> ClcModel
    ClcController --> ClcView
```

Más detalle sobre por qué se eligió este diseño en [patrones.md](patrones.md).
