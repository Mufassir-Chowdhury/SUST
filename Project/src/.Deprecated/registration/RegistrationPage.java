package Deprecated.registration;

import java.awt.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Constants.Padding;

public class RegistrationPage extends JPanel {

    public Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    private Dimension frameSize = new Dimension(700, 300);

    private int locationX() {
        return (int) (size.getWidth() - frameSize.getWidth()) / 2;
    }

    private int locationY() {
        return (int) (size.getHeight() - frameSize.getHeight()) / 2;
    }

    public RegistrationPage() {
        setLocation(locationX(), locationY());
        setSize(frameSize);
        setBackground(Color.GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box line = Box.createHorizontalBox();
        // for (int i = 1; i <= Datapoints.CLIENT.length; i++)
        // {
        // Datapoints.Page pair = Datapoints.CLIENT[i-1];
        // line.add(new Card(20, pair.name, pair.icon, Color.white));
        // if (i != Datapoints.CLIENT.length)
        // line.add(Box.createHorizontalStrut(Sizes.CARD_SPACING_LONG));
        // }

        add(Box.createVerticalStrut(Padding.CARD_SPACING_LONG));
        add(line);
        add(Box.createVerticalStrut(Padding.CARD_SPACING_LONG));
    }

}
