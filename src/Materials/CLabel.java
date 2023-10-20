package Materials;

import javax.swing.*;
import java.awt.*;

public class CLabel extends JLabel {
    public CLabel(){
        super();
        this.setFont(new Font("Serif", Font.PLAIN, 20));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public CLabel(String text){
        this.setFont(new Font("Serif", Font.PLAIN, 20));
        this.setText(text);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
    public CLabel(String text, int fontSize){
        this.setFont(new Font("Serif", Font.PLAIN, fontSize));
        this.setText(text);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
