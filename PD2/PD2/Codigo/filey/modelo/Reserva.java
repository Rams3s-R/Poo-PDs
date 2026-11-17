package filey.modelo;

import java.time.LocalDate;

public class Reserva {
    private static final double PORCENTAJE_ANTICIPO = 0.30;
    private static int contador = 1;

    private final int id;
    private final Stand stand;
    private final Expositor expositor;
    private final LocalDate fecha;
    private EstadoReserva estado;

    public Reserva(Stand stand, Expositor expositor) {
        this.id = contador++;
        this.stand = stand;
        this.expositor = expositor;
        this.fecha = LocalDate.now();
        this.estado = EstadoReserva.PENDIENTE;
    }

    public double calcularAnticipo() { return stand.calcularPrecio() * PORCENTAJE_ANTICIPO; }

    public double calcularSaldo() { return stand.calcularPrecio() - calcularAnticipo(); }

    public void confirmar() {
        if (estado != EstadoReserva.PENDIENTE) {
            throw new IllegalStateException("La reserva no está pendiente.");
        }
        estado = EstadoReserva.CONFIRMADA;
    }

    public void cancelar() {
        if (estado == EstadoReserva.CANCELADA) {
            throw new IllegalStateException("La reserva ya está cancelada.");
        }
        estado = EstadoReserva.CANCELADA;
    }

    public int getId() { return id; }
    public Stand getStand() { return stand; }
    public Expositor getExpositor() { return expositor; }
    public LocalDate getFecha() { return fecha; }
    public EstadoReserva getEstado() { return estado; }
}
