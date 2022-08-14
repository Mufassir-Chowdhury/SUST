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
import Server.Datapoints.Course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JFrame;


import java.awt.Component;
import java.awt.Dimension;

public class AddCourseButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel {
        String[] courseType = { "Theory", "Lab" };

        ComboBox<String> departmentField = new ComboBox<>(Datapoints.getInstance().Departments);
        ComboBox<String> semesterField = new ComboBox<>(Collections.SEMESTERS);
        TextField titleField = new TextField("Write Course Title", TYPE.PLAIN);
        TextField courseCodeField = new TextField("Write Course Code", TYPE.PLAIN);
        ComboBox<String> courseTypeField = new ComboBox<>(courseType);
        TextField creditField = new TextField("Write Credit", TYPE.PLAIN);
        TextArea syllabusField = new TextArea("Write syllabus", true);
        

        public Dialog(Dimension size, JFrame frame) {
            
            setBorder(Padding.DIALOG_VIEW_PORT);
            setSize(size);

            add(new Label("Add New Course", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
            add(Box.createVerticalGlue());

            TilesPanel tilesPanel = new TilesPanel(6, 2, 0, 10);
            tilesPanel.add(new Label("Department"));
            tilesPanel.add(departmentField);
            tilesPanel.add(new Label("Semester"));
            tilesPanel.add(semesterField);
            tilesPanel.add(new Label("Course Title"));
            tilesPanel.add(titleField);
            tilesPanel.add(new Label("Course Code"));
            tilesPanel.add(courseCodeField);
            tilesPanel.add(new Label("Course Type"));
            tilesPanel.add(courseTypeField);
            tilesPanel.add(new Label("Course Credit"));
            tilesPanel.add(creditField);
            tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(tilesPanel);
            add(Box.createVerticalGlue());
            
            add(syllabusField);
            
            add(Box.createVerticalStrut(10));
            
            AccentButton proceed = new AccentButton("Proceed");
            proceed.setAlignmentX(Component.CENTER_ALIGNMENT);
            proceed.addActionListener(new ActionListener(){
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

            Course course = new Course(courseCodeField.getText(), titleField.getText(), creditField.getText(),
                    departmentField.getSelectedItem().toString(), semesterField.getSelectedItem().toString(),
                    courseTypeField.getSelectedItem().toString(), syllabusField.getText());
            
            Datapoints.getInstance().client.add(course, Datapoints.ADD_COURSE);
        }
    }
    public AddCourseButton(){
        super("Add New Course");
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
