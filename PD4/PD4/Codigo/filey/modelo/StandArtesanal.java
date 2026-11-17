package filey.modelo;

public class StandArtesanal extends Stand {
    private static final double DESCUENTO_ARTESANO = 0.20;

    public StandArtesanal(String codigo, double largo, double ancho) {
        this(codigo, largo, ancho, EstadoStand.DISPONIBLE);
    }

    public StandArtesanal(String codigo, double largo, double ancho, EstadoStand estado) {
        super(codigo, largo, ancho, Zona.ARTESANAL, estado);
    }

    @Override
    public double calcularPrecio() { return calcularMetrosCuadrados() * PRECIO_BASE_M2 * (1 - DESCUENTO_ARTESANO); }

    @Override
    public String getTipo() { return "Artesanal"; }
}
