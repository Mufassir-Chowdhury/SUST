package Components;

import javax.swing.JTextField;

import Constants.Colors;
import Constants.Fonts;
import Constants.Margins;
import Constants.Sizes;

import java.awt.Graphics;
import java.awt.Component;

public class RoundJTextField extends JTextField {
	private static final long serialVersionUID = 1L;
    private String placeholder;
    
    public RoundJTextField(String placeholder) {
        this.placeholder = placeholder;

        setOpaque(false);
        setText(placeholder);
        setSize(Sizes.TEXT_FIELD_SIZE);
        setMaximumSize(Sizes.TEXT_FIELD_SIZE);
        setMinimumSize(Sizes.TEXT_FIELD_SIZE);
        setForeground(Colors.PLAIN_TEXT);
        setFont(Fonts.PLAIN_TEXT);
        setMargin(Margins.TEXT_FIELD);
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    protected void paintComponent(Graphics g) {
         g.setColor(Colors.TEXT_FIELD_BACKGROUND);
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 4, 4);
         super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(Colors.TEXT_FIELD_BORDER);
        g.drawRoundRect(0, getHeight(), getWidth() - 1, 0, 0, 0);
    }
    
    public boolean checkPlaceholder()
    {
        return getText().equals(placeholder);
    }

    public boolean isEmpty()
    {
        return getText().isEmpty();
    }
    
    public void setPlaceholder()
    {
        setText(placeholder);
    }

    public void cleanField()
    {
        if (checkPlaceholder())
            setText("");
    }

}



