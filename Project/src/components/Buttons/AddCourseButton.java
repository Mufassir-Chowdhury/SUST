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

public class AddCourseButton extends AccentButton implements ActionListener {
    public class Dialog extends ListPanel {
        
        ComboBox<String> departmentField = new ComboBox<>(Datapoints.getInstance().Departments);
        ComboBox<String> semesterField = new ComboBox<>(Collections.SEMESTERS);
        TextField titleField = new TextField("Write Course Title", TYPE.PLAIN);
        TextField courseCodeField = new TextField("Write Course Code", TYPE.PLAIN);
        TextField creditField = new TextField("Write Duration (9AM - 5PM)", TYPE.PLAIN);
        
        
        TextField locationField = new TextField("Write Location", TYPE.PLAIN);
        TextField organizerField = new TextField("Write Organizer", TYPE.PLAIN);
        TextArea descriptionField = new TextArea("Write Description", true);

        public Dialog(Dimension size, JFrame frame) {
            
            setBorder(Padding.DIALOG_VIEW_PORT);
            setSize(size);

            add(new Label("Add New Course", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
            add(Box.createVerticalGlue());

            TilesPanel tilesPanel = new TilesPanel(6, 2, 0, 10);
            tilesPanel.add(new Label("Event For"));
            // tilesPanel.add(eventForField);
            tilesPanel.add(new Label("Title"));
            tilesPanel.add(titleField);
            tilesPanel.add(new Label("Date"));
            // tilesPanel.add(dateField);
            tilesPanel.add(new Label("Duration"));
            // tilesPanel.add(durationField);
            tilesPanel.add(new Label("Location"));
            tilesPanel.add(locationField);
            tilesPanel.add(new Label("Organizer"));
            tilesPanel.add(organizerField);
            tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(tilesPanel);
            add(Box.createVerticalGlue());
            
            add(descriptionField);
            
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
            DateTimeFormatter date = DateTimeFormatter.ofPattern("MMMM dd, u");
            LocalDate localDate = LocalDate.now();
            // Event event = new Event(eventForField.getSelectedItem().toString(), titleField.getText(),
            //         dateField.getText(), descriptionField.getText(), locationField.getText(), durationField.getText(),
            //         organizerField.getText(),"Admin",date.format(localDate), 0, 0);
            // Datapoints.getInstance().client.add(event, Datapoints.ADD_EVENT);
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
