package Personas.presentation.Prescripcion.paciente;

import Personas.logic.Paciente;
import Personas.presentation.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel<Paciente> implements javax.swing.table.TableModel {
    public TableModel(int[] cols, List<Paciente> rows) {
        super(cols, rows);
    }

    public static final int ID = 0;
    public static final int NOMBRE = 1;
    public static final int BIRTH = 2;
    public static final int TELEFONO = 3;

    @Override
    protected Object getPropetyAt(Paciente e, int col) {
        switch (cols[col]) {
            case ID: return e.getId();
            case NOMBRE: return e.getName();
            case BIRTH: return e.getFechaNac();
            case TELEFONO: return e.getTelefono();

            default: return "";
        }
    }

    @Override
    protected void initColNames() {
        colNames = new String[4];
        colNames[ID] = "Codigo";
        colNames[NOMBRE] = "Nombre";
        colNames[BIRTH] = "Presentacion";
        colNames[TELEFONO] = "Telefono";
    }
}