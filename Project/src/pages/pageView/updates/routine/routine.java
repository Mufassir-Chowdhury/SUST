package pages.pageView.updates.routine;

import Components.Label;
import Components.Buttons.AccentButton;
import Components.pageView.Box.Title;
import Components.pageView.Panels.Column;
import Components.pageView.Panels.GridBagPanel;
import Components.pageView.Panels.InformationPanel;
import Components.pageView.Panels.ScrollPane;
import Components.pageView.Panels.ViewPort;
import Constants.Fonts;
import Server.Datapoints;
import pages.pageView.misc.bus.Day;

import java.awt.Insets;
import java.awt.GridBagConstraints;

public class routine extends ViewPort{
    public routine(){
        super("Class Routine", null);

        GridBagPanel list = new GridBagPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 5, 5);

        
        list.add(new InformationPanel("Your Courses", new AccentButton("Manage Courses") , Datapoints.getInstance().COURSES), gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = .5;
        gbc.gridwidth = 1;
        list.add(new timeline(), gbc);

        for(int i=3; i<=7; i+=2){
            gbc.gridx = i;
            gbc.gridy = 0;
            gbc.weighty = 1;
            gbc.weightx = 1;
            gbc.gridwidth = 2;
            list.add(new Column(new Title("Tuesday", Fonts.SUBTITLE, new Label("Date")), new Day("2")), gbc);
        }
        add(new ScrollPane(list));
    }
}
