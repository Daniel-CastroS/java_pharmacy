package Personas.presentation.Medico;
import Personas.Application;
import Personas.logic.Medico;
import Personas.presentation.AbstractTableModel;
import javax.swing.*;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;

public class View implements PropertyChangeListener {
    private JPanel panel1;
    private JButton guardarButton;
    private JButton borrarButton;
    private JButton limpiarButton;
    private JTextField textFieldId;
    private JTextField textFieldNombre;
    private JTextField textFieldEspecialidad;
    private JTextField textField1;
    private JButton buscarButton;
    private JButton reporteButton;
    private JTable table1;

    Controller controller;
    Model model;

    public View() {

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Medico filter = new Medico();
                    filter.setId(textField1.getText());
                    filter.setName(textField1.getText());
                    controller.search(filter);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // BOTONES
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    Medico m = take();
                    try {
                        controller.save(m);
                        JOptionPane.showMessageDialog(panel1, "Médico registrado", "Info", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });



        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.deleteMedico();
                    JOptionPane.showMessageDialog(panel1, "Médico eliminado", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.clear();
            }
        });


    }



    public JPanel getPanel() {
        return panel1;
    }


    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addPropertyChangeListener(this);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case Model.LIST:
                int[] cols = {TableModel.ID, TableModel.NOMBRE, TableModel.ESPECIALIDAD};
                table1.setModel(new TableModel(cols, model.getList()));
                table1.setRowHeight(30);
                TableColumnModel columnModel = table1.getColumnModel();
                columnModel.getColumn(0).setPreferredWidth(150);
                columnModel.getColumn(1).setPreferredWidth(150);
                columnModel.getColumn(2).setPreferredWidth(200);
                break;

            case Model.CURRENT:
                Medico current = model.getCurrent();
                textFieldId.setText(current.getId());
                textFieldNombre.setText(current.getName());
                textFieldEspecialidad.setText(current.getEspecialidad());

                // habilitar/deshabilitar según modo
                if (model.getMode() == Personas.Application.MODE_EDIT) {
                    textFieldId.setEnabled(false);
                    borrarButton.setEnabled(true);

                } else {
                    textFieldId.setEnabled(true);
                    borrarButton.setEnabled(false);
                }

                // reset visual
                resetField(textFieldId);
                resetField(textFieldNombre);
                resetField(textFieldEspecialidad);
                break;

            case Model.FILTER:
                textField1.setText(model.getFilter().getId());
                break;
        }

        this.panel1.revalidate();
    }









    private Medico take() {
        Medico m = new Medico();
        m.setId(textFieldId.getText());
        m.setName(textFieldNombre.getText());
        m.setEspecialidad(textFieldEspecialidad.getText());
        return m;
    }

    private boolean validateFields() {
        boolean valid = true;
        if (textFieldId.getText().isEmpty()) {
            valid = false;
            textFieldId.setBackground(Application.BACKGROUND_ERROR);
            textFieldId.setToolTipText("ID requerido");
        } else {
            textFieldId.setBorder(null);
            textFieldId.setToolTipText(null);
        }

        if (textFieldNombre.getText().isEmpty()) {
            valid = false;
            textFieldNombre.setBackground(Application.BACKGROUND_ERROR);
            textFieldNombre.setToolTipText("Nombre requerido");
        } //else resetField(textFieldNombre);
        else {
            textFieldId.setBorder(null);
            textFieldId.setToolTipText(null);
        }
        if (textFieldEspecialidad.getText().isEmpty()) {
            valid = false;
            textFieldEspecialidad.setBackground(Application.BACKGROUND_ERROR);
            textFieldEspecialidad.setToolTipText("Especialidad requerida");
        } //else resetField(textFieldEspecialidad);
        else {
            textFieldId.setBorder(null);
            textFieldId.setToolTipText(null);

        }

        return valid;
    }

    private void resetField(JTextField field) {
        field.setBackground(null);
        field.setToolTipText(null);
    }


}
