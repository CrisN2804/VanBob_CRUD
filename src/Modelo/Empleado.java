package Modelo;

import java.util.Date;

public class Empleado {
    private int idEmpleado;
    private int idDepartamento;
    private String nombre;
    private String apellido;

    public Empleado(int idEmpleado, int idDepa, String nombre, String ape) {
        setIdEmpleado(idEmpleado);
        setIdDepartamento(idDepa);
        setNombre(nombre);
        setApellido(ape);
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
