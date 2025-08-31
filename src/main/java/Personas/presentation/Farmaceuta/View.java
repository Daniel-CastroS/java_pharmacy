package Personas.presentation.Farmaceuta;

import Personas.logic.Farmaceuta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View implements PropertyChangeListener {
    private JPanel panel1;
    private JButton guardarButton;
    private JButton borrarButton;
    private JButton limpiarButton;
    private JTextField textFieldId;
    private JTextField textFieldNombre;
    private JTable table2;
    private JTextField textField1;
    private JButton buscarButton;
    private JButton reporteButton;
    private JTable table1;

    Controller controller;
    Model model;

    public View() {
        // BOTONES
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    Farmaceuta f = take();
                    try {
                        controller.createFarmaceuta(f);
                        JOptionPane.showMessageDialog(panel1, "Farmacéutico registrado", "Info", JOptionPane.INFORMATION_MESSAGE);
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
                    controller.deleteFarmaceuta(textFieldId.getText());
                    JOptionPane.showMessageDialog(panel1, "Farmacéutico eliminado", "Info", JOptionPane.INFORMATION_MESSAGE);
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

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.readFarmaceuta(textFieldId.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel1, ex.getMessage(), "Información", JOptionPane.INFORMATION_MESSAGE);
                }
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
                int[] cols = {TableModel.ID, TableModel.NOMBRE};
                table1.setModel(new TableModel(cols, model.getList()));
                break;
            case Model.CURRENT:
                Farmaceuta current = model.getCurrent();
                textFieldId.setText(current.getId());
                textFieldNombre.setText(current.getName());
                // Reset visual
                resetField(textFieldId);
                resetField(textFieldNombre);
                break;
        }
    }

    private Farmaceuta take() {
        Farmaceuta f = new Farmaceuta();
        f.setId(textFieldId.getText());
        f.setName(textFieldNombre.getText());
        return f;
    }

    private boolean validateFields() {
        boolean valid = true;
        if (textFieldId.getText().isEmpty()) {
            valid = false;
            textFieldId.setBackground(java.awt.Color.PINK);
            textFieldId.setToolTipText("ID requerido");
        } else resetField(textFieldId);

        if (textFieldNombre.getText().isEmpty()) {
            valid = false;
            textFieldNombre.setBackground(java.awt.Color.PINK);
            textFieldNombre.setToolTipText("Nombre requerido");
        } else resetField(textFieldNombre);

        return valid;
    }

    private void resetField(JTextField field) {
        field.setBackground(null);
        field.setToolTipText(null);
    }
}
