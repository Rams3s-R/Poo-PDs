public class ClcMVC {
    public static void main(String[] args) {
        // Se crea una sola copia de cada parte y se conectan entre sí
        ClcModel      model      = new ClcModel();
        ClcView       view       = new ClcView(model);
        new ClcController(model, view);

        view.setVisible(true); // Muestra la ventana
    }
}
