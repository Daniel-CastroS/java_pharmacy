package Personas.logic;

public class Trabajador extends Persona{
    private String clave_sistema;

    public Trabajador(String id, String name) {
        super(id, name);
        this.clave_sistema = id;
    }

    public Trabajador() {
        super();
        this.clave_sistema = " ";
    }

    public String getClave_sistema() {
        return clave_sistema;
    }

    public void setClave_sistema(String clave_sistema) {
        this.clave_sistema = clave_sistema;
    }
}
