import javax.swing.*;

public class ClcMVC {
    public static void main(String[] args) {
        // Se crea una sola copia de cada parte y se conectan entre sí
        ClcModel     model      = new ClcModel();
        ClcView      view       = new ClcView(model);
        ClcController controller = new ClcController(model, view);

        view.setVisible(true); // Muestra la ventana
    }
}