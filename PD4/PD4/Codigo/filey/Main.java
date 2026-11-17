package filey;

import filey.controlador.ControladorFiley;
import filey.vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        new ControladorFiley(new VistaConsola()).iniciar();
    }
}
