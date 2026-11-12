# Guion del video (máx. 5 min)

## 0:00 – 0:30 · Introducción (mostrar el repo en GitHub)
"Hola, soy Ramsés. En esta práctica PD3 trabajé con una calculadora hecha en Java Swing usando el patrón MVC. En el repositorio están el código, la documentación, el diagrama de clases y este video. Voy a explicar cómo está organizada, cómo la ampliaría con más operaciones y si conviene usar el patrón Command."

## 0:30 – 1:20 · El código MVC (mostrar los 4 archivos en VS Code)
"MVC separa la aplicación en tres partes. El modelo, ClcModel, guarda el total en un BigDecimal y aplica las operaciones, pero no sabe nada de ventanas. La vista, ClcView, es la ventana Swing: tiene el campo de entrada, el total y los botones, pero no hace cálculos. El controlador, ClcController, conecta ambos: cuando se presiona un botón de operación, lee el texto de la vista, le pide al modelo que aplique esa operación y luego le dice a la vista que muestre el nuevo total. ClcMVC solo crea las tres piezas y abre la ventana."

## 1:20 – 1:50 · Demostración (ejecutar la app)
"Aquí la ejecuto. El total empieza en 1. Con 5 y el botón más, el total es 6; con 2 y menos, 4; con 3 y por, 12; con 4 y entre, 3. Si divido entre cero o escribo una letra, aparece un mensaje de error. Y Clear regresa el total a 1."

## 1:50 – 2:50 · Estrategia para más operaciones (mostrar docs/diagrama-clases.md)
"Para agregar suma, resta y división sin romper MVC, creé un enum llamado Operation. Cada valor, como ADD o SUBTRACT, trae su símbolo y la función que calcula. En el modelo, cambié multiplyBy por un método apply que recibe la operación y el número. En la vista, genero los botones recorriendo Operation.values(), así que agregar una operación no requiere más código de interfaz. Y en el controlador uso un solo OperationListener que recibe la operación. También manejo la división entre cero mostrando un error. La vista sigue sin conocer la lógica y el modelo sigue sin conocer Swing."

## 2:50 – 3:50 · Patrón Command (mostrar la tabla de docs/patrones.md)
"El patrón Command convierte cada acción en un objeto, con clases como AddCommand o SubtractCommand. Sus ventajas son que cada operación vive aislada, se agregan sin tocar el controlador y permite deshacer y llevar un historial. Sus desventajas es que para operaciones de una sola línea termino con muchas clases casi vacías, más archivos y más complejidad sin necesidad."

## 3:50 – 4:30 · Conclusión y otros patrones
"Mi conclusión es que aquí no conviene Command, porque cada operación es solo una función de dos números. Prefiero el enum, que es una variante del patrón Strategy: logra lo mismo con menos código. Command sí sería mejor si el profesor pidiera deshacer o historial. Otro patrón que se podría considerar es Observer, para que el modelo avise a la vista cuando cambia el total, en lugar de que el controlador lo haga manualmente."

## 4:30 – 4:50 · Cierre
"Con esto cubro la documentación, el código y el diagrama que están en el repositorio. Gracias por ver el video."

## Consejos
- Grábalo con Xbox Game Bar (`Win + G`), Teams u OBS.
- Súbelo a YouTube como **no listado** o a OneDrive con enlace público, y verifica que abra en ventana de incógnito.
- Pega el URL al inicio de `PD3/README.md`.
