package pages.pageView;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

import Components.Card;
import Components.Label;
import Components.Buttons.AccentButton;

import java.awt.Component;
import Constants.Colors;
import Constants.Fonts;
import Constants.Icons;

public class resources extends JPanel {
    public resources(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.add(new Label("Resources", Fonts.DISPLAY));
        title.add(Box.createHorizontalGlue());
        AccentButton addStudent = new AccentButton("Post New Material");
        title.add(addStudent);
        add(title);
        add(Box.createVerticalStrut(20));

        Box options = Box.createHorizontalBox();
        options.setAlignmentX(Component.LEFT_ALIGNMENT);
        JComboBox<String> filter = new JComboBox<>();
        filter.addItem("Semester");
        filter.setBackground(new Color(50, 50, 50));
        filter.setForeground(Colors.PLAIN_TEXT);
        filter.setBorder(null);
        JComboBox<String> filter2 = new JComboBox<>();
        filter2.addItem("Course");
        filter2.setBackground(new Color(50, 50, 50));
        filter2.setForeground(Colors.PLAIN_TEXT);
        filter2.setBorder(null);

        options.add(filter);
        options.add(Box.createHorizontalGlue());
        options.add(filter2);
        add(options);
        add(Box.createVerticalStrut(20));

        JPanel resources = new JPanel();
        resources.setAlignmentX(Component.LEFT_ALIGNMENT);
        resources.setOpaque(false);
        resources.setLayout(new CardLayout());
        JPanel list = new JPanel();
        list.setBorder(new EmptyBorder(new Insets(50, 50, 50, 50)));
        list.setOpaque(false);
        list.setLayout(new GridLayout(2, 3, 50, 50));
        list.add(new Card("Syllabus", Icons.RESOURCES));
        list.add(new Card("Class Videos", Icons.RESOURCES));
        list.add(new Card("CT Questions", Icons.RESOURCES));
        list.add(new Card("Term Final Questions", Icons.RESOURCES));
        list.add(new Card("Lecture Notes", Icons.RESOURCES));
        list.add(new Card("Books", Icons.RESOURCES));
        resources.add(list);
        add(resources);
    }
}
