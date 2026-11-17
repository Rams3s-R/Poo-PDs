package filey.modelo;

import java.time.LocalDate;

public class Reserva {
    private static final double PORCENTAJE_ANTICIPO = 0.30;

    private final int id;
    private final Stand stand;
    private final Editorial editorial;
    private final LocalDate fecha;
    private EstadoReserva estado;

    public Reserva(int id, Stand stand, Editorial editorial, LocalDate fecha, EstadoReserva estado) {
        this.id = id;
        this.stand = stand;
        this.editorial = editorial;
        this.fecha = fecha;
        this.estado = estado;
    }

    public double calcularAnticipo() { return stand.calcularPrecio() * PORCENTAJE_ANTICIPO; }
    public double calcularSaldo() { return stand.calcularPrecio() - calcularAnticipo(); }

    public int getId() { return id; }
    public Stand getStand() { return stand; }
    public Editorial getEditorial() { return editorial; }
    public LocalDate getFecha() { return fecha; }
    public EstadoReserva getEstado() { return estado; }

    @Override
    public String toString() {
        return String.format("%-3d | %-4s | %-24s | %s | %-10s | anticipo $%.2f",
                id, stand.getCodigo(), editorial.getNombre(), fecha, estado, calcularAnticipo());
    }
}
