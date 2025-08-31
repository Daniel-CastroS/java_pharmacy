package Personas.presentation.Farmaceuta;

import Personas.logic.Farmaceuta;
import Personas.presentation.AbstractModel;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Model extends AbstractModel {

    private Farmaceuta current;
    private List<Farmaceuta> list;
    private Farmaceuta filter;  // ignorar por ahora

    public static final String LIST = "list";
    public static final String CURRENT = "current";
    public static final String FILTER = "filter"; // ignorar por ahora

    public Model() {
        this.list = new ArrayList<>();
        current = new Farmaceuta();
    }

    // GETTERS Y SETTERS
    public List<Farmaceuta> getList() { return list; }

    public void setList(List<Farmaceuta> list) {
        this.list = list;
        firePropertyChange(LIST);
    }

    public Farmaceuta getCurrent() { return current; }

    public void setCurrent(Farmaceuta current) {
        this.current = current;
        firePropertyChange(CURRENT);
    }

    public Farmaceuta getFilter() { return filter; }

    public void setFilter(Farmaceuta filter) {
        this.filter = filter;
        firePropertyChange(FILTER);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(LIST);
        firePropertyChange(CURRENT);
        firePropertyChange(FILTER);
    }
}
