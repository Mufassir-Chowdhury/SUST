package Components.Buttons;

import Components.Background;
import Components.Card;
import Components.Label;
import Components.InputFields.ComboBox;
import Components.InputFields.TextField;
import Components.InputFields.TextField.TYPE;
import Components.pageView.Panels.ListPanel;
import Components.pageView.Panels.TilesPanel;
import Constants.Fonts;
import Constants.Icons;
import Constants.Padding;
import Constants.Sizes;
import Server.Datapoints;
import Server.Datapoints.Student;
import Server.Datapoints.Teacher;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JFrame;

import java.awt.Component;

public class RegisterProfile extends AccentButton implements ActionListener {

    JFrame frame = new JFrame();
    JFrame frame2 = new JFrame();
    JFrame frame3 = new JFrame();

    Dimension size;

    public class Dialog extends ListPanel {

        String[] bgGroup = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };
        String[] semester = { "1-1", "1-2", "2-1", "2-2", "3-1", "3-2", "4-1", "4-2" };
        String[] designation = { "Lecturer", "Assistant Professor", "Professor" };

        ComboBox<String> departmentField = new ComboBox<>(Datapoints.getInstance().Departments);
        TextField registrationField = new TextField("Write Registration", TYPE.PLAIN);

        TextField nameField = new TextField("Write Name", TYPE.PLAIN);
        ComboBox<String> DesignationField = new ComboBox<>(designation);
        TextField sessionField = new TextField("Write Session", TYPE.PLAIN);
        ComboBox<String> semesterField = new ComboBox<>(semester);

        TextField numberField = new TextField("Write Number", TYPE.PLAIN);
        TextField emailField = new TextField("Write Email", TYPE.PLAIN);
        ComboBox<String> bloodField = new ComboBox<>(bgGroup);
        TextField birthdayField = new TextField("Write Birthday", TYPE.PLAIN);
        TextField hometownField = new TextField("Write Hometown", TYPE.PLAIN);

        public Dialog(Dimension size, JFrame frame, String type) {

            
            setSize(size);

            if (type == "Choose") {
                setBorder(Padding.MINI_DIALOG_VIEW_PORT);
                add(new Label("CHOOSE", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
                Box line = Box.createHorizontalBox();

                Card Teacher = new Card("Teacher",Icons.Role.TEACHER);
                Teacher.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                        again("Teacher");
                        frame.dispose();
                    }
                });


                Card Student = new Card("Student",Icons.Role.STUDENT);
                Student.addMouseListener(new MouseAdapter(){
                    public void mouseClicked(MouseEvent e){
                        again("Student");
                        frame.dispose();
                    }
                });

                line.add(Teacher);
                line.add(Box.createHorizontalStrut(30));
                line.add(Student);

                add(line);
            } else {
                setBorder(Padding.DIALOG_VIEW_PORT);
                
                TilesPanel tilesPanel;
                if (type == "Student") {
                    add(new Label("Student  Registration", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
                    tilesPanel = new TilesPanel(9, 2, 10);
                    tilesPanel.add(new Label("Registration"));
                    tilesPanel.add(registrationField);
                } else {
                    add(new Label("Teacher  Registration", Fonts.DISPLAY, Component.CENTER_ALIGNMENT));
                    tilesPanel = new TilesPanel(8, 2, 10);
                    tilesPanel.add(new Label("Department"));
                    tilesPanel.add(departmentField);
                }

                add(Box.createVerticalGlue());
                tilesPanel.add(new Label("Name"));
                tilesPanel.add(nameField);

                if (type == "Student") {
                    tilesPanel.add(new Label("Session (20xx-xx)"));
                    tilesPanel.add(sessionField);
                    tilesPanel.add(new Label("Semester"));
                    tilesPanel.add(semesterField);
                } else {
                    tilesPanel.add(new Label("Designation"));
                    tilesPanel.add(DesignationField);
                }
                tilesPanel.add(new Label("Email"));
                tilesPanel.add(emailField);
                tilesPanel.add(new Label("Number (Without +88)"));
                tilesPanel.add(numberField);
                tilesPanel.add(new Label("Blood Group (X+/-)"));
                tilesPanel.add(bloodField);
                tilesPanel.add(new Label("Birthday (DD/MM/YYYY)"));
                tilesPanel.add(birthdayField);
                tilesPanel.add(new Label("Hometown"));
                tilesPanel.add(hometownField);

                tilesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

                add(tilesPanel);
                add(Box.createVerticalGlue());
                add(new FileButton("Choose a photo"));
                add(Box.createVerticalGlue());
                AccentButton proceed = new AccentButton("Proceed");
                proceed.setAlignmentX(Component.CENTER_ALIGNMENT);
                proceed.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            fetchDataAndPassToClient(type);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        frame.dispose();
                    }
                });

                add(proceed);
            }
        }

        protected void again(String Type) {
            size = new Dimension((int) (Sizes.DEFAULT_WINDOW_SIZE.getWidth() / 1.2),
                    (int) (Sizes.DEFAULT_WINDOW_SIZE.getHeight() / 1.15));

            frame = new Background(size, frame);
            frame.add(new Dialog(size, frame, Type));

            frame.setLocation((int) (Sizes.DEFAULT_WINDOW_SIZE.getWidth() - size.getWidth()) / 2,
                    (int) (Sizes.DEFAULT_WINDOW_SIZE.getHeight() - size.getHeight()) / 2);

            frame.setVisible(true);
        }

        private void fetchDataAndPassToClient(String type) throws IOException {
            if (type == "Student") {
                Student student = new Student(registrationField.getText(), nameField.getText(), emailField.getText(),
                        numberField.getText(), bloodField.getSelectedItem().toString(), birthdayField.getText(),
                        hometownField.getText(),
                        sessionField.getText(), semesterField.getSelectedItem().toString(), null, null);
                Datapoints.getInstance().client.add(student, Datapoints.ADD_STUDENT);
            }
            if (type == "Teacher") {
                Teacher teacher = new Teacher(departmentField.getSelectedItem().toString(), nameField.getText(),
                        emailField.getText(), DesignationField.getSelectedItem().toString(), numberField.getText(),
                        bloodField.getSelectedItem().toString(), birthdayField.getText(), hometownField.getText(), null);
                Datapoints.getInstance().client.add(teacher, Datapoints.ADD_TEACHER);
            }
        }
    }

    public RegisterProfile() {
        super("Add new Profile");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        size = new Dimension((int) (Sizes.DEFAULT_WINDOW_SIZE.getWidth() / 2.5),
                (int) (Sizes.DEFAULT_WINDOW_SIZE.getHeight() / 2.5));

        frame = new Background(size, frame);

        frame.add(new Dialog(size, frame, "Choose"));
        frame.setLocation((int) (Sizes.DEFAULT_WINDOW_SIZE.getWidth() - size.getWidth()) / 2,
                (int) (Sizes.DEFAULT_WINDOW_SIZE.getHeight() - size.getHeight()) / 2);

        frame.setVisible(true);

    }
}
