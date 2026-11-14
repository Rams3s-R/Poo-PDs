# PD3 – Calculadora con patrón MVC

Calculadora en Java Swing que parte de un total en `1` y le aplica suma, resta, multiplicación o división con el número que escribe el usuario. Está organizada con el patrón **Modelo-Vista-Controlador (MVC)** y las operaciones se definen con un `enum`, de modo que agregar una nueva no obliga a modificar la vista ni el controlador.

Práctica de POO basada en el ejemplo de la calculadora MVC visto en clase (sesión del 10/Nov).

## Video explicativo

**URL:** https://alumnosuady-my.sharepoint.com/:f:/g/personal/a25216429_alumnos_uady_mx/IgAhgOUEgFDIQ5WyM9-c_fQ6AS5GnEsDywxPYpI7EKA3R6I?e=JlouqZ

## Documentación

| Documento | Contenido |
|---|---|
| [Documentación de lo implementado](docs/documentacion.md) | Qué hace cada clase y cómo fluye una operación. |
| [Diagrama de clases](docs/diagrama-clases.md) | Diagramas del punto de partida y del diseño final. |
| [Estrategia y patrones](docs/patrones.md) | Cómo se amplían las operaciones, análisis del patrón Command y alternativas. |

## Estructura del proyecto

```
PD3/
├─ src/
│  ├─ ClcMVC.java          # Punto de entrada (main)
│  ├─ ClcModel.java        # Modelo: lógica y estado
│  ├─ ClcView.java         # Vista: ventana Swing
│  ├─ ClcController.java   # Controlador: conecta vista y modelo
│  └─ Operation.java       # Enum con las operaciones (+, -, x, /)
├─ docs/
│  ├─ documentacion.md
│  ├─ diagrama-clases.md
│  └─ patrones.md
└─ README.md
```

## Cómo ejecutarlo

Requiere JDK 8 o superior.

```bash
cd PD3
mkdir -p bin
javac -d bin src/*.java
java -cp bin ClcMVC
```

También puede ejecutarse desde VS Code abriendo `src/ClcMVC.java` y pulsando **Run**.

## Autor

Rams3s-R
