package Personas.presentation.personas;

import Personas.presentation.AbstractModel;

import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

import Personas.logic.Persona;

public class Model extends AbstractModel{
    Persona current;

    public static final String CURRENT = "current";

    public Model() { current = new Persona(); }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        super.addPropertyChangeListener(listener);
        firePropertyChange(CURRENT);
    }

    public Persona getCurrent() { return current; }

    public void setCurrent(Persona current) {
        this.current = current;
        firePropertyChange(CURRENT);
    }
}
