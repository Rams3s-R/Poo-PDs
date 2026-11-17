package filey.servicios;

import filey.modelo.*;
import filey.pagos.MetodoPago;
import java.util.ArrayList;
import java.util.List;

public class ServicioReservas {
    private final GestorStands gestor;
    private final List<Reserva> reservas = new ArrayList<>();

    public ServicioReservas(GestorStands gestor) { this.gestor = gestor; }

    public Reserva reservar(Expositor expositor, String codigoStand) {
        Stand stand = gestor.buscarPorCodigo(codigoStand);
        stand.reservar();
        Reserva reserva = new Reserva(stand, expositor);
        reservas.add(reserva);
        return reserva;
    }

    public void pagarAnticipo(int idReserva, MetodoPago metodo) {
        Reserva reserva = buscarReserva(idReserva);
        if (!metodo.procesar(reserva.calcularAnticipo())) {
            throw new IllegalStateException("El pago con " + metodo.getNombre() + " fue rechazado.");
        }
        reserva.confirmar();
        reserva.getStand().ocupar();
    }

    public void cancelar(int idReserva) {
        Reserva reserva = buscarReserva(idReserva);
        reserva.cancelar();
        reserva.getStand().liberar();
    }

    public Reserva buscarReserva(int id) {
        for (Reserva r : reservas) {
            if (r.getId() == id) return r;
        }
        throw new IllegalArgumentException("No existe la reserva " + id);
    }
}
