package Personas.presentation.Prescripcion;

import Personas.Application;
import Personas.logic.*;
import Personas.presentation.Prescripcion.Model;
import Personas.presentation.Prescripcion.View;
import Personas.presentation.Sesion.Sesion;

import java.util.List;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        model.init(Service.instance().searchPrescripcion(new Prescripcion()));
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    // ====== MÉTODOS CRUD ======

    // Crear paciente


    public void search(Prescripcion filter) throws  Exception{
        model.setFilter(filter);
        model.setMode(Personas.Application.MODE_CREATE);
        model.setCurrent(new Prescripcion());
        model.setList(Service.instance().searchPrescripcion(model.getFilter()));
    }


    public void save(Prescripcion m) throws  Exception{
        switch (model.getMode()) {
            case Personas.Application.MODE_CREATE:
                Service.instance().createPrescripcion(m);
                break;
            case Personas.Application.MODE_EDIT:
                Service.instance().updatePrescripcion(m);
                break;
        }

        model.setFilter(new Prescripcion());
        search(model.getFilter());
    }
    public void edit(int row){

        Prescripcion m = model.getList().get(row);
        try {
            model.setMode(Personas.Application.MODE_EDIT);
            model.setCurrent(Service.instance().readPrescripcion(m));
        } catch (Exception ex) {}
    }

    public void addMedicamento(Medicamento t1) throws Exception {
        Medicamento meds = Service.instance().readMedicamentoCodigo(t1);
        if (meds == null) {
            throw new Exception("Medicamento no existe");
        }
        model.getCurrent().getMedicamento().add(meds);
    }

    public void addMedico(Medico t1) throws Exception {
        Medico m = Service.instance().readMedico(t1);
        if (m == null) {
            throw new Exception("Médico no existe");
        }
        model.getCurrent().setMedico(m);
    }

    public void addPaciente(Paciente t1) throws Exception {
        Paciente p = Service.instance().readPaciente(t1);
        if (p == null) {
            throw new Exception("Paciente no existe");
        }
        model.getCurrent().setPaciente(p);
    }

    public void deletePrescripcion() throws Exception {
        Service.instance().deletePrescripcion(model.getCurrent());
        search(model.getFilter());
    }

    public void deleteMedicamento() throws Exception {
        if (model.getCurrent().getMedicamento().isEmpty()) {
            throw new Exception("No hay medicamentos que eliminar");
        }
        model.getCurrent().getMedicamento().removeLast();
    }

    public void deletePaciente() throws Exception {
        if (model.getCurrent().getPaciente() == null) {
            throw new Exception("No hay paciente que eliminar");
        }
        model.getCurrent().setPaciente(null);
    }

    public void deleteMedico() throws Exception {
        if (model.getCurrent().getMedico() == null) {
            throw new Exception("No hay médico que eliminar");
        }
        model.getCurrent().setMedico(null);
    }

    // Limpiar formulario (reset current)
    public void clear() throws  Exception {
        deleteMedicamento();
        deletePaciente();
        deleteMedico();
        deletePrescripcion();
        model.setMode(Application.MODE_CREATE);
        model.setCurrent(new Prescripcion());
    }

    // Obtener listado completo
    public List<Prescripcion> getAll() {
        return Service.instance().findAllPrescripciones();
    }

    public void shown(){
        model.setList(Service.instance().searchPrescripcion(new Prescripcion()));
    }
}