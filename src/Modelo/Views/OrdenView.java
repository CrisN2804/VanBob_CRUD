package Modelo.Views;

public class OrdenView {
    private int idOrden;
    private String producto;
    private String cliente;
    private long orden;

    public OrdenView(int id, String producto, String cliente, long orden){
        setIdOrden(id);
        setProducto(producto);
        setCliente(cliente);
        setOrden(orden);
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public long getOrden() {
        return orden;
    }

    public void setOrden(long orden) {
        this.orden = orden;
    }
}
