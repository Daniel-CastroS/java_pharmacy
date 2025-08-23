package Personas.data;

import Personas.logic.Medico;
import Personas.logic.Paciente;
import Personas.logic.Farmaceuta;
import Personas.logic.Administrador;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Farmaceuta> farmaceutas;
    private List<Administrador> administradores;

    public Data() {
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
        administradores = new ArrayList<>();
        farmaceutas = new ArrayList<>();
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

    public List<Administrador> getAdministradores() {
        return administradores;
    }

}
