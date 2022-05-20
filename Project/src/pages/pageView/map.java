package pages.pageView;

import javax.swing.JPanel;

import Components.Label;
import Constants.Fonts;

public class map extends JPanel {
    public map(){
        add(new Label("map", Fonts.DISPLAY));
    }
}
