package Personas.presentation.Prescripcion;

import Personas.logic.Prescripcion;
import Personas.presentation.Prescripcion.medicamento.*;
import Personas.presentation.Prescripcion.paciente.*;

import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View extends JDialog implements PropertyChangeListener {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton buttonMedicamentos;
    private JButton buttonPaciente;
    private JTable tableMedicamentos;
    private JPanel panelPrincipal;
    private JButton buscarPacienteButton;
    private JButton agregarMedicamentoButton;
    private JComboBox comboBox1;
    private JLabel nombrePacienteLabel;
    private JButton guardarButton;
    private JButton detallesButton;
    private JButton limpiarButton;
    private JButton descartarButton;
    private JTable tablePaciente;

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

        buttonMedicamentos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doConseguirMeds();
            }
        });

        buttonPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doConseguirPaciente();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
                                               public void actionPerformed(ActionEvent e) {
                                                   onCancel();
                                               }
                                           }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    private void onOK() {
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    private void doConseguirMeds() {
        Personas.presentation.Prescripcion.medicamento.View medsView =
                new Personas.presentation.Prescripcion.medicamento.View();
        medsView.setController(controller); // mismo controller
        medsView.setModel(model);           // mismo model
        medsView.setTitle("Medicamentos");
        medsView.pack();
        medsView.setLocationRelativeTo(null);
        medsView.setVisible(true);
    }

    private void doConseguirPaciente() {
        Personas.presentation.Prescripcion.paciente.View pacienteView =
                new Personas.presentation.Prescripcion.paciente.View();
        pacienteView.setController(controller); // mismo controller
        pacienteView.setModel(model);           // mismo model
        pacienteView.setTitle("Pacientes");
        pacienteView.pack();
        pacienteView.setLocationRelativeTo(null);
        pacienteView.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // refrescar tablas si cambian datos
        if (evt.getPropertyName().equals(Model.CURRENT)) {
            Prescripcion current = model.getCurrent();
            tableMedicamentos.updateUI();
            tablePaciente.updateUI();
        }
    }
}
