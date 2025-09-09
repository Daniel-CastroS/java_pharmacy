package Personas.logic;

import Personas.logic.Paciente;
import Personas.logic.Medicamento;
import Personas.logic.Medico;

import java.util.ArrayList;
import java.util.List;

public class Prescripcion {
    private  Medico medico;
    private Paciente paciente;
    private List<Medicamento> medicamento;
    private int cantidad;
    private int duracion;
    private String indicaciones;
    private String codigo;
    private String Presentacion;

    public  Prescripcion() {
        this.medico = null;
        this.paciente = null;
        this.medicamento = new ArrayList<>();
        this.cantidad = 0;
        this.duracion = 0;
        this.indicaciones = "";
        this.codigo = "";
        this.Presentacion = "";
    }
    public Prescripcion(Medico medico, Paciente paciente, int cantidad, int duracion, String indicaciones, String codigo, String Presentacion) {
        this.medico = medico;
        this.paciente = paciente;
        this.medicamento = new ArrayList<>();
        this.cantidad = cantidad;
        this.duracion = duracion;
        this.indicaciones = indicaciones;
        this.codigo = codigo;
        this.Presentacion = Presentacion;
    }

    // Getters

    public Medico getMedico() { return medico; }

    public Paciente getPaciente() { return paciente; }

    public List<Medicamento> getMedicamento() { return medicamento; }

    public int getCantidad() { return cantidad; }

    public int getDuracion() { return duracion; }

    public String getIndicaciones() { return indicaciones; }

    public String getCodigo() { return codigo; }

    public String getPresentacion() { return Presentacion; }

    // Setters

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public void setDuracion(int duracion) { this.duracion = duracion; }

    public void setIndicaciones(String indicaciones) { this.indicaciones = indicaciones; }

    public void setMedico(Medico medico) { this.medico = medico; }

    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public void setCodigo(String codigo) { this.codigo = codigo; }

    public void setPresentacion(String Presentacion) { this.Presentacion = Presentacion; }
}
