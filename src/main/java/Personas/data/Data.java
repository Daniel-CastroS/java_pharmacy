package Personas.data;

import Personas.logic.Medico;
import Personas.logic.Paciente;
import Personas.logic.Farmaceuta;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Farmaceuta> farmaceutas;

    public Data() {
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
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

    public void addMedico(Medico medico) {
        medicos.add(medico);
    }

    public Medico getMedicoById(String id) {
        for (Medico medico : medicos) {
            if (medico.getId().equals(id)) {
                return medico;
            }
        }
        return null; // Return null if no Medico with the given id is found
    }

    public void removeMedico(String id) {
        Medico medico = getMedicoById(id);
        if (medico != null) {
            medicos.remove(medico);
        }
    }

    public void addPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente getPacienteById(String id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                return paciente;
            }
        }
        return null; // Return null if no Paciente with the given id is found
    }

    public void removePaciente(String id) {
        Paciente paciente = getPacienteById(id);
        if (paciente != null) {
            pacientes.remove(paciente);
        }
    }

    public void addFarmaceuta(Farmaceuta farmaceuta) {
        farmaceutas.add(farmaceuta);
    }

    public Farmaceuta getFarmaceutaById(String id) {
        for (Farmaceuta farmaceuta : farmaceutas) {
            if (farmaceuta.getId().equals(id)) {
                return farmaceuta;
            }
        }
        return null; // Return null if no Farmaceuta with the given id is found
    }

    public void removeFarmaceuta(String id) {
        Farmaceuta farmaceuta = getFarmaceutaById(id);
        if (farmaceuta != null) {
            farmaceutas.remove(farmaceuta);
        }
    }

}
