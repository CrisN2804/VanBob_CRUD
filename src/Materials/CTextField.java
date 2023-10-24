package Materials;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class CTextField extends JTextField {
    public CTextField() {
        metodo();
    }
    public CTextField(int size, int fontSize){
        this.setFont(new Font("Serif", Font.PLAIN, fontSize));
        this.setHorizontalAlignment(JTextField.CENTER);
        ((AbstractDocument) this.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= size) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() + text.length() - length <= size) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }
    public CTextField(int size, int fontSize, boolean numberOnly){
        this.setFont(new Font("Serif", Font.PLAIN, fontSize));
        this.setHorizontalAlignment(JTextField.CENTER);
        if(numberOnly){
            ((AbstractDocument) this.getDocument()).setDocumentFilter(new DocumentFilter() {
                @Override
                public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                    if (fb.getDocument().getLength() + string.length() <= size && string.matches("\\d*")) {
                        super.insertString(fb, offset, string, attr);
                    }
                }

                @Override
                public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                    if (fb.getDocument().getLength() + text.length() - length <= size && text.matches("\\d*")) {
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            });
        }else{
            new CTextField(size, fontSize);
        }

    }
    public void metodo(){

    }
}
