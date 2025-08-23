package Personas.presentation.personas;

import Personas.logic.Persona;
import Personas.logic.Service;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void readMedico(String id) throws Exception {
        Persona m = new Persona();
        m.setId(id);
        model.setCurrent(Service.instance().readMedico(m));
    }

    public void readPaciente(String id) throws Exception {
        Persona p = new Persona();
        p.setId(id);
        model.setCurrent(Service.instance().readPaciente(p));
    }

    public void readFarmaceuta(String id) throws Exception {
        Persona f = new Persona();
        f.setId(id);
        model.setCurrent(Service.instance().readFarmaceuta(f));
    }

    public void readAdministrativo(String id) throws Exception {
        Persona a = new Persona();
        a.setId(id);
        model.setCurrent(Service.instance().readAdministrador(a));
    }
}
