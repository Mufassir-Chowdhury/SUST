package pages.pageView.course_information;

import javax.swing.Box;
import javax.swing.BoxLayout;

import java.awt.CardLayout;

import javax.swing.JPanel;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

import Components.Card;
import Components.Buttons.AccentButton;
import Components.InputFields.ComboBox;
import Components.pageView.Title;

import java.awt.Component;
import Constants.Icons;

public class resources extends JPanel {
    public resources(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Title("Resources", new AccentButton("Post New Material")));
        add(Box.createVerticalStrut(20));

        Box options = Box.createHorizontalBox();
        options.setAlignmentX(Component.LEFT_ALIGNMENT);
        ComboBox<String> filter = new ComboBox<>();
        filter.addItem("Semester");
        ComboBox<String> filter2 = new ComboBox<>();
        filter2.addItem("Course");

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
