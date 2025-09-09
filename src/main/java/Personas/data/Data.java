package Personas.data;

import Personas.logic.*;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Farmaceuta> farmaceutas;
    private List<Medicamento>  medicamentos;
    private List<Prescripcion> prescripciones;


    public Data() {
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
        farmaceutas = new ArrayList<>();
        medicamentos = new ArrayList<>();
        prescripciones = new ArrayList<>();
        medicos.add(new Medico("1", "Juan", "Admin", "Cardiologia"));
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Farmaceuta> getFarmaceutas() {
        return farmaceutas;
    }

    public List<Medicamento> getMedicamentos() { return medicamentos;}

    public List<Prescripcion> getPrescripciones() { return prescripciones; }

}
