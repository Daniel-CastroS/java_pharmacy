package Personas.logic;

import Personas.data.Data;

public class Service {
    private static Service instance;

    public static Service getInstance() {
        if (instance == null) instance = new Service();
        return instance;
    }

    private Data data;

    private Service() { data = new Data(); }

    // =============== Medico ===============
    public void createMedico(Medico m) throws Exception {
        Medico result = data.getMedicos().stream()
                .filter(i -> i.getId().equals(m.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            data.getMedicos().add(m);
        } else {
            throw new Exception("Medico ya existe");
        }
    }

    public Medico readMedico(Medico m) throws Exception {
        Medico result = data.getMedicos().stream()
                .filter(i -> i.getId().equals(m.getId()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Medico no existe");
        }
    }

    public void deleteMedico(String id) throws Exception {
        Medico result = data.getMedicos().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (result != null) {
            data.getMedicos().remove(result);
        } else {
            throw new Exception("Medico no existe");
        }
    }

    // =============== Paciente ===============
    public void createPaciente(Paciente p) throws Exception {
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

    public Paciente readPaciente(String id) throws Exception {
        Paciente result = data.getPacientes().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Paciente no existe");
        }
    }

    public void deletePaciente(String id) throws Exception {
        Paciente result = data.getPacientes().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (result != null) {
            data.getPacientes().remove(result);
        } else {
            throw new Exception("Paciente no existe");
        }
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

    public Farmaceuta readFarmaceuta(String id) throws Exception {
        Farmaceuta result = data.getFarmaceutas().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Farmaceuta no existe");
        }
    }

    public void deleteFarmaceuta(String id) throws Exception {
        Farmaceuta result = data.getFarmaceutas().stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (result != null) {
            data.getFarmaceutas().remove(result);
        } else {
            throw new Exception("Farmaceuta no existe");
        }
    }

    // =============== Administrador ===============
    public void createAdministrador(Administrador a) throws Exception {
        Administrador result = data.getAdministradores().stream()
                .filter(i -> i.getId().equals(a.getId()))
                .findFirst()
                .orElse(null);
        if (result == null) {
            data.getAdministradores().add(a);
        } else {
            throw new Exception("Administrador ya existe");
        }
    }

    public Administrador readAdministrador(Administrador a) throws Exception {
        Administrador result = data.getAdministradores().stream()
                .filter(i -> i.getId().equals(a.getId()))
                .findFirst()
                .orElse(null);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Administrador no existe");
        }
    }
}
