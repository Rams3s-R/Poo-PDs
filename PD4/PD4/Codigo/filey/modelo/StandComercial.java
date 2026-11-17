package filey.modelo;

public class StandComercial extends Stand {
    private static final double RECARGO_UBICACION = 0.15;

    public StandComercial(String codigo, double largo, double ancho) {
        this(codigo, largo, ancho, EstadoStand.DISPONIBLE);
    }

    public StandComercial(String codigo, double largo, double ancho, EstadoStand estado) {
        super(codigo, largo, ancho, Zona.COMERCIAL, estado);
    }

    @Override
    public double calcularPrecio() { return calcularMetrosCuadrados() * PRECIO_BASE_M2 * (1 + RECARGO_UBICACION); }

    @Override
    public String getTipo() { return "Comercial"; }
}
