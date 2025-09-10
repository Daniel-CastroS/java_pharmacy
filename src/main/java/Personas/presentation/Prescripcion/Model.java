package Personas.presentation.Prescripcion;

import Personas.Application;
import Personas.logic.Medicamento;
import Personas.logic.Prescripcion;
import Personas.presentation.AbstractModel;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Model extends AbstractModel{
    private Prescripcion current;
    private List<Prescripcion> list;
    private Prescripcion filter;  //ignorar por ahora
    int mode;

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(LIST);
        firePropertyChange(CURRENT);
        firePropertyChange(FILTER);
    }

    public Model() {

    }

    public void init(List<Prescripcion> list) {
        this.list = list;
        this.current = new Prescripcion();
        this.filter = new Prescripcion();
        this.mode = Application.MODE_CREATE;
    }

    // GETTERS Y SETTERS
    public List<Prescripcion> getList() { return list; }

    public void setList(List<Prescripcion> list) {
        this.list = list;
        firePropertyChange(LIST);
    }


    public Prescripcion getCurrent() { return current; }


    public void setCurrent(Prescripcion current) {
        this.current = current;
        firePropertyChange(CURRENT);
    }

    public Prescripcion getFilter() { return filter; }

    public void setFilter(Prescripcion filter) {
        this.filter = filter;
        firePropertyChange(FILTER);
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }



    public static final String LIST = "list";
    public static final String CURRENT = "current";
    public static final String FILTER = "filter";//ignorar por ahora
}