package Personas.presentation.Prescripcion;

import Personas.logic.Prescripcion;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class View implements PropertyChangeListener {
    private JButton buscarPacienteButton;
    private JButton agregarMedicamentoButton;
    private JComboBox comboBox1;
    private JButton guardarButton;
    private JTable tableMedicamentos;
    private JLabel nombrePacienteLabel;
    private JButton limpiarButton;
    private JButton descartarButton;
    private JButton detallesButton;
    private JPanel panelPrincipal;

    Controller controller;
    Model model;

    public View() {
        // BOTÓN GUARDAR
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Prescripcion m = model.getCurrent();
                try {
                    controller.save(m);
                    JOptionPane.showMessageDialog(panelPrincipal, "Prescripcion registrada", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panelPrincipal, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buscarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doConseguirPaciente();
            }
        });

        agregarMedicamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doConseguirMeds();
            }
        });

        descartarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    reset();
                    JOptionPane.showMessageDialog(panelPrincipal, "Prescipcion eliminada", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panelPrincipal, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // BOTÓN LIMPIAR
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.clear();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panelPrincipal, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        detallesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableMedicamentos.getSelectedRow();
                if (row != -1) {
                    controller.edit(row);
                } else {
                    JOptionPane.showMessageDialog(panelPrincipal, "Seleccione un medicamento", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // CLICK EN TABLA
        tableMedicamentos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tableMedicamentos.getSelectedRow();
                if (row != -1) {
                    controller.edit(row);
                }
            }
        });
    }

    public void reset() throws Exception {
        controller.clear();
    }

    // ==== GETTERS & SETTERS ====
    public JPanel getPanel() {
        return panelPrincipal;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void setModel(Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }

    // ==== BINDING ENTRE VISTA Y MODELO ====
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Personas.presentation.Medicamentos.Model.LIST:
                int[] cols = {Personas.presentation.Medicamentos.TableModel.CODIGO, Personas.presentation.Medicamentos.TableModel.NOMBRE, Personas.presentation.Medicamentos.TableModel.DESCRIPCION};
                tableMedicamentos.setModel(new TableModel(cols, model.getList()));
                tableMedicamentos.setRowHeight(30);
                TableColumnModel columnModel = tableMedicamentos.getColumnModel();
                columnModel.getColumn(0).setPreferredWidth(150);
                columnModel.getColumn(1).setPreferredWidth(150);
                columnModel.getColumn(2).setPreferredWidth(200);
                break;

            case Personas.presentation.Medicamentos.Model.CURRENT:
                break;

            case Model.FILTER:
                break;
        }

        this.panelPrincipal.revalidate();
    }

    private static void doConseguirMeds(){
        Personas.presentation.Prescripcion.medicamento.View medsView = new Personas.presentation.Prescripcion.medicamento.View();
        medsView.setTitle("Medicamentos");
        medsView.pack();
        medsView.setLocationRelativeTo(null);
        Personas.presentation.Prescripcion.Model loginModel = new Personas.presentation.Prescripcion.Model();
        Personas.presentation.Prescripcion.Controller loginController = new Personas.presentation.Prescripcion.Controller(medsView, loginModel);
        medsView.setVisible(true);
    }
    private static void doConseguirPaciente(){
        Personas.presentation.Prescripcion.paciente.View pacienteView = new Personas.presentation.Prescripcion.paciente.View();
        pacienteView.setTitle("Pacientes");
        pacienteView.pack();
        pacienteView.setLocationRelativeTo(null);
        Personas.presentation.Prescripcion.Model loginModel = new Personas.presentation.Prescripcion.Model();
        Personas.presentation.Prescripcion.Controller loginController = new Personas.presentation.Prescripcion.Controller(pacienteView, loginModel);
        pacienteView.setVisible(true);
    }
}
