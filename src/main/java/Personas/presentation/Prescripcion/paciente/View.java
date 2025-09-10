package Personas.presentation.Prescripcion.paciente;

import Personas.logic.Paciente;
import Personas.logic.Service;
import Personas.presentation.Prescripcion.Controller;
import Personas.presentation.Prescripcion.Model;

import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class View extends JDialog implements PropertyChangeListener {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textFieldBusqueda;
    private JTable table1;

    Controller controller;
    Model model;

    public View() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public void propertyChange(java.beans.PropertyChangeEvent evt) {
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    private void onOK() {
        String text = textFieldBusqueda.getText();
        Paciente paciente = new Paciente();
        try {
            if (comboBox1.getSelectedIndex() == 1) {
                paciente.setId(text);
                if (Service.instance().readPaciente(paciente) != null) {
                    paciente = Service.instance().readPaciente(paciente);
                    controller.addPaciente(paciente);
                    model.firePropertyChange(Model.CURRENT); // refrescar vista
                    dispose();
                }
            } else if (comboBox1.getSelectedIndex() == 2) {
                paciente.setName(text);
                if (Service.instance().readPacienteNombre(paciente) != null) {
                    paciente = Service.instance().readPacienteNombre(paciente);
                    controller.addPaciente(paciente);
                    model.firePropertyChange(Model.CURRENT); // refrescar vista
                    dispose();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Paciente no existe");
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        View dialog = new View();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
