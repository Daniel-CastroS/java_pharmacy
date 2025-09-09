package Personas.presentation.Prescripcion;

import Personas.logic.Medicamento;
import Personas.logic.Prescripcion;
import Personas.presentation.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel<Prescripcion> implements javax.swing.table.TableModel {
    public TableModel(int[] cols, List<Prescripcion> rows) {
        super(cols, rows);
    }

    @Override
    protected Object getPropetyAt(Prescripcion prescripcion, int col) {
        switch (cols[col]) {
            case NOMBRE: return prescripcion.getMedicamento().getLast().getNombre();
            case PRESENTACION: return prescripcion.getPresentacion();
            case CANTIDAD: return prescripcion.getCantidad();
            case INDICACIONES: return prescripcion.getIndicaciones();
            case DURACION: return prescripcion.getDuracion();
            default: return "";
        }
    }

    public static final int NOMBRE = 0;
    public static final int PRESENTACION = 1;
    public static final int CANTIDAD = 2;
    public static final int INDICACIONES = 3;
    public static final int DURACION = 4;


    @Override
    protected void initColNames() {
        colNames = new String[5];
        colNames[NOMBRE] = "Nombre";
        colNames[PRESENTACION] = "Presentacion";
        colNames[CANTIDAD] = "Cantidad";
        colNames[INDICACIONES] = "Indicaciones";
        colNames[DURACION] = "Duracion";
    }
}
