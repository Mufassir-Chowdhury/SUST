package Components.InputFields;

import javax.swing.JComboBox;

import Constants.Colors;

public class ComboBox<E> extends JComboBox<E> {
    public ComboBox(E[] options){
        super(options);
        setBackground(Colors.COMBO_BOX);
        setForeground(Colors.PLAIN_TEXT);
        setBorder(null);
    }
}
