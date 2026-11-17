package filey.pagos;

public class PagoTarjeta implements MetodoPago {
    private final String ultimosDigitos;

    public PagoTarjeta(String ultimosDigitos) { this.ultimosDigitos = ultimosDigitos; }

    @Override
    public boolean procesar(double monto) {
        System.out.printf("Cobro simulado de $%.2f a tarjeta terminación %s%n", monto, ultimosDigitos);
        return monto > 0;
    }

    @Override
    public String getNombre() { return "Tarjeta"; }
}
