package Personas.presentation.Prescripcion.medicamento;

import Personas.logic.Medicamento;
import Personas.presentation.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel<Medicamento> implements javax.swing.table.TableModel {
    public TableModel(int[] cols, List<Medicamento> rows) {
        super(cols, rows);
    }

    public static final int CODIGO = 0;
    public static final int NOMBRE = 1;
    public static final int DESCRIPCION = 2;

    @Override
    protected Object getPropetyAt(Medicamento e, int col) {
        switch (cols[col]) {
            case CODIGO: return e.getCodigo();
            case NOMBRE: return e.getNombre();
            case DESCRIPCION: return e.getPresentacion();

            default: return "";
        }
    }

    @Override
    protected void initColNames() {
        colNames = new String[3];
        colNames[CODIGO] = "Codigo";
        colNames[NOMBRE] = "Nombre";
        colNames[DESCRIPCION] = "Presentacion";
    }
}