package filey.pagos;

public interface MetodoPago {
    boolean procesar(double monto);

    String getNombre();
}
