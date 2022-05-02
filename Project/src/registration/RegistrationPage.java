package registration;

import java.awt.*;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Components.Background;
import Components.RoundedPanel;
import Components.TitleBar;
import Constants.Icons;
import Constants.Navigation;
import Constants.Sizes;
public class RegistrationPage extends JPanel {
    

    public Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    private Dimension frameSize = new Dimension(700, 300);
    // private TitleBar titleBar = new TitleBar(frame, (int)size.getWidth());
    
    private int locationX() {
        return (int) (size.getWidth() - frameSize.getWidth()) / 2;
    }

    private int locationY(){
        return (int) (size.getHeight() - frameSize.getHeight()) / 2;
    }

    public RegistrationPage() {
        setLocation(locationX(), locationY());
        setSize(frameSize);
        setBackground(Color.GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box line = Box.createHorizontalBox();
        for (int i = 1; i <= Navigation.CLIENT.length; i++)
        {
            Navigation.Page pair = Navigation.CLIENT[i-1];
            line.add(new Card(20, pair.name, pair.icon, Color.white));
            if (i != Navigation.CLIENT.length)
                line.add(Box.createHorizontalStrut(Sizes.CARD_SPACING_LONG));
        }

        add(Box.createVerticalStrut(Sizes.CARD_SPACING_LONG));
        add(line);
        add(Box.createVerticalStrut(Sizes.CARD_SPACING_LONG));
    }
    
}
