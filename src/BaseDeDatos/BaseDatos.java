package BaseDeDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modelo.*;
import Modelo.Views.*;

public class BaseDatos {
    Connection connection;
    public BaseDatos(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/vanbob" ,
                    "root" ,
                    "");
        }catch (ClassNotFoundException classNotFoundException){
        }catch (SQLException sqlException){
            throw new RuntimeException();
        }
    }
    //region CREATES
    public void agregarCliente(String nombre, int lealtad){
        PreparedStatement sql;
        try{
            sql = connection.prepareStatement("insert into cliente(nombre, lealtad) " +
                    "values(?,?)");
            sql.setString(1, nombre);
            sql.setInt(2, lealtad);
            sql.executeUpdate();
            sql.close();
        }catch(SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
    public void agregarDepartamento(String nombre){
        PreparedStatement sql;
        try{
            sql = connection.prepareStatement("insert into departamento(depa) values(?)");
            sql.setString(1, nombre);
            sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
    public void agregarEmpleado(int idDepartamento, String nombre, String apellido){
        PreparedStatement sql;
        try{
            sql = connection.prepareStatement("insert into empleado(id_depa, nombre, ape)" +
                    "values(?,?,?)");
            sql.setInt(1, idDepartamento);
            sql.setString(2, nombre);
            sql.setString(3, apellido);
            sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
    public void agregarOrden(int idCliente, int idProducto, long orden){
        PreparedStatement sql;
        try{
            sql = connection.prepareStatement("insert into ordena(id_cliente, id_producto, orden)" +
                    "values(?,?,?)");
            sql.setInt(1, idCliente);
            sql.setInt(2, idProducto);
            sql.setLong(3, orden);
            sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
    public void agregarProducto(String nombre){
        PreparedStatement sql;
        try{
            sql = connection.prepareStatement("insert into producto(nombre) " +
                    "values(?)");
            sql.setString(1, nombre);
            sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
    //endregion
    //region READS
    public List<Cliente> leerTodosCliente(){
        PreparedStatement sql;
        List<Cliente> resultados = new ArrayList<>();
        ResultSet resultSet;
        try{
            sql = connection.prepareStatement("select * from cliente");
            resultSet = sql.executeQuery();
            while(resultSet.next()){
                resultados.add(new Cliente(
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("lealtad")
                        )
                );
            }
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return resultados;
    }
    public List<Departamento> leerTodosDepartamentos(){
        List<Departamento> resultados = new ArrayList<>();
        PreparedStatement sql;
        ResultSet resultSet;
        try {
            sql = connection.prepareStatement("select * from departamento");
            resultSet = sql.executeQuery();
            while(resultSet.next()){
                resultados.add(new Departamento(
                        resultSet.getInt("id_depa"),
                        resultSet.getString("depa")
                ));
            }
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return resultados;
    }
    public List<Empleado> leerTodosEmpleados(){
        List<Empleado> resultados = new ArrayList<>();
        PreparedStatement sql;
        ResultSet resultSet;
        try {
            sql = connection.prepareStatement("select * from empleado");
            resultSet = sql.executeQuery();
            while(resultSet.next()){
                resultados.add(new Empleado(
                        resultSet.getInt("id_empleado"),
                        resultSet.getInt("id_depa"),
                        resultSet.getString("nombre"),
                        resultSet.getString("ape")
                ));
            }
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return resultados;
    }
    public List<Orden> leerTodasOrdenes(){
        List<Orden> resultados = new ArrayList<>();
        PreparedStatement sql;
        ResultSet resultSet;
        try {
            sql = connection.prepareStatement("select * from ordena");
            resultSet = sql.executeQuery();
            while(resultSet.next()){
                resultados.add(new Orden(
                        resultSet.getInt("id_orden"),
                        resultSet.getInt("id_cliente"),
                        resultSet.getInt("id_producto"),
                        resultSet.getLong("orden")
                ));
            }
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return resultados;
    }
    public List<Producto> leerTodosProductos(){
        List<Producto> resultados = new ArrayList<>();
        PreparedStatement sql;
        ResultSet resultSet;
        try {
            sql = connection.prepareStatement("select * from producto");
            resultSet=sql.executeQuery();
            while(resultSet.next()){
                resultados.add(new Producto(
                        resultSet.getInt("id_producto"),
                        resultSet.getString("nombre"),
                        resultSet.getLong("existentes"),
                        resultSet.getLong("produciendo")
                ));
            }
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return resultados;
    }
    //endregion
    //region UPDATES
    public boolean actualizarCliente(Cliente cliente){
        PreparedStatement sql;
        int rs=0;
        try {
            sql= connection.prepareStatement("update cliente set nombre=?, lealtad=? where id_cliente=?");
            sql.setString(1, cliente.getNombre());
            sql.setInt(2, cliente.getLealtad());
            sql.setInt(3, cliente.getIdCliente());
            rs= sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return rs==1;
    }
    public boolean actualizarDepartamento(Departamento departamento){
        PreparedStatement sql;
        int rs=0;
        try {
            sql = connection.prepareStatement("update departamento set depa=? where id_depa=?");
            sql.setString(1, departamento.getDepartamento());
            sql.setInt(2, departamento.getIdDepartamento());
            rs = sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return rs==1;
    }
    public boolean actualizarEmpleado(Empleado empleado){
        PreparedStatement sql;
        int rs=0;
        try {
            sql = connection.prepareStatement("update empleado set id_depa=?, nombre=?, ape=? where id_empleado=?");
            sql.setInt(1, empleado.getIdDepartamento());
            sql.setString(2, empleado.getNombre());
            sql.setString(3, empleado.getApellido());
            sql.setInt(4, empleado.getIdEmpleado());
            rs = sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return rs==1;
    }
    public boolean actualizarOrden(Orden orden){
        PreparedStatement sql;
        int rs=0;
        try {
            sql = connection.prepareStatement("update ordena set id_cliente=?,id_producto=?, orden=? where id_orden=?");
            sql.setInt(1, orden.getIdCliente());
            sql.setInt(2, orden.getIdProducto());
            sql.setLong(3, orden.getPedido());
            sql.setInt(4, orden.getIdOrden());
            rs = sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return rs==1;
    }
    public boolean actualizarProducto(Producto producto){
        PreparedStatement sql;
        int rs=0;
        try {
            sql = connection.prepareStatement("update producto set nombre=?, existentes=?,produciendo=? where id_producto=?");
            sql.setString(1, producto.getNombre());
            sql.setLong(2, producto.getExistentes());
            sql.setLong(3, producto.getProduciendo());
            sql.setInt(4, producto.getIdProducto());
            rs = sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return rs==1;
    }
    //endregion
    //region DELETES
    public boolean borrarCliente(int id){
        PreparedStatement sql;
        int rs=0;
        try {
            sql = connection.prepareStatement("delete from cliente where id_cliente=?");
            sql.setInt(1, id);
            rs = sql.executeUpdate();
            rs = sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return rs==1;
    }
    public boolean borrarContacto(int id){
        PreparedStatement sql;
        int rs=0;
        try {
            sql = connection.prepareStatement("delete from contacto where id_contacto=?");
            sql.setInt(1, id);
            rs = sql.executeUpdate();
            rs = sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return rs==1;
    }
    public boolean borrarDepartamento(int id){
        PreparedStatement sql;
        int rs=0;
        try {
            sql = connection.prepareStatement("delete from departamento where id_depa=?");
            sql.setInt(1, id);
            rs = sql.executeUpdate();
            rs = sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return rs==1;
    }
    public boolean borrarEmpleado(int id){
        PreparedStatement sql;
        int rs=0;
        try {
            sql = connection.prepareStatement("delete from empleado where id_empleado=?");
            sql.setInt(1, id);
            rs = sql.executeUpdate();
            rs = sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return rs==1;
    }
    public boolean borrarOrden(int id){
        PreparedStatement sql;
        int rs=0;
        try {
            sql = connection.prepareStatement("delete from ordena where id_orden=?");
            sql.setInt(1, id);
            rs = sql.executeUpdate();
            rs = sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return rs==1;
    }
    public boolean borrarProducto(int id){
        PreparedStatement sql;
        int rs=0;
        try {
            sql = connection.prepareStatement("delete from producto where id_producto=?");
            sql.setInt(1, id);
            rs = sql.executeUpdate();
            rs = sql.executeUpdate();
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return rs==1;
    }
    //endregion
    //region READ_Views
    public List<EmpleadoView> leerTodosEmpleadosViews(){
        List<EmpleadoView> resultados = new ArrayList<>();
        PreparedStatement sql;
        ResultSet resultSet;
        try {
            sql = connection.prepareStatement("select * from empleadodepartamento");
            resultSet = sql.executeQuery();
            while(resultSet.next()){
                resultados.add(new EmpleadoView(
                        resultSet.getInt("id_empleado"),
                        resultSet.getString("nombre"),
                        resultSet.getString("ape"),
                        resultSet.getString("depa")
                ));
            }
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return resultados;
    }
    public List<OrdenView> leerTodasOrdenesView(){
        List<OrdenView> resultados = new ArrayList<>();
        PreparedStatement sql;
        ResultSet resultSet;
        try {
            sql = connection.prepareStatement("select * from ordenes");
            resultSet = sql.executeQuery();
            while(resultSet.next()){
                resultados.add(new OrdenView(
                        resultSet.getInt("ID"),
                        resultSet.getString("Producto"),
                        resultSet.getString("Cliente"),
                        resultSet.getLong("Orden")
                ));
            }
        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return resultados;
    }
    //endregion
}