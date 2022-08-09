package Components.InputFields;

import javax.swing.JComboBox;
import java.awt.Component;

import Constants.Colors;

public class ComboBox<E> extends JComboBox<E> {
    public ComboBox(E[] options){
        super(options);
        setBackground(Colors.COMBO_BOX);
        setForeground(Colors.PLAIN_TEXT);
        setBorder(null);
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
