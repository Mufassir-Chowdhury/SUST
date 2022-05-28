package pages.pageView.updates.routine;

import javax.swing.JPanel;

import Components.pageView.Panels.ScrollPane;
import Components.pageView.Panels.ViewPort;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

public class routine extends ViewPort{
    public routine(){
        super("Class Routine", null);

        JPanel list = new JPanel();
        list.setOpaque(false);
        list.setAlignmentX(Component.LEFT_ALIGNMENT);
        list.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);

        
        list.add(new informationPanel(), gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = .5;
        gbc.gridwidth = 1;
        list.add(new timeline(), gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        list.add(new routineItem("2"), gbc);

        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        list.add(new routineItem("1"), gbc);

        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        list.add(new routineItem("1"), gbc);
        add(new ScrollPane(list));
    }
}
