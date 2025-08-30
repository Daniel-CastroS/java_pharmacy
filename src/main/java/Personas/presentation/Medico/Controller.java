package Personas.presentation.Medico;

import Personas.logic.Persona;
import Personas.logic.Service;



import Personas.logic.Medico;
import Personas.logic.Service;
import java.util.List;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    // ====== MÉTODOS CRUD ======

    // Crear médico
    public void createMedico(Medico m) throws Exception {
        Service.instance().createMedico(m);
        model.setCurrent(new Medico());
        model.setList(Service.instance().findAll());
    }


    public void readMedico(String id) throws Exception {
        Medico temp = new Medico();
        temp.setId(id);
        try {
            Medico result = Service.instance().readMedico(temp);
            model.setCurrent(result);
        } catch (Exception ex) {
            model.setCurrent(new Medico());
            throw ex;
        }
    }

    // Borrar médico
    public void deleteMedico(String id) throws Exception {
        Service.instance().deleteMedico(id);
        model.setCurrent(new Medico());
        model.setList(Service.instance().findAll());
    }

    // Limpiar formulario (reset current)
    public void clear() {
        model.setCurrent(new Medico());
    }

    // Obtener listado completo
    public List<Medico> getAll() {
        return Service.instance().findAll();
    }
}
