package Common.pages.pageView.administrivia;

import Components.Label;
import Components.pageView.Panels.ListPanel;
import Constants.Fonts;

import java.awt.Component;

import javax.swing.Box;

public class Profile extends ListPanel {
    public Profile(){
        add(new Label("Mufassir Ahmad Chowdhury", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(5));
        add(new Label("2019331073", Fonts.SUBTITLE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(5));
        add(new Label("Computer Science and Engineering", Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(5));
        add(new Label("2019-20", Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(5));
        add(new Label("01771144308", Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(5));
        add(new Label("mac22214u@gmail.com", Fonts.BODY_LARGE, Component.LEFT_ALIGNMENT));
        add(Box.createVerticalStrut(15));
    }
}
