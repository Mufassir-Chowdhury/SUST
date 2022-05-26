package pages.pageView.administrivia;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JList;

import javax.swing.JPanel;

import Components.InputFields.ComboBox;
import Components.pageView.Title;

import java.util.Vector;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Dimension;

import Server.Datapoints;

public class course extends JPanel {
    public course(){
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new Title("Course", null));
        add(Box.createVerticalStrut(20));

        Box options = Box.createHorizontalBox();
        options.setMaximumSize(new Dimension(1000, 40));
        options.setAlignmentX(Component.LEFT_ALIGNMENT);
        ComboBox<String> filter = new ComboBox<>();
        filter.addItem("USN");
        ComboBox<String> filter2 = new ComboBox<>();
        filter2.addItem("Semester");

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
