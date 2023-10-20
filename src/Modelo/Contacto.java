package Modelo;

public class Contacto {
    private int idContacto;
    private int idEmpleado;
    private int idCliente;

    public Contacto(int idContacto, int idEmpleado, int idCliente) {
        setIdContacto(idContacto);
        setIdEmpleado(idEmpleado);
        setIdCliente(idCliente);
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
