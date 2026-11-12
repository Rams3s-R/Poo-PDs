import java.math.BigDecimal;

public class ClcModel {
    private static final String INITIAL_VALUE = "1";

    // BigDecimal permite introducir enteros y decimales 
    private BigDecimal m_total;

    ClcModel() {
        reset();
    }

    // Regresa total al valor inicial
    public void reset() {
        m_total = new BigDecimal(INITIAL_VALUE);
    }

    // Convierte el texto a número y lo multiplica por el total
    public void multiplyBy(String operand) {
        m_total = m_total.multiply(new BigDecimal(operand));
    }

    public void setValue(String value) {
        m_total = new BigDecimal(value);
    }

    // toPlainString evita que el resultado se muestre en notación científica
    public String getValue() {
        return m_total.toPlainString();
    }
}