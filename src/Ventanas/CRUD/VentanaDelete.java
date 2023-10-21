package Ventanas.CRUD;

import Materials.CButton;
import Materials.CLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDelete extends JFrame {
    //region stuff
    private JPanel cards;
    private CardLayout cardLayout;
    CButton prevButton, nextButton;
    String opcionesTable[] = {"Cliente", "Contacto", "Departamento", "Empleado", "Ordena", "Producto"};
    CLabel lblTable;
    int navegadorTABLE=0;
    //endregion
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
        cards.add(cliente(), "1");
        cards.add(contacto(), "2");
        cards.add(departamento(), "3");
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
        JLabel lblHola = new JLabel("Hola");
        JTextField txtHola = new JTextField();
        JButton btnHola = new JButton("Press me");
        GroupLayout gl = new GroupLayout(aux);
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        aux.setLayout(gl);

        gl.setHorizontalGroup(
                gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(
                                gl.createSequentialGroup()
                                        .addComponent(lblHola)
                                        .addComponent(txtHola)
                        )
                        .addComponent(btnHola)
        );
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addGroup(
                                gl.createParallelGroup()
                                        .addComponent(lblHola)
                                        .addComponent(txtHola)
                        )
                        .addComponent(btnHola)
        );
        btnHola.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtHola.setText("Soy Crislex");
            }
        });
        return aux;
    }

    JPanel contacto(){
        JPanel aux = new JPanel();
        JLabel lblHey = new JLabel("Hey");
        aux.add(lblHey);
        return aux;
    }

    JPanel departamento(){
        JPanel aux = new JPanel();
        JLabel lblHalo = new JLabel("Halo");
        aux.add(lblHalo);
        return aux;
    }
}
