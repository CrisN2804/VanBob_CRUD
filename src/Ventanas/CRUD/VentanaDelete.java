package Ventanas.CRUD;

import BaseDeDatos.BaseDatos;
import Materials.*;
import Modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaDelete extends JFrame {
    //region stuff
    private JPanel cards;
    private CardLayout cardLayout;
    CButton prevButton, nextButton;
    String opcionesTable[] = {"Cliente", "Departamento", "Empleado", "Ordena", "Producto"};
    CLabel lblTable;
    int navegadorTABLE=0;
    //endregion
    BaseDatos BD = new BaseDatos();
    int x=0, years=0;
    List<Cliente> clientes;
    Cliente cliente;
    List<Departamento> departamentos;
    Departamento departamento;
    List<Empleado> empleados;
    Empleado empleado;
    List<Orden> ordenes;
    Orden orden;
    List<Producto> productos;
    Producto producto;
    public VentanaDelete(){
        initialize();
        funciones();
        setLayout();

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void initialize(){
        prevButton = new CButton("<", 20);
        nextButton = new CButton(">", 20);

        lblTable = new CLabel(opcionesTable[navegadorTABLE], 20);

        clientes = BD.leerTodosCliente();
        departamentos = BD.leerTodosDepartamentos();
        empleados = BD.leerTodosEmpleados();
        ordenes = BD.leerTodasOrdenes();
        productos = BD.leerTodosProductos();

        cards = new JPanel(new CardLayout());
        cardLayout = (CardLayout) cards.getLayout();
        cards.add(cliente(), "Cliente");
        cards.add(departamento(), "Departamento");
        cards.add(empleado(), "Empleado");
        cards.add(ordena(), "Ordena");
        cards.add(producto(), "Producto");
    }
    void funciones(){
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(navegadorTABLE!=0){
                    navegadorTABLE--;
                }else{
                    navegadorTABLE = (opcionesTable.length)-1;
                }
                lblTable.setText(opcionesTable[navegadorTABLE]);
                cardLayout.previous(cards);
                pack();
                setLocationRelativeTo(null);
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(navegadorTABLE != (opcionesTable.length)-1){
                    navegadorTABLE++;
                }else{
                    navegadorTABLE=0;
                }
                lblTable.setText(opcionesTable[navegadorTABLE]);
                cardLayout.next(cards);
                pack();
                setLocationRelativeTo(null);
            }
        });
    }
    void setLayout(){
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(prevButton)
                                        .addComponent(lblTable, 130, 130, 130)
                                        .addComponent(nextButton)
                        )
                        .addComponent(cards)
        );


        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(prevButton)
                                        .addComponent(lblTable)
                                        .addComponent(nextButton)
                        )
                        .addComponent(cards)
        );
    }

    JPanel cliente(){
        JPanel aux = new JPanel();
        x=0;
        cliente = clientes.get(x);
        //region front
        CLabel lblID, lblIdShow, lblNombre, lblLealtad, lblYears;
        CTextField txtNombre;
        CButton btnDelete, btnLeft, btnMinus, btnMore, btnRight, btnSave;
        lblID = new CLabel("ID:", 20);
        lblIdShow = new CLabel(String.valueOf(cliente.getIdCliente()), 20);
        lblNombre = new CLabel("Nombre:", 20);
        lblLealtad = new CLabel("Lealtad:", 20);
        lblYears = new CLabel(String.valueOf(years), 20);
        txtNombre = new CTextField(20, 20);
        btnDelete = new CButton("B", 10);
        btnLeft = new CButton("<", 20);
        btnMinus = new CButton("-", 20);
        btnMore = new CButton("+", 20);
        btnRight = new CButton(">", 20);
        btnSave = new CButton("Save", 20);
        txtNombre.setText(cliente.getNombre());
        GroupLayout gl = new GroupLayout(aux);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        aux.setLayout(gl);
        gl.setHorizontalGroup(
                gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblID)
                                        .addComponent(lblIdShow)
                                        .addGap(140)
                                        .addComponent(btnDelete)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre, 100, 300, 400)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblLealtad)
                                        .addComponent(btnMinus)
                                        .addComponent(lblYears)
                                        .addComponent(btnMore)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(btnLeft)
                                        .addComponent(btnSave)
                                        .addComponent(btnRight)
                        )
        );
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblID)
                                        .addComponent(lblIdShow)
                                        .addComponent(btnDelete)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblLealtad)
                                        .addComponent(btnMinus)
                                        .addComponent(lblYears)
                                        .addComponent(btnMore)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(btnLeft)
                                        .addComponent(btnSave)
                                        .addComponent(btnRight)
                        )
        );
        //endregion
        years = cliente.getLealtad();
        lblYears.setText(String.valueOf(years));
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientes = BD.leerTodosCliente();
                if(!clientes.isEmpty()){
                    if(x != clientes.size()-1){
                        x++;
                    }else{
                        x=0;
                    }
                }
                cliente = clientes.get(x);
                years = cliente.getLealtad();
                lblIdShow.setText(String.valueOf(cliente.getIdCliente()));
                txtNombre.setText(cliente.getNombre());
                lblYears.setText(String.valueOf(years));
            }
        });
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientes = BD.leerTodosCliente();
                if(!clientes.isEmpty()){
                    if(x!=0){
                        x--;
                    }else{
                        x=clientes.size()-1;
                    }
                }
                cliente = clientes.get(x);
                years=cliente.getLealtad();
                lblIdShow.setText(String.valueOf(cliente.getIdCliente()));
                txtNombre.setText(cliente.getNombre());
                lblYears.setText(String.valueOf(years));
            }
        });
        btnMinus.addActionListener(e -> {
            if(years > 0){
                years--;
            }else{
                years=99;
            }
            lblYears.setText(String.valueOf(years));
        });
        btnMore.addActionListener(e -> {
            if (years < 99){
                years++;
            }else{
                years=0;
            }
            lblYears.setText(String.valueOf(years));
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(lblIdShow.getText());
                int anos = Integer.parseInt(lblYears.getText());
                cliente = new Cliente(id, txtNombre.getText(), anos);
                if(!clientes.isEmpty()){
                    boolean res = BD.actualizarCliente(cliente);
                    if(res){
                        System.out.println("Se ejecutó la actualizacion");
                    }else{
                        System.out.println("No se ejecutó la actualización");
                    }
                    clientes = BD.leerTodosCliente();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!clientes.isEmpty()){
                    int id = Integer.parseInt(lblIdShow.getText());
                    BD.borrarCliente(id);
                    clientes = BD.leerTodosCliente();
                    if(x == clientes.size()){
                        x--;
                    }
                    if(!clientes.isEmpty()){
                        cliente = clientes.get(x);
                        years = cliente.getLealtad();
                        lblIdShow.setText(String.valueOf(cliente.getIdCliente()));
                        txtNombre.setText(cliente.getNombre());
                        lblYears.setText(String.valueOf(years));
                    }
                }
            }
        });
        return aux;
    }
    JPanel departamento(){
        JPanel aux = new JPanel();
        x=0;
        departamento = departamentos.get(x);
        CLabel lblID, lblIdShow, lblNombre;
        CTextField txtNombre;
        CButton btnDelete, btnLeft, btnRight, btnSave;
        lblID = new CLabel("ID:", 20);
        lblIdShow = new CLabel(String.valueOf(departamento.getIdDepartamento()), 20);
        lblNombre = new CLabel("Nombre:", 20);
        txtNombre = new CTextField(100, 20);
        btnDelete = new CButton("B", 10);
        btnLeft = new CButton("<", 20);
        btnRight = new CButton(">", 20);
        btnSave = new CButton("Save", 20);
        txtNombre.setText(cliente.getNombre());
        //region layout
        GroupLayout gl = new GroupLayout(aux);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setHorizontalGroup(
                gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblID)
                                        .addComponent(lblIdShow)
                                        .addGap(140)
                                        .addComponent(btnDelete)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre,  100, 300, 400)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(btnLeft)
                                        .addComponent(btnSave)
                                        .addComponent(btnRight)
                        )
        );
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblID)
                                        .addComponent(lblIdShow)
                                        .addComponent(btnDelete)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(btnLeft)
                                        .addComponent(btnSave)
                                        .addComponent(btnRight)
                        )
        );
        aux.setLayout(gl);
        //endregion
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                departamentos = BD.leerTodosDepartamentos();
                if(!departamentos.isEmpty()){
                    if(x != departamentos.size()-1){
                        x++;
                    }else{
                        x=0;
                    }
                }
                departamento = departamentos.get(x);
                lblIdShow.setText(String.valueOf(departamento.getIdDepartamento()));
                txtNombre.setText(departamento.getDepartamento());
            }
        });
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                departamentos = BD.leerTodosDepartamentos();
                if(!departamentos.isEmpty()){
                    if(x!=0){
                        x--;
                    }else{
                        x=departamentos.size()-1;
                    }
                }
                departamento = departamentos.get(x);
                lblIdShow.setText(String.valueOf(departamento.getIdDepartamento()));
                txtNombre.setText(departamento.getDepartamento());
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(lblIdShow.getText());
                departamento = new Departamento(id, txtNombre.getText());
                if(!departamentos.isEmpty()){
                    boolean res = BD.actualizarDepartamento(departamento);
                    if(res){
                        System.out.println("Se ejecutó la actualizacion");
                    }else{
                        System.out.println("No se ejecutó la actualización");
                    }
                    departamentos= BD.leerTodosDepartamentos();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!departamentos.isEmpty()){
                    int id = Integer.parseInt(lblIdShow.getText());
                    BD.borrarDepartamento(id);
                    departamentos = BD.leerTodosDepartamentos();
                    if(x == departamentos.size()){
                        x--;
                    }
                    if(!departamentos.isEmpty()){
                        departamento = departamentos.get(x);
                        lblIdShow.setText(String.valueOf(departamento.getIdDepartamento()));
                        txtNombre.setText(departamento.getDepartamento());
                    }
                }
            }
        });
        return aux;
    }
    JPanel empleado(){
        JPanel aux = new JPanel();
        x=0;
        int y = 0;
        empleado = empleados.get(x);
        CLabel lblID, lblIdShow, lblDepartamento, lblNombre, lblApellido;
        CTextField txtNombre, txtApellido;
        JComboBox pickDepartamento;
        CButton btnSave, btnDelete, btnLeft, btnRight;
        String[] opcionesDepartamentos = new String[departamentos.size()];
        for (Departamento depa: departamentos) {
            opcionesDepartamentos[y] = depa.getDepartamento();
            y++;
        }
        lblID = new CLabel("ID:", 20);
        lblIdShow = new CLabel(String.valueOf(empleado.getIdEmpleado()), 20);
        lblDepartamento = new CLabel("Departamento:", 20);
        lblNombre = new CLabel("Nombre:", 20);
        lblApellido = new CLabel("Apellido:", 20);
        txtNombre = new CTextField(100, 20);
        txtApellido = new CTextField(100, 20);
        btnDelete = new CButton("B", 10);
        btnLeft = new CButton("<", 20);
        btnRight = new CButton(">", 20);
        btnSave = new CButton("Save", 20);
        pickDepartamento = new JComboBox(opcionesDepartamentos);
        for(Departamento depa : departamentos){
            if(depa.getIdDepartamento() == empleado.getIdDepartamento()){
                pickDepartamento.setSelectedItem(depa.getDepartamento());
                break;
            }
        }
        txtNombre.setText(empleado.getNombre());
        txtApellido.setText(empleado.getApellido());
        GroupLayout gl = new GroupLayout(aux);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setHorizontalGroup(
                gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblID)
                                        .addComponent(lblIdShow)
                                        .addGap(140)
                                        .addComponent(btnDelete)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblDepartamento)
                                        .addComponent(pickDepartamento)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblApellido)
                                        .addComponent(txtApellido)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(btnLeft)
                                        .addComponent(btnSave)
                                        .addComponent(btnRight)
                        )
        );
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblID)
                                        .addComponent(lblIdShow)
                                        .addComponent(btnDelete)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblDepartamento)
                                        .addComponent(pickDepartamento)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblApellido)
                                        .addComponent(txtApellido)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(btnLeft)
                                        .addComponent(btnSave)
                                        .addComponent(btnRight)
                        )
        );
        aux.setLayout(gl);
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empleados = BD.leerTodosEmpleados();
                if(!empleados.isEmpty()){
                    if(x != empleados.size()-1){
                        x++;
                    }else{
                        x=0;
                    }
                }
                empleado = empleados.get(x);
                lblIdShow.setText(String.valueOf(empleado.getIdEmpleado()));
                txtNombre.setText(empleado.getNombre());
                txtApellido.setText(empleado.getApellido());
                for(Departamento depa : departamentos){
                    if(depa.getIdDepartamento() == empleado.getIdDepartamento()){
                        pickDepartamento.setSelectedItem(depa.getDepartamento());
                        break;
                    }
                }
            }
        });
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empleados = BD.leerTodosEmpleados();
                if(!empleados.isEmpty()){
                    if(x!=0){
                        x--;
                    }else{
                        x=empleados.size()-1;
                    }
                }
                empleado = empleados.get(x);
                lblIdShow.setText(String.valueOf(empleado.getIdEmpleado()));
                txtNombre.setText(empleado.getNombre());
                txtApellido.setText(empleado.getApellido());
                for(Departamento depa : departamentos){
                    if(depa.getIdDepartamento() == empleado.getIdDepartamento()){
                        pickDepartamento.setSelectedItem(depa.getDepartamento());
                        break;
                    }
                }
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(lblIdShow.getText());
                int idDepa=0;
                for(Departamento depa : departamentos){
                    if(depa.getDepartamento().equals(pickDepartamento.getSelectedItem())){
                        idDepa = depa.getIdDepartamento();
                        break;
                    }
                }
                empleado = new Empleado(id, idDepa, txtNombre.getText(), txtApellido.getText());
                if(!empleados.isEmpty()){
                    boolean res = BD.actualizarEmpleado(empleado);
                    if(res){
                        System.out.println("Se ejecutó la actualizacion");
                    }else{
                        System.out.println("No se ejecutó la actualización");
                    }
                    empleados= BD.leerTodosEmpleados();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!empleados.isEmpty()){
                    int id = Integer.parseInt(lblIdShow.getText());
                    BD.borrarEmpleado(id);
                    empleados = BD.leerTodosEmpleados();
                    if(x == empleados.size()){
                        x--;
                    }
                    if(!empleados.isEmpty()){
                        empleado = empleados.get(x);
                        lblIdShow.setText(String.valueOf(empleado.getIdEmpleado()));
                        txtNombre.setText(empleado.getNombre());
                        txtApellido.setText(empleado.getApellido());
                        for(Departamento depa : departamentos){
                            if(depa.getIdDepartamento() == empleado.getIdDepartamento()){
                                pickDepartamento.setSelectedItem(depa.getDepartamento());
                                break;
                            }
                        }
                    }
                }
            }
        });
        return aux;
    }
    JPanel ordena(){
        JPanel aux = new JPanel();
        int y=0;
        x=0;
        CLabel lblID, lblIdShow, lblCliente, lblProducto, lblCantidad;
        JComboBox pickCliente, pickProducto;
        CTextField txtCantidad;
        CButton btnDelete, btnSave, btnLeft, btnRight;
        orden = ordenes.get(x);
        String[] opcionesClientes = new String[clientes.size()];
        for (Cliente cliente1: clientes) {
            opcionesClientes[y] = cliente1.getNombre();
            y++;
        }
        y=0;
        String[] opcionesProductos = new String[productos.size()];
        for(Producto producto1 : productos){
            opcionesProductos[y] = producto1.getNombre();
            y++;
        }
        lblID = new CLabel("ID:", 20);
        lblIdShow = new CLabel(String.valueOf(orden.getIdOrden()), 20);
        lblCliente = new CLabel("Cliente:", 20);
        lblProducto = new CLabel("Producto:", 20);
        lblCantidad = new CLabel("Cantidad:", 20);
        txtCantidad = new CTextField(100, 20, true);
        btnDelete = new CButton("B", 10);
        btnLeft = new CButton("<", 20);
        btnRight = new CButton(">", 20);
        btnSave = new CButton("Save", 20);
        pickCliente = new JComboBox(opcionesClientes);
        pickProducto = new JComboBox(opcionesProductos);
        for(Cliente cliente1 : clientes){
            if(cliente1.getIdCliente() == orden.getIdCliente()){
                pickCliente.setSelectedItem(cliente1.getNombre());
            }
        }
        for(Producto producto1 : productos){
            if(producto1.getIdProducto() == orden.getIdProducto()){
                pickProducto.setSelectedItem(producto1.getNombre());
            }
        }
        txtCantidad.setText(String.valueOf(orden.getPedido()));
        GroupLayout gl = new GroupLayout(aux);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setHorizontalGroup(
                gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblID)
                                        .addComponent(lblIdShow)
                                        .addGap(140)
                                        .addComponent(btnDelete)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblCliente)
                                        .addComponent(pickCliente)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblProducto)
                                        .addComponent(pickProducto)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblCantidad)
                                        .addComponent(txtCantidad)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(btnLeft)
                                        .addComponent(btnSave)
                                        .addComponent(btnRight)
                        )
        );
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblID)
                                        .addComponent(lblIdShow)
                                        .addComponent(btnDelete)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblCliente)
                                        .addComponent(pickCliente)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblProducto)
                                        .addComponent(pickProducto)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblCantidad)
                                        .addComponent(txtCantidad)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(btnLeft)
                                        .addComponent(btnSave)
                                        .addComponent(btnRight)
                        )
        );
        aux.setLayout(gl);
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenes = BD.leerTodasOrdenes();
                if(!ordenes.isEmpty()){
                    if(x != ordenes.size()-1){
                        x++;
                    }else{
                        x=0;
                    }
                }
                orden = ordenes.get(x);
                lblIdShow.setText(String.valueOf(orden.getIdOrden()));
                txtCantidad.setText(String.valueOf(orden.getPedido()));
                int y=0;
                for (Cliente cliente1: clientes) {
                    if(cliente1.getIdCliente() == orden.getIdCliente()){
                        pickCliente.setSelectedItem(cliente1.getNombre());
                    }
                }
                for(Producto producto1 : productos){
                    if(producto1.getIdProducto() == orden.getIdProducto()){
                        pickProducto.setSelectedItem(producto1.getNombre());
                    }
                }
            }
        });
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenes = BD.leerTodasOrdenes();
                if(!ordenes.isEmpty()){
                    if(x!=0){
                        x--;
                    }else{
                        x=ordenes.size()-1;
                    }
                }
                orden = ordenes.get(x);
                lblIdShow.setText(String.valueOf(orden.getIdOrden()));
                txtCantidad.setText(String.valueOf(orden.getPedido()));
                int y=0;
                for (Cliente cliente1: clientes) {
                    if(cliente1.getIdCliente() == orden.getIdCliente()){
                        pickCliente.setSelectedItem(cliente1.getNombre());
                    }
                }
                for(Producto producto1 : productos){
                    if(producto1.getIdProducto() == orden.getIdProducto()){
                        pickProducto.setSelectedItem(producto1.getNombre());
                    }
                }
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(lblIdShow.getText());
                int idCliente=0, idProducto=0;
                long pedido = Long.parseLong(txtCantidad.getText());
                for(Cliente cliente1 : clientes){
                    if(cliente1.getNombre().equals(pickCliente.getSelectedItem())){
                        idCliente = cliente1.getIdCliente();
                        break;
                    }
                }
                for(Producto producto1 : productos){
                    if(producto1.getNombre().equals(pickProducto.getSelectedItem())){
                        idProducto = producto1.getIdProducto();
                        break;
                    }
                }
                orden = new Orden(id, idCliente, idProducto, pedido);
                if(!ordenes.isEmpty()){
                    boolean res = BD.actualizarOrden(orden);
                    if(res){
                        System.out.println("Se ejecutó la actualizacion");
                    }else{
                        System.out.println("No se ejecutó la actualización");
                    }
                    ordenes= BD.leerTodasOrdenes();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!ordenes.isEmpty()){
                    int id = Integer.parseInt(lblIdShow.getText());
                    BD.borrarOrden(id);
                    ordenes = BD.leerTodasOrdenes();
                    if(x == ordenes.size()){
                        x--;
                    }
                    if(!ordenes.isEmpty()){
                        orden = ordenes.get(x);
                        lblIdShow.setText(String.valueOf(orden.getIdOrden()));
                        txtCantidad.setText(String.valueOf(orden.getPedido()));
                        int y=0;
                        for (Cliente cliente1: clientes) {
                            if(cliente1.getIdCliente() == orden.getIdCliente()){
                                pickCliente.setSelectedItem(cliente1.getNombre());
                            }
                        }
                        for(Producto producto1 : productos){
                            if(producto1.getIdProducto() == orden.getIdProducto()){
                                pickProducto.setSelectedItem(producto1.getNombre());
                            }
                        }
                    }
                }
            }
        });
        return aux;
    }
    JPanel producto(){
        JPanel aux = new JPanel();
        x=0;
        producto = productos.get(x);
        CLabel lblID, lblIdShow, lblNombre, lblExistentes, lblProduciendo;
        CTextField txtNombre;
        SpinnerNumberModel spinnerModelExistentes, spinnerModelProduciendo;
        JSpinner spinnerExistentes, spinnerProduciendo;
        CButton btnDelete, btnSave, btnLeft, btnRight;
        lblID = new CLabel("ID:", 20);
        lblIdShow = new CLabel(String.valueOf(producto.getIdProducto()), 20);
        lblNombre = new CLabel("Nombre:", 20);
        lblExistentes = new CLabel("Existentes:", 20);
        lblProduciendo = new CLabel("Produciendo:", 20);
        txtNombre = new CTextField(100, 20);
        spinnerModelExistentes = new SpinnerNumberModel(0, 0, 10000000, 1);
        spinnerModelProduciendo = new SpinnerNumberModel(0,0,10000000, 1);
        spinnerExistentes = new JSpinner(spinnerModelExistentes);
        spinnerProduciendo = new JSpinner(spinnerModelProduciendo);
        btnDelete = new CButton("B", 10);
        btnLeft = new CButton("<", 20);
        btnRight = new CButton(">", 20);
        btnSave = new CButton("Save", 20);
        txtNombre.setText(producto.getNombre());
        spinnerExistentes.setValue(producto.getExistentes());
        spinnerProduciendo.setValue(producto.getProduciendo());
        GroupLayout gl = new GroupLayout(aux);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);
        gl.setHorizontalGroup(
                gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblID)
                                        .addComponent(lblIdShow)
                                        .addGap(140)
                                        .addComponent(btnDelete)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblExistentes)
                                        .addComponent(spinnerExistentes)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblProduciendo)
                                        .addComponent(spinnerProduciendo)
                        )
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(btnLeft)
                                        .addComponent(btnSave)
                                        .addComponent(btnRight)
                        )
        );
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblID)
                                        .addComponent(lblIdShow)
                                        .addComponent(btnDelete)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblNombre)
                                        .addComponent(txtNombre)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblExistentes)
                                        .addComponent(spinnerExistentes)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblProduciendo)
                                        .addComponent(spinnerProduciendo)
                        )
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(btnLeft)
                                        .addComponent(btnSave)
                                        .addComponent(btnRight)
                        )
        );
        aux.setLayout(gl);

        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productos = BD.leerTodosProductos();
                if(!productos.isEmpty()){
                    if(x != productos.size()-1){
                        x++;
                    }else{
                        x=0;
                    }
                }
                producto = productos.get(x);
                lblIdShow.setText(String.valueOf(producto.getIdProducto()));
                txtNombre.setText(producto.getNombre());
                spinnerExistentes.setValue(producto.getExistentes());
                spinnerProduciendo.setValue(producto.getProduciendo());
            }
        });
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productos = BD.leerTodosProductos();
                if(!productos.isEmpty()){
                    if(x!=0){
                        x--;
                    }else{
                        x=productos.size()-1;
                    }
                }
                producto = productos.get(x);
                lblIdShow.setText(String.valueOf(producto.getIdProducto()));
                txtNombre.setText(producto.getNombre());
                spinnerExistentes.setValue(producto.getExistentes());
                spinnerProduciendo.setValue(producto.getProduciendo());
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(lblIdShow.getText());
                Integer existentes = (Integer) spinnerExistentes.getValue();
                Integer produciendo = (Integer) spinnerProduciendo.getValue();
                producto = new Producto(id, txtNombre.getText(), existentes.longValue(), produciendo.longValue());
                if(!productos.isEmpty()){
                    boolean res = BD.actualizarProducto(producto);
                    if(res){
                        System.out.println("Se ejecutó la actualizacion");
                    }else{
                        System.out.println("No se ejecutó la actualización");
                    }
                    productos = BD.leerTodosProductos();
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!productos.isEmpty()){
                    int id = Integer.parseInt(lblIdShow.getText());
                    BD.borrarProducto(id);
                    ordenes = BD.leerTodasOrdenes();
                    if(x == productos.size()){
                        x--;
                    }
                    if(!productos.isEmpty()){
                        producto = productos.get(x);
                        lblIdShow.setText(String.valueOf(producto.getIdProducto()));
                        txtNombre.setText(producto.getNombre());
                        spinnerExistentes.setValue(producto.getExistentes());
                        spinnerProduciendo.setValue(producto.getProduciendo());
                    }
                }
            }
        });

        return aux;
    }
}
