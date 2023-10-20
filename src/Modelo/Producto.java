package Modelo;

public class Producto {
    private int idProducto;
    private String nombre;
    private long existentes;
    private long produciendo;

    public Producto(int idProducto, String nombre, long existentes, long produciendo) {
        setIdProducto(idProducto);
        setNombre(nombre);
        setExistentes(existentes);
        setProduciendo(produciendo);
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getExistentes() {
        return existentes;
    }

    public void setExistentes(long existentes) {
        this.existentes = existentes;
    }

    public long getProduciendo() {
        return produciendo;
    }

    public void setProduciendo(long produciendo) {
        this.produciendo = produciendo;
    }
}
