package Personas.presentation.Prescripcion;

import Personas.Application;
import Personas.logic.Medicamento;
import Personas.logic.Service;

import java.util.List;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        model.init(Service.instance().search(new Medicamento()));
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    // ====== MÉTODOS CRUD ======

    public void search(Medicamento filter) throws  Exception{
        model.setFilter(filter);
        model.setMode(Personas.Application.MODE_CREATE);
        model.setCurrent(new Medicamento());
        model.setList(Service.instance().search(model.getFilter()));
    }

    // Limpiar formulario (reset current)
    public void clear() {
        model.setMode(Application.MODE_CREATE);
        model.setCurrent(new Medicamento());
    }

    // Obtener listado completo
    public List<Medicamento> getAll() {
        return Service.instance().findAllMedicamentos();
    }

    public void shown(){
        model.setList(Service.instance().search(new Medicamento()));
    }