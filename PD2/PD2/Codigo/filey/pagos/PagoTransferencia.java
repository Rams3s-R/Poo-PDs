package filey.pagos;

public class PagoTransferencia implements MetodoPago {
    private final String referencia;

    public PagoTransferencia(String referencia) { this.referencia = referencia; }

    @Override
    public boolean procesar(double monto) {
        System.out.printf("Transferencia simulada de $%.2f, referencia %s%n", monto, referencia);
        return monto > 0 && referencia != null && !referencia.isBlank();
    }

    @Override
    public String getNombre() { return "Transferencia"; }
}
