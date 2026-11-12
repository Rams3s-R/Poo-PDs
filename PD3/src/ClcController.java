import java.awt.event.*;

public class ClcController {
    // El controlador conoce al modelo y a la vista
    private ClcModel m_model;
    private ClcView  m_view;

    ClcController(ClcModel model, ClcView view) {
        m_model = model;
        m_view  = view;

        // Conecta cada botón de operación con su acción
        for (Operation op : Operation.values()) {
            view.addOperationListener(op, new OperationListener(op));
        }
        view.addClearListener(new ClearListener());
    }

    // Se ejecuta al presionar cualquier botón de operación
    class OperationListener implements ActionListener {
        private Operation m_op;

        OperationListener(Operation op) {
            m_op = op;
        }

        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput().trim(); // 1. Lee lo escrito
                m_model.apply(m_op, userInput);           // 2. El modelo calcula
                m_view.setTotal(m_model.getValue());      // 3. La vista muestra el total
            } catch (NumberFormatException nfex) {
                // Si no es un número válido, muestra error
                m_view.showError("Bad input: '" + userInput + "'");
            } catch (ArithmeticException aex) {
                // División entre cero
                m_view.showError("No se puede dividir entre cero");
            }
        }
    }

    // Se ejecuta al presionar "Clear"
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }
}
