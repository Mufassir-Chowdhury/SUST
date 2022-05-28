package pages.pageView.updates.routine;

import Components.Buttons.AccentButton;
import Components.pageView.Panels.GridBagPanel;
import Components.pageView.Panels.InformationPanel;
import Components.pageView.Panels.ScrollPane;
import Components.pageView.Panels.ViewPort;
import Components.pageView.Panels.InformationPanel.Type;

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

        
        list.add(new InformationPanel("Your Courses", new AccentButton("Manage Courses") , Type.ROUTINE), gbc);
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
            list.add(new routineItem("2"), gbc);
        }
        add(new ScrollPane(list));
    }
}
