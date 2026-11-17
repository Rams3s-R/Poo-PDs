package filey.modelo;

public class StandGastronomico extends Stand {
    private static final double CARGO_SERVICIOS = 2500; // agua, gas y drenaje

    public StandGastronomico(String codigo, double largo, double ancho) {
        this(codigo, largo, ancho, EstadoStand.DISPONIBLE);
    }

    public StandGastronomico(String codigo, double largo, double ancho, EstadoStand estado) {
        super(codigo, largo, ancho, Zona.GASTRONOMICA, estado);
    }

    @Override
    public double calcularPrecio() { return calcularMetrosCuadrados() * PRECIO_BASE_M2 + CARGO_SERVICIOS; }

    @Override
    public String getTipo() { return "Gastronómico"; }
}
