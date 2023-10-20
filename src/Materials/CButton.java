package Materials;

import javax.swing.*;
import java.awt.*;

public class CButton extends JButton {
    public CButton(String text){
        this.setFont(new Font("Serif", Font.PLAIN, 37));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setText(text);
    }
    public CButton(String text, int fontSize){
        this.setFont(new Font("Serif", Font.PLAIN, fontSize));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setText(text);
    }

}
