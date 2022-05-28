package Components;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import Constants.Colors;
import Constants.Fonts;

public class Label extends JLabel{
    public Label(String text){
        super(text);
        setFont(Fonts.Body);
        setForeground(Colors.PLAIN_TEXT);
    }
    public Label(String text, Font font){
        super(text);
        setForeground(Colors.PLAIN_TEXT);
        setFont(font);
    }
    public Label(String text, Font font, int alignment){
        super(text);
        setForeground(Colors.PLAIN_TEXT);
        setFont(font);
        setHorizontalTextPosition(alignment);
    }
    public Label(String text, Font font, Color color){
        super(text);
        setForeground(color);
        setFont(font);
    }
    public Label(String text, Font font, float alignment){
        super(text);
        setForeground(Colors.PLAIN_TEXT);
        setFont(font);
        setAlignmentX(alignment);
    }
}
