package filey.modelo;

public enum Zona {
    GASTRONOMICA("Zona gastronómica"),
    ARTESANAL("Zona artesanal"),
    COMERCIAL("Zona comercial");

    private final String nombre;

    Zona(String nombre) { this.nombre = nombre; }

    public String getNombre() { return nombre; }
}
