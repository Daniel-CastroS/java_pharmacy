package Personas.logic;

public class Persona {
    private String id;
    private String name;
    // En el enunciado solo sale estos en comun entre los tipos persona.
    public  Persona(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Persona() {
        this.id = " ";
        this.name = " ";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
