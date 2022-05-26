package Components.InputFields;

import java.awt.Color;

import javax.swing.JComboBox;

import Constants.Colors;

public class ComboBox<E> extends JComboBox<E> {
    public ComboBox(E[] options){
        super(options);
        setBackground(new Color(50, 50, 50));
        setForeground(Colors.PLAIN_TEXT);
        setBorder(null);
    }
}
