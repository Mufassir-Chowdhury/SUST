package pages.pageView.misc.bus;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.GridBagConstraints;

import Components.Label;
import Constants.Fonts;

public class bus extends JPanel {
    public bus(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.add(new Label("Bus Schedule", Fonts.DISPLAY));
        add(title);
        add(Box.createVerticalStrut(20));

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
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 5);

        
        list.add(new informationPanel(), gbc);

        for(int i=1; i<=5; i++){
            gbc.gridx = i;
            gbc.gridy = 0;
            gbc.weighty = 1;
            gbc.weightx = 1;
            gbc.gridwidth = 1;
            list.add(new busItem("2"), gbc);
        }

        add(list);
        // gbc.gridx = 2;
        // gbc.gridy = 0;
        // gbc.weighty = 1;
        // gbc.weightx = 1;
        // gbc.gridwidth = 1;
        // list.add(new busItem("1"), gbc);

        // gbc.gridx = 3;
        // gbc.gridy = 0;
        // gbc.weighty = 1;
        // gbc.weightx = 1;
        // gbc.gridwidth = 1;
        // list.add(new busItem("1"), gbc);

        // gbc.gridx = 4;
        // gbc.gridy = 0;
        // gbc.weighty = 1;
        // gbc.weightx = 1;
        // gbc.gridwidth = 1;
        // list.add(new busItem("1"), gbc);

        // gbc.gridx = 5;
        // gbc.gridy = 0;
        // gbc.weighty = 1;
        // gbc.weightx = 1;
        // gbc.gridwidth = 1;
        // list.add(new busItem("1"), gbc);
        // add(list);
    }
}
