package mainView;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.Buttons.AccentButton;
import Components.Buttons.HyperLinkButton;
import Constants.Colors;

class DashBoard extends JPanel {
    public DashBoard(){
        setBackground(Colors.PLAIN_TEXT);
        JLabel label = new JLabel("Dashboard");
        add(label);
    }
}
