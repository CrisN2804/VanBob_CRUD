package Ventanas;

import Materials.CButton;
import Materials.CLabel;
import Ventanas.CRUD.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEleccionOpcion extends JFrame {
    CLabel lblBienvenida;
    CButton btnCreate, btnRead, btnDeleteUpdate;
    VentanaCreate wdwCreate = new VentanaCreate();
    VentanaRead wdwRead = new VentanaRead();
    VentanaDelete wdwDeleteUpdate = new VentanaDelete();
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
        btnDeleteUpdate = new CButton("Actualizar/Eliminar", sizeButtons);

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
                                        .addComponent(btnDeleteUpdate)
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
                                        .addComponent(btnDeleteUpdate)
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
            wdwDeleteUpdate.setVisible(false);
        });

        btnRead.addActionListener(e -> {
            wdwRead.setVisible(true);
            wdwCreate.setVisible(false);
            wdwDeleteUpdate.setVisible(false);
        });

        btnDeleteUpdate.addActionListener(e -> {
            wdwDeleteUpdate.setVisible(true);
            wdwCreate.setVisible(false);
            wdwRead.setVisible(false);
        });
    }
}
