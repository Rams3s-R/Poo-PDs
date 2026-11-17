package filey.modelo;

public class StandComercial extends Stand {
    private static final double RECARGO_UBICACION = 0.15;

    public StandComercial(String codigo, double largo, double ancho) {
        super(codigo, largo, ancho, Zona.COMERCIAL);
    }

    @Override
    public double calcularPrecio() {
        return calcularMetrosCuadrados() * PRECIO_BASE_M2 * (1 + RECARGO_UBICACION);
    }

    @Override
    public String getTipo() { return "Comercial"; }
}
