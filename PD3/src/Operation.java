import java.math.BigDecimal;
import java.math.MathContext;

// Cada operación de la calculadora: su símbolo y cómo se calcula.
// Para agregar una operación nueva basta con añadir una constante aquí.
public enum Operation {
    ADD("+") {
        public BigDecimal apply(BigDecimal a, BigDecimal b) {
            return a.add(b);
        }
    },
    SUBTRACT("-") {
        public BigDecimal apply(BigDecimal a, BigDecimal b) {
            return a.subtract(b);
        }
    },
    MULTIPLY("x") {
        public BigDecimal apply(BigDecimal a, BigDecimal b) {
            return a.multiply(b);
        }
    },
    DIVIDE("/") {
        public BigDecimal apply(BigDecimal a, BigDecimal b) {
            // Lanza ArithmeticException si b es cero
            return a.divide(b, MathContext.DECIMAL64);
        }
    };

    private final String m_symbol;

    Operation(String symbol) {
        m_symbol = symbol;
    }

    public String getSymbol() {
        return m_symbol;
    }

    // Cada constante define cómo calcula
    public abstract BigDecimal apply(BigDecimal a, BigDecimal b);
}
