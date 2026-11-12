import java.awt.event.*;

public class ClcController {
    // El controlador recibe al modelo y a la vista
    private ClcModel m_model;
    private ClcView  m_view;

    ClcController(ClcModel model, ClcView view) {
        m_model = model;
        m_view  = view;

        // relaciona cada botón con su acción
        view.addMultiplyListener(new MultiplyListener());
        view.addClearListener(new ClearListener());
    }

    // Se ejecuta al presionar"Multiply"
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = "";
            try {
                userInput = m_view.getUserInput().trim(); // 1. Lee lo que esta escrito
                m_model.multiplyBy(userInput);            // 2. El modelo lo multiplica
                m_view.setTotal(m_model.getValue());      // 3. La vista muestra el resultado
            } catch (NumberFormatException nfex) {
                // Si no es un número válido, muestra error
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }

    // Se ejecuta al presionar el boton "Clear"
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }
}