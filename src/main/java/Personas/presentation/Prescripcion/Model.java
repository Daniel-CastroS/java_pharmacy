package Personas.presentation.Prescripcion;

import Personas.Application;
import Personas.logic.Medicamento;
import Personas.presentation.AbstractModel;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Model extends AbstractModel{
    private Medicamento current;
    private List<Medicamento> list;
    private Medicamento filter;  //ignorar por ahora
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

    public void init(List<Medicamento> list) {
        this.list = list;
        this.current = new Medicamento();
        this.filter = new Medicamento();
        this.mode = Application.MODE_CREATE;
    }

    // GETTERS Y SETTERS
    public List<Medicamento> getList() { return list; }

    public void setList(List<Medicamento> list) {
        this.list = list;
        firePropertyChange(LIST);
    }


    public Medicamento getCurrent() { return current; }


    public void setCurrent(Medicamento current) {
        this.current = current;
        firePropertyChange(CURRENT);
    }

    public Medicamento getFilter() { return filter; }

    public void setFilter(Medicamento filter) {
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