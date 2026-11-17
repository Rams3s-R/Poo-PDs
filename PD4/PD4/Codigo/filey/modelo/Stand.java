package filey.modelo;

/** Abstracción de un stand de la feria. Cada tipo calcula su precio de forma distinta. */
public abstract class Stand {
    protected static final double PRECIO_BASE_M2 = 1500;

    private final String codigo;
    private final double largo;
    private final double ancho;
    private final Zona zona;
    private EstadoStand estado;

    protected Stand(String codigo, double largo, double ancho, Zona zona, EstadoStand estado) {
        if (largo <= 0 || ancho <= 0) {
            throw new IllegalArgumentException("Las medidas deben ser mayores a cero.");
        }
        this.codigo = codigo;
        this.largo = largo;
        this.ancho = ancho;
        this.zona = zona;
        this.estado = estado;
    }

    public abstract double calcularPrecio();
    public abstract String getTipo();

    public double calcularMetrosCuadrados() { return largo * ancho; }
    public boolean estaDisponible() { return estado == EstadoStand.DISPONIBLE; }

    public void reservar() {
        if (!estaDisponible()) throw new IllegalStateException("El stand " + codigo + " no está disponible.");
        estado = EstadoStand.RESERVADO;
    }
    public void ocupar() {
        if (estado != EstadoStand.RESERVADO) throw new IllegalStateException("Solo un stand reservado puede ocuparse.");
        estado = EstadoStand.OCUPADO;
    }
    public void liberar() { estado = EstadoStand.DISPONIBLE; }
    public void ponerEnMantenimiento() {
        if (estado == EstadoStand.OCUPADO) throw new IllegalStateException("No se puede dar mantenimiento a un stand ocupado.");
        estado = EstadoStand.MANTENIMIENTO;
    }

    public String getCodigo() { return codigo; }
    public double getLargo() { return largo; }
    public double getAncho() { return ancho; }
    public Zona getZona() { return zona; }
    public EstadoStand getEstado() { return estado; }

    @Override
    public String toString() {
        return String.format("%-4s | %-13s | %-17s | %5.1f m2 | $%9.2f | %s",
                codigo, getTipo(), zona.getNombre(), calcularMetrosCuadrados(), calcularPrecio(), estado);
    }
}
