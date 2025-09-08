package Personas.presentation.Prescripcion;

import Personas.logic.Medicamento;
import Personas.presentation.Medicamentos.Controller;
import Personas.presentation.Medicamentos.Model;
import Personas.presentation.Medicamentos.TableModel;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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
    Personas.presentation.Medicamentos.Controller controller;
    Personas.presentation.Medicamentos.Model model;

    public View() {
        // BOTÓN GUARDAR
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    Medicamento m = take();
                    try {
                        controller.save(m);
                        JOptionPane.showMessageDialog(panelPrincipal, "Medicamento registrado", "Info", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panelPrincipal, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        descartarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.deleteMedicamento();
                    JOptionPane.showMessageDialog(panelPrincipal, "Medicamento eliminado", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panelPrincipal, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // BOTÓN LIMPIAR
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.clear();
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

    // ==== GETTERS & SETTERS ====
    public JPanel getPanel() {
        return panelPrincipal;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Personas.presentation.Medicamentos.Model model) {
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
}
