package Modelo.Views;

public class EmpleadoView {
    private int idEmpleado;
    private String departamento;
    private String nombre;
    private String apellido;

    public EmpleadoView(int idEmpleado, String nombre, String ape, String depa) {
        setIdEmpleado(idEmpleado);
        setDepartamento(depa);
        setNombre(nombre);
        setApellido(ape);
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
