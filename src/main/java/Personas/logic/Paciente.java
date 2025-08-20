package Personas.logic;

public class Paciente extends Persona{
    private int telefono;
    private String fechaNac;

    public Paciente(String id, String name, int numero, String fechaNac) {
        super(id, name);
        this.telefono = numero;
        this.fechaNac = fechaNac;
    }
    public Paciente() {
        super();
        this.telefono = 0;
        this.fechaNac = " ";
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telephone) {
        this.telefono = telefono;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
}
