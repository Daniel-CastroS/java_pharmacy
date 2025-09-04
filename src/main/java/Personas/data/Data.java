package Personas.data;

import Personas.logic.*;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Farmaceuta> farmaceutas;
    private List<Administrador> administradores;
    private List<Medicamento>  medicamentos;


    public Data() {
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
        administradores = new ArrayList<>();
        farmaceutas = new ArrayList<>();
        medicamentos = new ArrayList<>();
        administradores.add(new Administrador("111", "Admin1")); // Default admin




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

    public List<Administrador> getAdministradores() {
        return administradores;
    }
}
