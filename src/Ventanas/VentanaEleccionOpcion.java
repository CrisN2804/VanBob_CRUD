package Ventanas;

import Materials.CButton;
import Materials.CLabel;
import Ventanas.CRUD.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEleccionOpcion extends JFrame {
    CLabel lblBienvenida;
    CButton btnCreate, btnRead, btnUpdate, btnDelete;
    VentanaCreate wdwCreate = new VentanaCreate();
    VentanaRead wdwRead = new VentanaRead();
    VentanaUpdate wdwUpdate = new VentanaUpdate();
    VentanaDelete wdwDelete = new VentanaDelete();
    public VentanaEleccionOpcion(){
        super("Menú");
        creacionVentana();
        funcionalidades();
    }
    void creacionVentana(){
        int sizeButtons = 25;
        lblBienvenida = new CLabel("¿Que deseas hacer?", 40);
        btnCreate = new CButton("Crear", sizeButtons);
        btnRead = new CButton("Leer", sizeButtons);
        btnUpdate = new CButton("Actualizar", sizeButtons);
        btnDelete = new CButton("Eliminar", sizeButtons);

        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.setAutoCreateGaps(true);

        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lblBienvenida)
                        .addGroup(
                                groupLayout.createSequentialGroup()
                                        .addComponent(btnCreate)
                                        .addComponent(btnRead)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnDelete)
                        )
        );
        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGap(30)
                        .addGroup(
                                groupLayout.createParallelGroup()
                                        .addComponent(btnCreate)
                                        .addComponent(btnRead)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnDelete)
                        )
        );
        setLayout(groupLayout);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    void funcionalidades(){
        btnCreate.addActionListener(e -> {
            wdwCreate.setVisible(true);
            wdwRead.setVisible(false);
            wdwUpdate.setVisible(false);
            wdwDelete.setVisible(false);
        });

        btnRead.addActionListener(e -> {
            wdwRead.setVisible(true);
            wdwCreate.setVisible(false);
            wdwUpdate.setVisible(false);
            wdwDelete.setVisible(false);
        });

        btnUpdate.addActionListener(e -> {
            wdwUpdate.setVisible(true);
            wdwCreate.setVisible(false);
            wdwRead.setVisible(false);
            wdwDelete.setVisible(false);
        });

        btnDelete.addActionListener(e -> {
            wdwDelete.setVisible(true);
            wdwCreate.setVisible(false);
            wdwRead.setVisible(false);
            wdwUpdate.setVisible(false);
        });
    }
}
