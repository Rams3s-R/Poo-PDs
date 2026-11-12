import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.EnumMap;
import java.util.Map;

class ClcView extends JFrame {
    private static final String INITIAL_VALUE = "1";

    // Componentes de la ventana
    private JTextField m_userInputTf = new JTextField(8);
    private JTextField m_totalTf     = new JTextField(20);
    private JButton    m_clearBtn    = new JButton("Clear");

    // Un botón por cada operación, creados a partir del enum Operation
    private Map<Operation, JButton> m_operationBtns =
            new EnumMap<Operation, JButton>(Operation.class);

    private ClcModel m_model;

    ClcView(ClcModel model) {
        m_model = model;
        m_model.setValue(INITIAL_VALUE);

        m_totalTf.setText(m_model.getValue());
        m_totalTf.setEditable(false); // El total no se puede escribir a mano

        // Fila de operaciones: se genera recorriendo el enum
        JPanel opsPanel = new JPanel(new FlowLayout());
        for (Operation op : Operation.values()) {
            JButton btn = new JButton(op.getSymbol());
            m_operationBtns.put(op, btn);
            opsPanel.add(btn);
        }

        // Fila de entrada
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Input"));
        inputPanel.add(m_userInputTf);

        // Fila de total
        JPanel totalPanel = new JPanel(new FlowLayout());
        totalPanel.add(new JLabel("Total"));
        totalPanel.add(m_totalTf);
        totalPanel.add(m_clearBtn);

        // Se acomodan las filas en un panel vertical
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(inputPanel);
        content.add(opsPanel);
        content.add(totalPanel);

        this.setContentPane(content);
        this.pack(); // Ajusta el tamaño de la ventana

        this.setTitle("Simple Clc - MVC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar = terminar programa
    }

    // Los siguientes métodos los usa el controlador
    void reset() {
        m_totalTf.setText(INITIAL_VALUE);
    }

    String getUserInput() {
        return m_userInputTf.getText();
    }

    void setTotal(String newTotal) {
        m_totalTf.setText(newTotal);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    // Permiten que el controlador "escuche" los botones
    void addOperationListener(Operation op, ActionListener al) {
        m_operationBtns.get(op).addActionListener(al);
    }

    void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
}
