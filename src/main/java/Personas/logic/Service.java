package Personas.logic;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Personas.data.Data;

public class Service {
    private static Service theInstance;

    public static Service instance() {
        if (theInstance == null) theInstance = new Service();
        return theInstance;
    }

    private Data data;

    public Data getData() {return data;}


    private Service() { data = new Data(); }

    // =============== Medico ===============
    public void createMedico(Medico m) throws Exception {
        Medico result = data.getMedicos().stream().filter(i -> i.getId().equals(m.getId())).findFirst().orElse(null);
        if (result == null) {
            data.getMedicos().add(m);
        } else {
            throw new Exception("Medico ya existe");
        }
    }

    public Medico readMedico(Medico m) throws Exception {
        Medico result = data.getMedicos().stream().filter(i -> i.getId().equals(m.getId())).findFirst().orElse(null);
        if (result != null) {return result;}
        else {
            throw new Exception("Medico no existe");
        }
    }

    /* public void deleteMedico(String id) throws Exception {
         Medico result = data.getMedicos().stream()
                 .filter(i -> i.getId().equals(id))
                 .findFirst()
                 .orElse(null);
         if (result != null) {
             data.getMedicos().remove(result);
         } else {
             throw new Exception("Medico no existe");
         }
     }*/
    public void updateMedico(Medico m) throws Exception {
        Medico result;
        try{
            result = this.readMedico(m);
            data.getMedicos().remove(result);
            data.getMedicos().add(m);
        } catch (Exception e){
            throw new Exception("Medico no existe");
        }

    }

    public void deleteMedico(Medico m) throws Exception {
        data.getMedicos().remove(m);
    }
    public List<Medico> search(Medico m){
        return data.getMedicos().stream()
                .filter(i->i.getName().contains(m.getName()) || i.getId().contains(m.getId()))
                .sorted(Comparator.comparing(Medico::getName))
                .collect(Collectors.toList());
    }

    public List<Medico> findAll() {
        return data.getMedicos();
    }

    // =============== Paciente ===============
    public void createPatiente(Paciente p) throws Exception {
        Paciente result = data.getPacientes().stream()
                .filter(i -> i.getId().equals(p.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            data.getPacientes().add(p);
        } else {
            throw new Exception("Paciente ya existe");
        }
    }

    public Paciente readPaciente(Persona p) throws Exception {
        Paciente result = data.getPacientes().stream()
                .filter(i -> i.getId().equals(p.getId()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Paciente no existe");
        }
    }

    public Paciente readPacienteNombre(Persona p) throws Exception {
        Paciente result = data.getPacientes().stream()
                .filter(i -> i.getName().equals(p.getId()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Paciente no existe");
        }
    }

    public Paciente readPacienteNombre(Paciente p) throws Exception {
        Paciente result = data.getPacientes().stream()
                .filter(i -> i.getName().equals(p.getName()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Paciente no existe");
        }
    }

    public void deletePaciente(Paciente p) throws Exception {
        Paciente result = data.getPacientes().stream()
                .filter(i -> i.getId().equals(p.getId()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            data.getPacientes().remove(result);
        } else {
            throw new Exception("Paciente no existe");
        }
    }

    public void updatePaciente(Paciente p) throws Exception {
        Paciente result;
        try {
            result = this.readPaciente(p);
            data.getPacientes().remove(result);
            data.getPacientes().add(p);
        } catch (Exception e) {
            throw new Exception("Paciente no existe");
        }
    }

    public List<Paciente> search(Paciente p) {
        return data.getPacientes().stream()
                .filter(i -> i.getName().contains(p.getName()) || i.getId().contains(p.getId()))
                .sorted(Comparator.comparing(Paciente::getName))
                .collect(Collectors.toList());
    }

    public List<Paciente> findAllPacientes() {
        return data.getPacientes();
    }

    // =============== Farmaceuta ===============
    public void createFarmaceuta(Farmaceuta f) throws Exception {
        Farmaceuta result = data.getFarmaceutas().stream()
                .filter(i -> i.getId().equals(f.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            data.getFarmaceutas().add(f);
        } else {
            throw new Exception("Farmaceuta ya existe");
        }
    }

    public Farmaceuta readFarmaceuta(Farmaceuta f) throws Exception {
        Farmaceuta result = data.getFarmaceutas().stream()
                .filter(i -> i.getId().equals(f.getId()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Farmaceuta no existe");
        }
    }

    public void updateFarmaceuta(Farmaceuta f) throws Exception {
        Farmaceuta result;
        try {
            result = this.readFarmaceuta(f);
            data.getFarmaceutas().remove(result);
            data.getFarmaceutas().add(f);
        } catch (Exception e) {
            throw new Exception("Farmaceuta no existe");
        }
    }

    public void deleteFarmaceuta(Farmaceuta f) throws Exception {
        data.getFarmaceutas().remove(f);
    }

    public List<Farmaceuta> search(Farmaceuta f) {
        return data.getFarmaceutas().stream()
                .filter(i -> i.getName().contains(f.getName()) || i.getId().contains(f.getId()))
                .sorted(Comparator.comparing(Farmaceuta::getName))
                .collect(Collectors.toList());
    }

    public List<Farmaceuta> findAllFarmaceutas() {
        return data.getFarmaceutas();
    }

    //=================Medicamentos=====================
    public void createMedicamento(Medicamento m) throws Exception {
        Medicamento result = data.getMedicamentos().stream()
                .filter(i -> i.getCodigo().equals(m.getCodigo()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            data.getMedicamentos().add(m);
        } else {
            throw new Exception("Medicamento ya existe");
        }
    }

    public Medicamento readMedicamentoCodigo(Medicamento m) throws Exception {
        Medicamento result = data.getMedicamentos().stream()
                .filter(i -> i.getCodigo().equals(m.getCodigo()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Medicamento no existe");
        }
    }

    public Medicamento readMedicamentoNombre(Medicamento m) throws Exception {
        Medicamento result = data.getMedicamentos().stream()
                .filter(i -> i.getNombre().equals(m.getNombre()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Medicamento no existe");
        }
    }

    public void updateMedicamento(Medicamento m) throws Exception {
        Medicamento result;
        try {
            result = this.readMedicamentoCodigo(m);
            data.getMedicamentos().remove(result);
            data.getMedicamentos().add(m);
        } catch (Exception e) {
            throw new Exception("Medicamento no existe");
        }
    }

    public void deleteMedicamento(Medicamento m) throws Exception {
        data.getMedicamentos().remove(m);
    }

    public List<Medicamento> search(Medicamento m) {
        return data.getMedicamentos().stream()
                .filter(i -> i.getNombre().contains(m.getNombre()) || i.getCodigo().contains(m.getCodigo()))
                .sorted(Comparator.comparing(Medicamento::getNombre))
                .collect(Collectors.toList());
    }
    public List<Medicamento> findAllMedicamentos() {
        return data.getMedicamentos();
    }

    //=================Prescripciones=====================

    public void createPrescripcion(Prescripcion p) throws Exception {
        Prescripcion result = data.getPrescripciones().stream()
                .filter(i -> i.getCodigo().equals(p.getCodigo()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            data.getPrescripciones().add(p);
        } else {
            throw new Exception("Prescripcion ya existe");
        }
    }

    public Prescripcion readPrescripcion(Prescripcion p) throws Exception {
        Prescripcion result = data.getPrescripciones().stream()
                .filter(i -> i.getCodigo().equals(p.getCodigo()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Prescripcion no existe");
        }
    }

    public void updatePrescripcion(Prescripcion m) throws Exception {
        Prescripcion result;
        try {
            result = this.readPrescripcion(m);
            data.getPrescripciones().remove(result);
            data.getPrescripciones().add(m);
        } catch (Exception e) {
            throw new Exception("Prescripcion no existe");
        }
    }

    public void deletePrescripcion(Prescripcion p) throws Exception {
        data.getPrescripciones().remove(p);
    }

    public List<Prescripcion> searchPrescripcion(Prescripcion m) {
        return data.getPrescripciones().stream()
                .filter(i -> i.getCodigo().contains(m.getCodigo()))
                .sorted(Comparator.comparing(Prescripcion::getCodigo))
                .collect(Collectors.toList());
    }

    public List<Prescripcion> findAllPrescripciones() {
        return data.getPrescripciones();
    }


    //=================Public=====================

    public Trabajador read(Trabajador p) throws Exception {
        Farmaceuta result1 = data.getFarmaceutas().stream()
                .filter(i -> i.getId().equals(p.getId()))
                .findFirst()
                .orElse(null);
        Medico result2 = data.getMedicos().stream()
                .filter(i -> i.getId().equals(p.getId()))
                .findFirst()
                .orElse(null);
        if (result1 != null) {
            return result1;
        } else if (result2 != null) {
            return result2;
        } else {
            throw new Exception("Farmaceuta no existe");
        }
    }

}