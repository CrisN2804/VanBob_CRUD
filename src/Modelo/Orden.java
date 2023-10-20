package Modelo;

public class Orden {
    private int idOrden;
    private int idCliente;
    private int idProducto;
    private long pedido;

    public Orden(int idOrden, int idCliente, int idProducto, long pedido) {
        setIdOrden(idOrden);
        setIdCliente(idCliente);
        setIdProducto(idProducto);
        setPedido(pedido);
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public long getPedido() {
        return pedido;
    }

    public void setPedido(long pedido) {
        this.pedido = pedido;
    }
}
