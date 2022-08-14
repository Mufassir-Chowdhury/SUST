package Common.pages.pageView.administrivia;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import Components.Label;
import Components.List;
import Components.Buttons.AccentButton;
import Components.InputFields.ComboBox;
import Components.pageView.Box.Options;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.ViewPort;
import Constants.Collections;
import Constants.Fonts;
import Constants.Icons;

import java.util.Vector;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Server.Datapoints;

public class course extends ViewPort {
    public course() {
        super("Course", null);
        ComboBox<String> usn = new ComboBox<>(Datapoints.getInstance().USN);
        ComboBox<String> semester = new ComboBox<>(Collections.SEMESTERS);
        add(new Options(usn, semester));
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
        for (Datapoints.Courses course : Datapoints.getInstance().COURSES) {
            courseNames.add(course.name);
        }
        List<String> available = new List<>(courseNames, false, ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        availableCourses.add(new Label("Available Course List", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        availableCourses.add(available);

        ListPanel registeredCourses = new ListPanel();
        List<String> registered = new List<>(courseNames, false, ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        registeredCourses.add(new Label("Registered Course List", Fonts.TITLE, Component.LEFT_ALIGNMENT));
        registeredCourses.add(registered);

        ListPanel transfer = new ListPanel();
        // TODO add icons for transfer
        transfer.add(new JLabel(Icons.TitleBar.BACK));
        transfer.add(new JLabel(Icons.TitleBar.BACK));

        resources.add(availableCourses);
        resources.add(Box.createHorizontalGlue());
        resources.add(transfer);
        resources.add(Box.createHorizontalGlue());
        resources.add(registeredCourses);
        add(resources);
        add(Box.createVerticalGlue());
        Box line = Box.createHorizontalBox();
        line.setAlignmentX(Component.LEFT_ALIGNMENT);
        line.add(Box.createHorizontalGlue());
        line.add(new AccentButton("Update"));
        line.add(Box.createHorizontalGlue());
        add(line);


        semester.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                available.removeAll();
                // String[] value = Datapoints.getInstance().CourseCode
                //         .get(Datapoints.getInstance().DETAILS)
                //         .get(Datapoints.getSemester(semester.getSelectedItem().toString()))
                //         .toArray(new String[0]);
                String[] value = Datapoints.getInstance().CourseCode
                            .get("CSE")
                            .get(Datapoints.getSemester(semester.getSelectedItem().toString()))
                            .toArray(new String[0]);
                available.setListData(value);
                // availableCourses.add(available);

            }
        });
    }
}
