package pages.pageView.updates.routine;

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

public class routine extends JPanel{
    public routine(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.add(new Label("Class Routine", Fonts.DISPLAY));
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
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 5, 5, 5);

        
        list.add(new informationPanel(), gbc);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = .5;
        gbc.gridwidth = 1;
        JPanel panel2 = new JPanel();
        panel2.add(new Label("text", Fonts.DISPLAY));
        panel2.setBackground(Color.GRAY);
        list.add(panel2, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        JPanel panel3 = new JPanel();
        panel3.add(new Label("text", Fonts.DISPLAY));
        panel3.setBackground(Color.GREEN);
        list.add(panel3, gbc);

        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        JPanel panel4 = new JPanel();
        panel4.add(new Label("text", Fonts.DISPLAY));
        panel4.setBackground(Color.ORANGE);
        list.add(panel4, gbc);

        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        JPanel panel5 = new JPanel();
        panel5.add(new Label("text", Fonts.DISPLAY));
        panel5.setBackground(Color.PINK);
        list.add(panel5, gbc);
        add(list);
    }
}
