package pages.pageView.administrivia;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.Insets;
import java.util.Vector;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

import Components.Card;
import Components.Label;
import Components.Tools;

import java.awt.Component;
import java.awt.Dimension;

import Constants.Colors;
import Constants.Fonts;
import Constants.Icons;
import Server.Datapoints;

public class course extends JPanel {
    public course(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box title = Box.createHorizontalBox();
        title.setAlignmentX(Component.LEFT_ALIGNMENT);
        title.add(new Label("Payment", Fonts.DISPLAY));
        add(title);
        add(Box.createVerticalStrut(20));

        Box options = Box.createHorizontalBox();
        options.setMaximumSize(new Dimension(1000, 40));
        options.setAlignmentX(Component.LEFT_ALIGNMENT);
        JComboBox<String> filter = new JComboBox<>();
        filter.addItem("USN");
        filter.setBackground(new Color(50, 50, 50));
        filter.setForeground(Colors.PLAIN_TEXT);
        filter.setBorder(null);
        JComboBox<String> filter2 = new JComboBox<>();
        filter2.addItem("Semester");
        filter2.setBackground(new Color(50, 50, 50));
        filter2.setForeground(Colors.PLAIN_TEXT);
        filter2.setBorder(null);

        options.add(filter);
        options.add(Box.createHorizontalGlue());
        options.add(filter2);
        add(options);
        add(Box.createVerticalStrut(50));

        JPanel resources = new JPanel();
        resources.setAlignmentX(Component.LEFT_ALIGNMENT);
        resources.setOpaque(false);
        resources.setLayout(new GridLayout(1, 2, 20, 20));
        JPanel availableCourses = new JPanel();
        Vector<String> courseNames = new Vector<>();
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
            courseNames.add(course.name);
        }
        JList<String> available = new JList<>(courseNames);
        available.setAlignmentX(Component.LEFT_ALIGNMENT);
        availableCourses.add(available);

        JPanel registeredCourses = new JPanel();
        JList<String> registered = new JList<>();
        registered.setAlignmentX(Component.LEFT_ALIGNMENT);
        registeredCourses.add(registered);

        resources.add(availableCourses);
        resources.add(registeredCourses);
        add(resources);
    }
}
