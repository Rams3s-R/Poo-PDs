package filey.modelo;

public class StandGastronomico extends Stand {
    private static final double CARGO_SERVICIOS = 2500; // agua, gas y drenaje

    public StandGastronomico(String codigo, double largo, double ancho) {
        super(codigo, largo, ancho, Zona.GASTRONOMICA);
    }

    @Override
    public double calcularPrecio() {
        return calcularMetrosCuadrados() * PRECIO_BASE_M2 + CARGO_SERVICIOS;
    }

    @Override
    public String getTipo() { return "Gastronómico"; }
}
