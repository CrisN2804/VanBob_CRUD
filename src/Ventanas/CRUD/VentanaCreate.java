package Ventanas.CRUD;

import BaseDeDatos.BaseDatos;
import Materials.CButton;
import Materials.CLabel;
import Materials.CTextField;
import Modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;

public class VentanaCreate extends JFrame {
    BaseDatos BD = new BaseDatos();
    //region stuff
    List<Cliente> clientes;
    List<Empleado> empleados;
    List<Departamento> departamentos;
    List<Producto> productos;
    String opcionesClientes[], opcionesEmpleados[], opcionesDepartamentos[], opcionesProductos[];
    CLabel lblBienvenida, lblTable;
    String opcionesTable[] = {"Cliente", "Contacto", "Departamento", "Empleado", "Ordena", "Producto"};
    int navegadorTABLE=0;
    CButton btnAgregar, btnLeftTable, btnRightTable;
    //endregion
    //region TableCliente
    CLabel lblClienteTable, lblNombre, lblYears, lblYearsDisplay;
    CTextField txtNombre;
    CButton btnMinus, btnMore;
    int years =0;
    //endregion
    //region TableContacto
    CLabel lblCliente;
    JComboBox pickClient, pickEmpleado;
    CLabel lblEmpleado, lblContactoTable;
    //endregion
    //region TableDepartamento
    CLabel lblDepartamentoTable;
    //endregion
    //region TableEmpleado
    JComboBox pickDepartamento;
    CLabel lblEmpleadoTable, lblApellido, lblDepartamento;
    CTextField txtApellido;
    //endregion
    //region TableOrdena
    CLabel lblProducto, lblCantidad, lblOrdenaTable;
    CTextField txtCantidad;
    JComboBox pickProducto;
    //endregion
    //region Producto
    CLabel lblProductoTable;
    //endregion
    public VentanaCreate(){
        super("Crear");
        getThings();
        generateTexts();
        funciones();
        chooseLayout();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    void generateTexts(){
        lblBienvenida = new CLabel("Elige tu tabla", 40);
        lblTable = new CLabel(opcionesTable[navegadorTABLE], 20);
        lblClienteTable = new CLabel("Agregar a Cliente", 30);
        lblNombre = new CLabel("Nombre:", 20);
        lblCliente = new CLabel("Cliente:", 20);
        lblYears = new CLabel("Años con Nosotros:", 20);
        lblYearsDisplay = new CLabel(String.valueOf(years), 20);
        lblContactoTable = new CLabel("Agregar a Contacto", 30);
        lblEmpleado = new CLabel("Empleado:", 20);
        lblDepartamentoTable = new CLabel("Agregar a Departamento", 30);
        lblEmpleadoTable = new CLabel("Agregar un Empleado", 30);
        lblApellido = new CLabel("Apellido", 20);
        lblProducto = new CLabel("Producto:", 20);
        lblCantidad = new CLabel("Cantidad:", 20);
        lblDepartamento = new CLabel("Departamento:", 20);
        lblOrdenaTable = new CLabel("Agregar una Orden", 30);
        lblProductoTable = new CLabel("Agregar un Producto", 30);

        txtNombre = new CTextField(25, 20);
        txtApellido = new CTextField(25, 20);
        txtCantidad = new CTextField(10, 20, true);

        btnLeftTable = new CButton("<", 20);
        btnRightTable = new CButton(">", 20);
        btnAgregar = new CButton("Agregar");
        btnMinus = new CButton("-", 20);
        btnMore = new CButton("+", 20);

        setPickers();
    }
    void funciones(){
        btnLeftTable.addActionListener(e -> {
            if(navegadorTABLE!=0){
                navegadorTABLE--;
            }else{
                navegadorTABLE = (opcionesTable.length)-1;
            }
            lblTable.setText(opcionesTable[navegadorTABLE]);
            chooseLayout();
        });
        btnRightTable.addActionListener(e -> {
            if(navegadorTABLE != (opcionesTable.length)-1){
                navegadorTABLE++;
            }else{
                navegadorTABLE=0;
            }
            lblTable.setText(opcionesTable[navegadorTABLE]);
            chooseLayout();
        });
        btnMinus.addActionListener(e -> {
            if(years > 0){
                years--;
            }else{
                years=99;
            }
            lblYearsDisplay.setText(String.valueOf(years));
        });
        btnMore.addActionListener(e -> {
            if (years < 99){
                years++;
            }else{
                years=0;
            }
            lblYearsDisplay.setText(String.valueOf(years));
        });

        btnAgregar.addActionListener(e ->{
            switch (lblTable.getText()){
                case "Cliente":{
                    if(!Objects.equals(txtNombre.getText(), "")){
                        BD.agregarCliente(txtNombre.getText(), years);
                    }
                    txtNombre.setText("");
                    years=0;
                    lblYearsDisplay.setText(String.valueOf(years));
                    break;
                }
                case "Contacto":{
                    Cliente cliente = clientes.get(pickClient.getSelectedIndex());
                    Empleado empleado = empleados.get(pickEmpleado.getSelectedIndex());
                    BD.agregarContacto(empleado.getIdEmpleado(), cliente.getIdCliente());
                    break;
                }
                case "Departamento":{
                    if(!Objects.equals(txtNombre.getText(), "")){
                        BD.agregarDepartamento(txtNombre.getText());
                    }
                    txtNombre.setText("");
                    break;
                }
                case "Empleado":{
                    Departamento departamento = departamentos.get(pickDepartamento.getSelectedIndex());
                    if(!Objects.equals(txtNombre.getText(), "") || !Objects.equals(txtApellido.getText(), "")){
                        BD.agregarEmpleado(departamento.getIdDepartamento(), txtNombre.getText(), txtApellido.getText());
                    }
                    txtNombre.setText("");
                    txtApellido.setText("");
                    break;
                }
                case "Ordena":{
                    Cliente cliente = clientes.get(pickClient.getSelectedIndex());
                    Producto producto = productos.get(pickProducto.getSelectedIndex());
                    long cantidad = Long.parseLong(txtCantidad.getText());
                    if(!Objects.equals(txtCantidad.getText(), "")){
                        BD.agregarOrden(cliente.getIdCliente(), producto.getIdProducto(), cantidad);
                    }
                    txtCantidad.setText("");
                    break;
                }
                case "Producto":{
                    if(!Objects.equals(txtNombre.getText(), "")){
                        BD.agregarProducto(txtNombre.getText());
                    }
                    txtNombre.setText("");
                    break;
                }
            }
        });
    }
    void setPickers(){
        pickClient = new JComboBox(opcionesClientes);
        pickEmpleado = new JComboBox(opcionesEmpleados);
        pickDepartamento = new JComboBox(opcionesDepartamentos);
        pickProducto = new JComboBox(opcionesProductos);
    }
    void chooseLayout(){
        this.getContentPane().removeAll();
        this.revalidate();
        this.repaint();
        txtNombre.setText("");
        txtApellido.setText("");
        txtCantidad.setText("");
        getThings();
        setPickers();
        switch (lblTable.getText()){
            case "Cliente":{
                setLayout(layoutCliente());
                break;
            }
            case "Contacto":{
                setLayout(layoutContacto());
                break;
            }
            case "Departamento":{
                setLayout(layoutDepartamento());
                break;
            }
            case "Empleado":{
                setLayout(layoutEmpleado());
                break;
            }
            case "Ordena":{
                setLayout(layoutOrdena());
                break;
            }
            case "Producto":{
                setLayout(layoutProducto());
                break;
            }
        }
        pack();
        setLocationRelativeTo(null);
    }
    void getThings(){
        int x=0;
        clientes = BD.leerTodosCliente();
        empleados = BD.leerTodosEmpleados();
        departamentos = BD.leerTodosDepartamentos();
        productos = BD.leerTodosProductos();
        opcionesClientes = new String[clientes.size()];
        opcionesEmpleados = new String[empleados.size()];
        opcionesDepartamentos = new String[departamentos.size()];
        opcionesProductos = new String[productos.size()];
        for(Cliente cliente : clientes){
            opcionesClientes[x] = cliente.getNombre();
            x++;
        }
        x=0;
        for (Empleado empleado: empleados) {
            opcionesEmpleados[x] = empleado.getNombre();
            x++;
        }
        x=0;
        for (Departamento depa: departamentos) {
            opcionesDepartamentos[x] = depa.getDepartamento();
            x++;
        }
        x=0;
        for (Producto producto: productos) {
            opcionesProductos[x] = producto.getNombre();
            x++;
        }
    }
    GroupLayout layoutCliente(){
        GroupLayout lC = new GroupLayout(getContentPane());
        lC.setAutoCreateGaps(true);
        lC.setAutoCreateContainerGaps(true);
        lC.setHorizontalGroup(
                lC.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblBienvenida)
                        .addGroup(
                                lC.createSequentialGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addGroup(
                                lC.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(lblClienteTable)
                                        .addGroup(
                                                lC.createSequentialGroup()
                                                        .addComponent(lblNombre)
                                                        .addComponent(txtNombre)
                                        )
                                        .addGroup(
                                                lC.createSequentialGroup()
                                                        .addComponent(lblYears)
                                                        .addComponent(btnMinus)
                                                        .addComponent(lblYearsDisplay)
                                                        .addComponent(btnMore)
                                        )
                        )
                        .addComponent(btnAgregar)
        );
        lC.setVerticalGroup(
                lC.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGroup(
                                lC.createParallelGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addGroup(
                                lC.createSequentialGroup()
                                        .addComponent(lblClienteTable)
                                        .addGroup(
                                                lC.createParallelGroup()
                                                        .addComponent(lblNombre)
                                                        .addComponent(txtNombre)
                                        )
                                        .addGroup(
                                                lC.createParallelGroup()
                                                        .addComponent(lblYears)
                                                        .addComponent(btnMinus)
                                                        .addComponent(lblYearsDisplay)
                                                        .addComponent(btnMore)
                                        )
                        )
                        .addComponent(btnAgregar)
        );
        return lC;
    }
    GroupLayout layoutContacto(){
        GroupLayout lC = new GroupLayout(getContentPane());
        lC.setAutoCreateGaps(true);
        lC.setAutoCreateContainerGaps(true);
        lC.setHorizontalGroup(
                lC.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblBienvenida)
                        .addGroup(
                                lC.createSequentialGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addGroup(
                                lC.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(lblContactoTable)
                                        .addGroup(
                                                lC.createSequentialGroup()
                                                        .addComponent(lblCliente)
                                                        .addComponent(pickClient)
                                        )
                                        .addGroup(
                                                lC.createSequentialGroup()
                                                        .addComponent(lblEmpleado)
                                                        .addComponent(pickEmpleado)
                                        )
                        )
                        .addComponent(btnAgregar)
        );
        lC.setVerticalGroup(
                lC.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGroup(
                                lC.createParallelGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addGroup(
                                lC.createSequentialGroup()
                                        .addComponent(lblContactoTable)
                                        .addGroup(
                                                lC.createParallelGroup()
                                                        .addComponent(lblCliente)
                                                        .addComponent(pickClient)
                                        )
                                        .addGroup(
                                                lC.createParallelGroup()
                                                        .addComponent(lblEmpleado)
                                                        .addComponent(pickEmpleado)
                                        )
                        )
                        .addComponent(btnAgregar)
        );
        return lC;
    }
    GroupLayout layoutDepartamento() {
        GroupLayout lC = new GroupLayout(getContentPane());
        lC.setAutoCreateGaps(true);
        lC.setAutoCreateContainerGaps(true);
        lC.setHorizontalGroup(
                lC.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblBienvenida)
                        .addGroup(
                                lC.createSequentialGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addGroup(
                                lC.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(lblDepartamentoTable)
                                        .addGroup(
                                                lC.createSequentialGroup()
                                                        .addComponent(lblNombre)
                                                        .addComponent(txtNombre)
                                        )
                        )
                        .addComponent(btnAgregar)
        );
        lC.setVerticalGroup(
                lC.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGroup(
                                lC.createParallelGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addGroup(
                                lC.createSequentialGroup()
                                        .addComponent(lblDepartamentoTable)
                                        .addGroup(
                                                lC.createParallelGroup()
                                                        .addComponent(lblNombre)
                                                        .addComponent(txtNombre)
                                        )
                        )
                        .addComponent(btnAgregar)
        );
        return lC;
    }
    GroupLayout layoutEmpleado(){
        GroupLayout lC = new GroupLayout(getContentPane());
        lC.setAutoCreateGaps(true);
        lC.setAutoCreateContainerGaps(true);
        lC.setHorizontalGroup(
                lC.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblBienvenida)
                        .addGroup(
                                lC.createSequentialGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addGroup(
                                lC.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(lblEmpleadoTable)
                                        .addGroup(
                                                lC.createSequentialGroup()
                                                        .addComponent(lblDepartamento)
                                                        .addComponent(pickDepartamento)
                                        )
                                        .addGroup(
                                                lC.createSequentialGroup()
                                                        .addComponent(lblNombre)
                                                        .addComponent(txtNombre)
                                        )
                                        .addGroup(
                                                lC.createSequentialGroup()
                                                        .addComponent(lblApellido)
                                                        .addComponent((txtApellido))
                                        )
                        )
                        .addComponent(btnAgregar)
        );
        lC.setVerticalGroup(
                lC.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGroup(
                                lC.createParallelGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addGroup(
                                lC.createSequentialGroup()
                                        .addComponent(lblEmpleadoTable)
                                        .addGroup(
                                                lC.createParallelGroup()
                                                        .addComponent(lblDepartamento)
                                                        .addComponent(pickDepartamento)
                                        )
                                        .addGroup(
                                                lC.createParallelGroup()
                                                        .addComponent(lblNombre)
                                                        .addComponent(txtNombre)
                                        )
                                        .addGroup(
                                                lC.createParallelGroup()
                                                        .addComponent(lblApellido)
                                                        .addComponent(txtApellido)
                                        )
                        )
                        .addComponent(btnAgregar)
        );
        return lC;
    }
    GroupLayout layoutOrdena(){
        GroupLayout lC = new GroupLayout(getContentPane());
        lC.setAutoCreateGaps(true);
        lC.setAutoCreateContainerGaps(true);
        lC.setHorizontalGroup(
                lC.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblBienvenida)
                        .addGroup(
                                lC.createSequentialGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addGroup(
                                lC.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(lblOrdenaTable)
                                        .addGroup(
                                                lC.createSequentialGroup()
                                                        .addComponent(lblCliente)
                                                        .addComponent(pickClient)
                                        )
                                        .addGroup(
                                                lC.createSequentialGroup()
                                                        .addComponent(lblProducto)
                                                        .addComponent(pickProducto)
                                        )
                                        .addGroup(
                                                lC.createSequentialGroup()
                                                        .addComponent(lblCantidad)
                                                        .addComponent(txtCantidad)
                                        )
                        )
                        .addComponent(btnAgregar)
        );
        lC.setVerticalGroup(
                lC.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGroup(
                                lC.createParallelGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addGroup(
                                lC.createSequentialGroup()
                                        .addComponent(lblOrdenaTable)
                                        .addGroup(
                                                lC.createParallelGroup()
                                                        .addComponent(lblCliente)
                                                        .addComponent(pickClient)
                                        )
                                        .addGroup(
                                                lC.createParallelGroup()
                                                        .addComponent(lblProducto)
                                                        .addComponent(pickProducto)
                                        )
                                        .addGroup(
                                                lC.createParallelGroup()
                                                        .addComponent(lblCantidad)
                                                        .addComponent(txtCantidad)
                                        )
                        )
                        .addComponent(btnAgregar)
        );
        return lC;
    }
    GroupLayout layoutProducto(){
        GroupLayout lC = new GroupLayout(getContentPane());
        lC.setAutoCreateGaps(true);
        lC.setAutoCreateContainerGaps(true);
        lC.setHorizontalGroup(
                lC.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblBienvenida)
                        .addGroup(
                                lC.createSequentialGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addGroup(
                                lC.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(lblProductoTable)
                                        .addGroup(
                                                lC.createSequentialGroup()
                                                        .addComponent(lblNombre)
                                                        .addComponent(txtNombre)
                                        )
                        )
                        .addComponent(btnAgregar)
        );
        lC.setVerticalGroup(
                lC.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGroup(
                                lC.createParallelGroup()
                                        .addComponent(btnLeftTable)
                                        .addComponent(lblTable)
                                        .addComponent(btnRightTable)
                        )
                        .addGroup(
                                lC.createSequentialGroup()
                                        .addComponent(lblProductoTable)
                                        .addGroup(
                                                lC.createParallelGroup()
                                                        .addComponent(lblNombre)
                                                        .addComponent(txtNombre)
                                        )
                        )
                        .addComponent(btnAgregar)
        );
        return lC;
    }
}
