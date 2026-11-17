package filey;

import filey.modelo.*;
import filey.pagos.*;
import filey.servicios.*;

public class Main {
    public static void main(String[] args) {
        GestorStands gestor = new GestorStands();
        gestor.agregar(new StandGastronomico("G1", 3, 3));
        gestor.agregar(new StandGastronomico("G2", 4, 3));
        gestor.agregar(new StandArtesanal("A1", 3, 2));
        gestor.agregar(new StandComercial("C1", 4, 4));
        gestor.agregar(new StandComercial("C2", 2, 2));
        gestor.buscarPorCodigo("C2").ponerEnMantenimiento();

        ServicioReservas servicio = new ServicioReservas(gestor);
        Expositor expositor = new Expositor("Ana Pech", "ana@correo.com", "9991234567", "Comida yucateca");

        System.out.println("=== MAPA DE STANDS ===");
        gestor.verMapa().forEach(System.out::println);

        System.out.println("\n=== RESERVA ===");
        Reserva reserva = servicio.reservar(expositor, "G1");
        System.out.printf("Reserva #%d creada. Anticipo: $%.2f | Saldo: $%.2f%n",
                reserva.getId(), reserva.calcularAnticipo(), reserva.calcularSaldo());
        servicio.pagarAnticipo(reserva.getId(), new PagoTarjeta("4417"));
        System.out.println("Estado reserva: " + reserva.getEstado()
                + " | Estado stand G1: " + reserva.getStand().getEstado());

        System.out.println("\n=== ERROR CONTROLADO ===");
        try {
            servicio.reservar(expositor, "G1");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== CANCELACIÓN ===");
        Reserva otra = servicio.reservar(expositor, "A1");
        servicio.cancelar(otra.getId());
        System.out.println("Stand A1 tras cancelar: " + gestor.buscarPorCodigo("A1").getEstado());

        System.out.println("\n=== DISPONIBLES ===");
        gestor.listarDisponibles().forEach(System.out::println);
    }
}
