# PD2: Stands de la Filey

- `Requisitos/`: requisitos funcionales, no funcionales y reglas de negocio
- `DiagramaClases/`: diagrama de clases (Mermaid)
- `Codigo/filey/`: código fuente en Java (paquetes `modelo`, `pagos`, `servicios` y `Main.java`)

## Ejecutar
Desde la carpeta `Codigo`:
```
javac -d out $(find . -name "*.java")
java -cp out filey.Main
```
