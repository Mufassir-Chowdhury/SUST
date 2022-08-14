package Components.Buttons;

import Components.Background;
import Components.Label;
import Components.InputFields.ComboBox;
import Components.InputFields.TextArea;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;
import Constants.Collections;
import Constants.Fonts;
import Constants.Padding;
import Constants.Sizes;
import Server.Datapoints;
import Server.Datapoints.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JFrame;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.awt.Component;
import java.awt.Dimension;

public class AssignCourseButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel {

        String[] s = { " Select Department" };
        String[] ss = { " Select Semester" };
        String[] sss = { " Auto Generated after Selecting Semester" };
        String[] ssss = { " Auto Generated after Selecting Department" };

        ComboBox<String> departmentField = new ComboBox<>(s);
        // ComboBox<String> departmentField = new
        // ComboBox<>(Datapoints.getInstance().Departments);
        // ComboBox<String> semesterField = new ComboBox<>(Collections.SEMESTERS);
        ComboBox<String> semesterField = new ComboBox<>(ss);
        ComboBox<String> courseCodeField = new ComboBox<>(sss);
        ComboBox<String> teacherField = new ComboBox<>(ssss);

        public Dialog(Dimension size, JFrame frame) {

            setBorder(Padding.DIALOG_VIEW_PORT);
            setSize(size);

            add(new Label("Assign Course", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
            add(Box.createVerticalGlue());

            for (String item : Datapoints.getInstance().Departments)
                departmentField.addItem(item);

            for (String item : Collections.SEMESTERS)
                semesterField.addItem(item);

            TilesPanel tilesPanel = new TilesPanel(4, 2, 0, 10);
            tilesPanel.add(new Label("Department"));
            tilesPanel.add(departmentField);
            tilesPanel.add(new Label("Semester"));
            tilesPanel.add(semesterField);
            tilesPanel.add(new Label("Course Code"));
            tilesPanel.add(courseCodeField);
            tilesPanel.add(new Label("Teacher"));
            tilesPanel.add(teacherField);

            tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(tilesPanel);

            departmentField.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    teacherField.removeAllItems();
                    String[] value = Datapoints.getInstance().TeachersName
                            .get(departmentField.getSelectedItem().toString());
                    for (String item : value)
                        teacherField.addItem(item);
                }
            });

            semesterField.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    courseCodeField.removeAllItems();
                    String[] value = Datapoints.getInstance().CourseCode
                            .get(departmentField.getSelectedItem().toString())
                            .get(Datapoints.getSemester(semesterField.getSelectedItem().toString()))
                            .toArray(new String[0]);
                    for (String item : value)
                        courseCodeField.addItem(item);
                }
            });

            add(Box.createVerticalGlue());

            AccentButton proceed = new AccentButton("Assign");
            proceed.setAlignmentX(Component.CENTER_ALIGNMENT);
            proceed.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        fetchDataAndPassToClient();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    frame.dispose();
                }
            });
            add(proceed);
        }

        protected void fetchDataAndPassToClient() throws IOException {
            Datapoints.getInstance().client.add(new String[] { departmentField.getSelectedItem().toString(),
                    teacherField.getSelectedItem().toString(),
                    courseCodeField.getSelectedItem().toString() }, Datapoints.ASSIGN_COURSE);
        }
    }

    public AssignCourseButton() {
        super("Assign Course");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO make a new size of its own
        Dimension size = Sizes.DIALOG.EVENT;
        Background frame = new Background(size, new JFrame());
        frame.add(new Dialog(size, frame));
        frame.setVisible(true);
    }
}
