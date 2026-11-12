import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ClcView extends JFrame {
    private static final String INITIAL_VALUE = "1";

    // los componentes de la ventana
    private JTextField m_userInputTf = new JTextField(5);
    private JTextField m_totalTf     = new JTextField(20);
    private JButton    m_multiplyBtn = new JButton("Multiply");
    private JButton    m_clearBtn    = new JButton("Clear");

    private ClcModel m_model;

    ClcView(ClcModel model) {
        m_model = model;
        m_model.setValue(INITIAL_VALUE);

        m_totalTf.setText(m_model.getValue());
        m_totalTf.setEditable(false); // El total no puede ser escrito a mano

        // Se distribuyen los componentes en el panel
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Input"));
        content.add(m_userInputTf);
        content.add(m_multiplyBtn);
        content.add(new JLabel("Total"));
        content.add(m_totalTf);
        content.add(m_clearBtn);

        this.setContentPane(content);
        this.pack(); // Ajusta el tamaño de la ventana

        this.setTitle("Simple Clc - MVC");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }


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

    void addMultiplyListener(ActionListener mal) {
        m_multiplyBtn.addActionListener(mal);
    }

    void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
}