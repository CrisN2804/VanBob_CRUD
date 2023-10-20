package Modelo;

public class Cliente {
    private int idCliente;
    private String nombre;
    private int lealtad;

    public Cliente(int idCliente, String nombre, int lealtad) {
        setIdCliente(idCliente);
        setNombre(nombre);
        setLealtad(lealtad);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLealtad() {
        return lealtad;
    }

    public void setLealtad(int lealtad) {
        this.lealtad = lealtad;
    }
}
