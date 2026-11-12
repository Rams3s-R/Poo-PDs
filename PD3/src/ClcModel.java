import java.math.BigDecimal;

public class ClcModel {
    private static final String INITIAL_VALUE = "1";

    // BigDecimal permite enteros y decimales de cualquier tamaño
    private BigDecimal m_total;

    ClcModel() {
        reset();
    }

    // Regresa el total al valor inicial
    public void reset() {
        m_total = new BigDecimal(INITIAL_VALUE);
    }

    // Convierte el texto a número y aplica la operación al total.
    // Si el texto no es válido lanza NumberFormatException;
    // si se divide entre cero lanza ArithmeticException.
    // En ambos casos el total no cambia.
    public void apply(Operation op, String operand) {
        BigDecimal number = new BigDecimal(operand);
        m_total = op.apply(m_total, number);
    }

    public void setValue(String value) {
        m_total = new BigDecimal(value);
    }

    // toPlainString evita que salga en notación científica
    public String getValue() {
        return m_total.toPlainString();
    }
}
