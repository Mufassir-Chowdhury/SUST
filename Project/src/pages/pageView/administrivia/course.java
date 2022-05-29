package pages.pageView.administrivia;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import Components.Label;
import Components.List;
import Components.pageView.Box.Options;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.ViewPort;
import Constants.Fonts;
import Constants.Icons;

import java.util.Vector;
import java.awt.Component;
import Server.Datapoints;

public class course extends ViewPort {
    public course(){
        super("Course", null);

        add(new Options(Datapoints.getInstance().USN, Datapoints.getInstance().SEMESTER));
        add(Box.createVerticalStrut(25));
        add(new Label("Registration Date: 2019-03-05 to 2019-04-03"));
        add(Box.createVerticalStrut(25));
        add(new Label("Last Admitted Semester: 3rd Semester"));
        add(Box.createVerticalGlue());

        JPanel resources = new JPanel();
        resources.setAlignmentX(Component.LEFT_ALIGNMENT);
        resources.setOpaque(false);
        resources.setLayout(new BoxLayout(resources, BoxLayout.X_AXIS));

        ListPanel availableCourses = new ListPanel();
        Vector<String> courseNames = new Vector<>();
        for(Datapoints.Courses course: Datapoints.getInstance().COURSES){
            courseNames.add(course.name);
        }
        List<String> available = new List<String>(courseNames, false, ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        availableCourses.add(new Label("Available Course List"));
        availableCourses.add(available);

        ListPanel registeredCourses = new ListPanel();
        List<String> registered = new List<String>(courseNames, false, ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        registeredCourses.add(new Label("Registered Course List", Fonts.TITLE, Component.CENTER_ALIGNMENT));
        registeredCourses.add(registered);

        ListPanel transfer = new ListPanel();
        transfer.add(new JLabel(Icons.BACK));
        transfer.add(new JLabel(Icons.BACK));

        resources.add(availableCourses);
        resources.add(Box.createHorizontalGlue());
        resources.add(transfer);
        // resources.add(new JSeparator(JSeparator.VERTICAL));
        resources.add(Box.createHorizontalGlue());
        resources.add(registeredCourses);
        add(resources);
    }
}
