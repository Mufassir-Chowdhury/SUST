package pages.pageView.administrivia;

import javax.swing.Box;
import javax.swing.JList;

import javax.swing.JPanel;

import Components.pageView.ViewPort;
import Components.pageView.Box.Options;

import java.util.Vector;
import java.awt.GridLayout;
import java.awt.Component;

import Server.Datapoints;

public class course extends ViewPort {
    public course(){
        super("Course", null);

        add(new Options(Datapoints.getInstance().USN, Datapoints.getInstance().SEMESTER));
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
