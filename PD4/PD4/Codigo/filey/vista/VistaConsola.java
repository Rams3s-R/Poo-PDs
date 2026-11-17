package filey.vista;

import filey.modelo.*;
import java.util.List;

/** Capa de vista: solo imprime, no conoce la BD. */
public class VistaConsola {
    public void mostrarMensaje(String mensaje) { System.out.println(mensaje); }

    public void mostrarError(String mensaje) { System.err.println("ERROR: " + mensaje); }

    public void mostrarStands(List<Stand> stands) {
        System.out.println("\n=== STANDS ===");
        stands.forEach(System.out::println);
    }

    public void mostrarEditoriales(List<Editorial> editoriales) {
        System.out.println("\n=== EDITORIALES ===");
        editoriales.forEach(System.out::println);
    }

    public void mostrarReservas(List<Reserva> reservas) {
        System.out.println("\n=== RESERVAS ===");
        reservas.forEach(System.out::println);
    }
}
