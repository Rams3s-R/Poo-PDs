package filey.modelo;

public class StandArtesanal extends Stand {
    private static final double DESCUENTO_ARTESANO = 0.20;

    public StandArtesanal(String codigo, double largo, double ancho) {
        super(codigo, largo, ancho, Zona.ARTESANAL);
    }

    @Override
    public double calcularPrecio() {
        return calcularMetrosCuadrados() * PRECIO_BASE_M2 * (1 - DESCUENTO_ARTESANO);
    }

    @Override
    public String getTipo() { return "Artesanal"; }
}
