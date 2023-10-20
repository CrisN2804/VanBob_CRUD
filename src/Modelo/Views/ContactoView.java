package Modelo.Views;

public class ContactoView {
    private int id;
    private String empleado;
    private String cliente;

    public ContactoView(int id, String empleado, String cliente){
        setId(id);
        setEmpleado(empleado);
        setCliente(cliente);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
