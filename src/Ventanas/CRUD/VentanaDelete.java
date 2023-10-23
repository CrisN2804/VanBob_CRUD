package Ventanas.CRUD;

import BaseDeDatos.BaseDatos;
import Materials.CButton;
import Materials.CLabel;
import Materials.CTextField;
import Modelo.Cliente;

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
        clientes = BD.leerTodosCliente();
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
        JLabel lblHalo = new JLabel("Halo");
        aux.add(lblHalo);
        return aux;
    }
    JPanel empleado(){
        JPanel aux = new JPanel();
        return aux;
    }
    JPanel ordena(){
        JPanel aux = new JPanel();
        return aux;
    }
    JPanel producto(){
        JPanel aux = new JPanel();
        return aux;
    }
}
