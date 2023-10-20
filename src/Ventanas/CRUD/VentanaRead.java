package Ventanas.CRUD;

import BaseDeDatos.BaseDatos;
import Materials.CButton;
import Materials.CLabel;
import Modelo.*;
import Modelo.Views.ContactoView;
import Modelo.Views.EmpleadoView;
import Modelo.Views.OrdenView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaRead extends JFrame {
    BaseDatos BD= new BaseDatos();
    String opcionesTable[] = {"Cliente", "Contacto", "Departamento", "Empleado", "Ordena", "Producto"};
    CLabel lblBienvenida, lblTable;
    CButton btnLeftTable, btnRightTable;
    JScrollPane sp;
    int navegadorTABLE=0;
    public VentanaRead(){
        initialize();
        funcionalidades();

        GroupLayout gl = new GroupLayout(getContentPane());
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        gl.setHorizontalGroup(
                gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblBienvenida)
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addComponent(sp)
        );
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addComponent(sp)
        );
        setLayout(gl);
        pack();
        setLocationRelativeTo(null);
    }

    void initialize(){
        lblBienvenida = new CLabel("Elige la tabla a visualizar", 40);
        lblTable = new CLabel(opcionesTable[navegadorTABLE], 20);

        btnLeftTable = new CButton("<", 20);
        btnRightTable = new CButton(">", 20);

        sp = new JScrollPane(tableCliente());
    }

    void funcionalidades(){
        btnLeftTable.addActionListener(e -> {
            if(navegadorTABLE!=0){
                navegadorTABLE--;
            }else{
                navegadorTABLE = (opcionesTable.length)-1;
            }
            lblTable.setText(opcionesTable[navegadorTABLE]);
            chooseTable();
        });
        btnRightTable.addActionListener(e -> {
            if(navegadorTABLE != (opcionesTable.length)-1){
                navegadorTABLE++;
            }else{
                navegadorTABLE=0;
            }
            lblTable.setText(opcionesTable[navegadorTABLE]);
            chooseTable();
        });
    }

    void chooseTable(){
        switch (lblTable.getText()){
            case "Cliente":{
                sp.setViewportView(tableCliente());
                break;
            }
            case "Contacto":{
                sp.setViewportView(tableContacto());
                break;
            }
            case "Departamento":{
                sp.setViewportView(tableDepartamento());
                break;
            }
            case "Empleado":{
                sp.setViewportView(tableEmpleado());
                break;
            }
            case "Ordena":{
                sp.setViewportView(tableOrdena());
                break;
            }
            case "Producto":{
                sp.setViewportView(tableProducto());
                break;
            }
        }
    }

    JTable tableCliente(){
        JTable table;
        List<Cliente> clientes = BD.leerTodosCliente();
        String[][] data = new String[clientes.size()][3];
        int navegador=0;
        for (Cliente cliente: clientes) {
            data[navegador][0] = String.valueOf(cliente.getIdCliente());
            data[navegador][1] = cliente.getNombre();
            data[navegador][2] = String.valueOf(cliente.getLealtad());
            navegador++;
        }
        String[] columnas = {"ID Cliente", "Nombre", "Años Trabajando Juntos"};
        table= new JTable(data, columnas){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        return table;
    }
    JTable tableDepartamento(){
        List<Departamento> departamentos = BD.leerTodosDepartamentos();
        JTable j;
        String[][] data = new String[departamentos.size()][2];
        int index = 0;
        for (Departamento departamento: departamentos) {
            data[index][0] = String.valueOf(departamento.getIdDepartamento());
            data[index][1] = departamento.getDepartamento();
            index++;
        }
        String[] columnNames = { "ID Departamento", "Departamento" };
        j = new JTable(data, columnNames){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        return j;
    }
    JTable tableContacto(){
        JTable table;
        List<ContactoView> contactos = BD.leerTodosContactosView();
        String[][] data = new String[contactos.size()][3];
        int navegador=0;
        for (ContactoView  contacto: contactos) {
            data[navegador][0] = String.valueOf(contacto.getId());
            data[navegador][1] = contacto.getEmpleado();
            data[navegador][2] = contacto.getCliente();
            navegador++;
        }
        String[] columnas = {"ID Contacto", "Empleado", "Cliente"};
        table= new JTable(data, columnas){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        return table;
    }
    JTable tableEmpleado(){
        JTable table;
        List<EmpleadoView> empleados = BD.leerTodosEmpleadosViews();
        String[][] data = new String[empleados.size()][4];
        int navegador=0;
        for (EmpleadoView empleado: empleados) {
            data[navegador][0] = String.valueOf(empleado.getIdEmpleado());
            data[navegador][1] = empleado.getDepartamento();
            data[navegador][2] = empleado.getNombre();
            data[navegador][3] = empleado.getApellido();
            navegador++;
        }
        String[] columnas = {"ID Empleado", "Departamento" ,"Nombre", "Apellido"};
        table= new JTable(data, columnas){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        return table;
    }
    JTable tableOrdena(){
        JTable table;
        List<OrdenView> ordens = BD.leerTodasOrdenesView();
        String[][] data = new String[ordens.size()][4];
        int navegador=0;
        for (OrdenView orden : ordens) {
            data[navegador][0] = String.valueOf(orden.getIdOrden());
            data[navegador][1] = orden.getCliente();
            data[navegador][2] = orden.getProducto();
            data[navegador][3] = String.valueOf(orden.getOrden());
            navegador++;
        }
        String[] columnas = {"ID Orden", "Cliente", "Producto", "Cantidad Ordenada"};
        table= new JTable(data, columnas){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        return table;
    }
    JTable tableProducto(){
        JTable table;
        List<Producto> productos = BD.leerTodosProductos();
        String[][] data = new String[productos.size()][4];
        int navegador=0;
        for (Producto producto : productos) {
            data[navegador][0] = String.valueOf(producto.getIdProducto());
            data[navegador][1] = producto.getNombre();
            data[navegador][2] = String.valueOf(producto.getExistentes());
            data[navegador][3] = String.valueOf(producto.getProduciendo());
            navegador++;
        }
        String[] columnas = {"ID Producto", "Nombre", "Productos Existentes", "Productos en Produccion"};
        table= new JTable(data, columnas){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        return table;
    }
}
